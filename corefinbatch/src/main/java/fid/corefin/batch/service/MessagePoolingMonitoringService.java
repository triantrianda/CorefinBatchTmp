package fid.corefin.batch.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import fid.corefin.batch.data.OtpArchiveRepository;
import fid.corefin.batch.data.OverdueMessagePoolRepository;
import fid.corefin.batch.data.SummaryProcessRepository;
import fid.corefin.batch.data.WaOtpRepository;
import fid.corefin.batch.data.WaPoolRepository;
import fid.corefin.batch.model.entity.OtpArchive;
import fid.corefin.batch.model.entity.SummaryProcess;
import fid.corefin.batch.model.entity.WaOTP;
import fid.corefin.batch.model.entity.WaPooling;
import fid.corefin.batch.util.CommonUtil;

@Singleton
public class MessagePoolingMonitoringService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	OverdueMessagePoolRepository overdueMessagePoolRepository;
	
	@Inject
	SummaryProcessRepository summaryProcessRepository;
	
	@Inject
	WaPoolRepository waPoolRepository;
	
	@Inject
	WaOtpRepository waOtpRepository;
	
	@Inject
	OtpArchiveRepository otpArchiveRepository;
	
	protected String overdueMessage = "OverdueMessagePooling";
	protected String waPool = "WaPool";
	protected String waSendTemplate = "WaSendTemplate";
	protected String waOtp = "WaOtp";
	private int totalPlanPooling = 0;
	
	public List<WaPooling> getMessagePoolBatchList (Date date) throws Exception {
		List<WaPooling> listWaPooling = new ArrayList<WaPooling>();
		if(!checkData(date, waPool)) {
			initFirstData(date);
		}else {
			insertAndUpdateData(date);
		}
		listWaPooling = waPoolRepository.getListWaPooling();
		return listWaPooling;
	}
	
	public List<WaOTP> getMessageOtpBatchList (Date date){
		List<WaOTP> waOtpList = new ArrayList<WaOTP>();
		try {
			if(!checkData(date, waOtp)) {
				initOtpFirstData(date);
			}else {
				insertAndUpdateDataOtp(date);
			}
			waOtpList = waOtpRepository.getAllWaOtpList();
			return waOtpList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return waOtpList;
	}
	
	public void initFirstData(Date date) {
		int init = 2;	
		try {
			for(int i=0;i<init;i++) {
				totalPlanPooling = overdueMessagePoolRepository.getOverdueMessageCount(date);
				WaPooling waPool = new WaPooling();
				waPool.setDate(date);
				waPool.setTotalPlanPool(totalPlanPooling);
				waPool.setTotalActualPool(0);
				waPool.setDeviationData(totalPlanPooling - waPool.getTotalActualPool());
				waPoolRepository.saveFlush(waPool);
						
				date = getNextDay(date, 1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void initOtpFirstData(Date date) {
		int init = 2;	
		try {
			for(int i=0;i<init;i++) {
				WaOTP waOtp = new WaOTP();
				waOtp.setDate(date);
				waOtp.setOtpSuccess(0);
				waOtp.setOtpFailed(0);
				waOtp.setOtpObsolete(0);
				waOtpRepository.saveFlush(waOtp);
						
				date = getNextDay(date, 1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void insertAndUpdateData(Date date) { 
		int actualPool = 0;
		try {
		List<WaPooling> waPoolUpdate = waPoolRepository.getByDateAndTotalActualData(date);
		if(CommonUtil.isNotNullOrEmpty(waPoolUpdate)) {
			for(WaPooling waPool : waPoolUpdate) {
				actualPool = getActualPoolData(waPool);
				waPool.setTotalActualPool(actualPool);
				waPool.setDeviationData(waPool.getTotalPlanPool() - waPool.getTotalActualPool());
				waPoolRepository.merge(waPool);
				}
			}
		if(!checkData(getNextDay(date, 1), waPool)){
			totalPlanPooling = overdueMessagePoolRepository.getOverdueMessageCount(getNextDay(date, 1));
			WaPooling waPool = new WaPooling();
			waPool.setDate(getNextDay(date, 1));
			waPool.setTotalPlanPool(totalPlanPooling);
			waPool.setTotalActualPool(0);
			waPool.setDeviationData(totalPlanPooling - waPool.getTotalActualPool());
			waPoolRepository.saveFlush(waPool);
		}
		}catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	public void insertAndUpdateDataOtp(Date date) { 
		try {
		List<WaOTP> waOtpUpdate = waOtpRepository.getWaOtpListToUpdate(date);
		if(CommonUtil.isNotNullOrEmpty(waOtpUpdate)) {
			for(WaOTP waOtp : waOtpUpdate) {
				waOtp = updateOtpStatus(waOtp);
				waOtpRepository.merge(waOtp);
				}
			}
		if(!checkData(getNextDay(date, 1), waOtp)){
			WaOTP waOtp = new WaOTP();
			waOtp.setDate(getNextDay(date, 1));
			waOtp.setOtpSuccess(0);
			waOtp.setOtpFailed(0);
			waOtp.setOtpObsolete(0);
			waOtpRepository.saveFlush(waOtp);
		}
		}catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	public WaOTP updateOtpStatus(WaOTP waOtp) {
		try {
			int otpSuccess = 0;
			int otpFailed = 0;
			int otpObsolete = 0;
			List<OtpArchive> otpArc = otpArchiveRepository.getListByDate(waOtp.getDate());
			if(CommonUtil.isNotNullOrEmpty(otpArc)) {
				for(OtpArchive otp : otpArc) {
					if(otp.getOtpInput().equals(otp.getOtpInputChallenge())) {
						otpSuccess++;
					}else if(!otp.getOtpInput().equals(otp.getOtpInputChallenge())&&CommonUtil.isNotNullOrEmpty(otp.getOtpInputChallenge())) {
						otpFailed++;
					}else{
						otpObsolete++;
					}
				}
			}
			waOtp.setOtpSuccess(otpSuccess);
			waOtp.setOtpFailed(otpFailed);
			waOtp.setOtpObsolete(otpObsolete);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return waOtp;
	}
	
	public int getActualPoolData(WaPooling wa) {
		int totalActual = 0;
		try {
		SummaryProcess summaryActualPooling = summaryProcessRepository.getSummaryProcessByDate(wa.getDate(), overdueMessage);
		if(CommonUtil.isNotNullOrEmpty(summaryActualPooling)) {
			String total = summaryActualPooling.getDescription();
			String[] arr = total.split(":");
			String[] arr2 = arr[1].split(",");
			totalActual = Integer.valueOf(arr2[0].trim());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return totalActual;
	}
	
	public Date getNextDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
	public boolean checkData(Date date, String module) {
		boolean result = false;
		switch(module) {
			case "WaPool":
				WaPooling waPool =  waPoolRepository.getByDate(date);
				if(CommonUtil.isNotNullOrEmpty(waPool)) {
					result = true;
				}
				break;
			case "WaSendTemplate":
				break;
			case "WaOtp":
				WaOTP waOtp = waOtpRepository.getWaOtpByDate(date);
				if(CommonUtil.isNotNullOrEmpty(waOtp)) {
					result = true;
				}
				break;
			default:
				break;
		}
		return result;
	}
	
}
