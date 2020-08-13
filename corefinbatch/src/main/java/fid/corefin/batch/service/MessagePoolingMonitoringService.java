package fid.corefin.batch.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import fid.corefin.batch.data.ArchiveRepository;
import fid.corefin.batch.data.GeneralInfoRepository;
import fid.corefin.batch.data.OtpArchiveRepository;
import fid.corefin.batch.data.OverdueMessagePoolRepository;
import fid.corefin.batch.data.SummaryProcessRepository;
import fid.corefin.batch.data.WaOtpRepository;
import fid.corefin.batch.data.WaPoolRepository;
import fid.corefin.batch.data.WaSendTemplateRepository;
import fid.corefin.batch.model.entity.Archive;
import fid.corefin.batch.model.entity.OtpArchive;
import fid.corefin.batch.model.entity.SummaryProcess;
import fid.corefin.batch.model.entity.WaOTP;
import fid.corefin.batch.model.entity.WaPooling;
import fid.corefin.batch.model.entity.WaSendTemplate;
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
	
	@Inject
	ArchiveRepository archiveRepository;
	
	@Inject
	WaSendTemplateRepository waSendTemplateRepository;
	
	@Inject
	GeneralInfoRepository generalInfoRepository;
	
	protected String overdueMessagePooling = "OverdueMessagePooling";
	protected String waSendTemplate = "SendTemplateMessageWA";
	protected String waOtp = "WaOtp";
	private int totalPlanPooling = 0;
	private int totalPlanSend = 0;
	
	public List<WaPooling> getMessagePoolBatchList (Date date) throws Exception {
		List<WaPooling> listWaPooling = new ArrayList<WaPooling>();
		if(!checkData(date, overdueMessagePooling)) {
			initFirstData(date);
		}else {
			insertAndUpdateData(date);
		}
		listWaPooling = waPoolRepository.getListWaPooling();
		return listWaPooling;
	}
	
	public List<WaSendTemplate> getMessageSendTemplateBatchList(Date date) throws Exception {
		List<WaSendTemplate> listWaSend = new ArrayList<WaSendTemplate>();
		if(!checkData(date, waSendTemplate)) {
			initSendTemplateFirstData(date);
		}else {
			insertAndUpdateSendData(date);
		}
		listWaSend = waSendTemplateRepository.getAllWaSendTemplateList();
		return listWaSend;
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
				waPool.setTotalActualPool(getActualData(waPool.getDate(), overdueMessagePooling));
				waPool.setDeviationData(totalPlanPooling - waPool.getTotalActualPool());
				waPoolRepository.saveFlush(waPool);
				date = getNextDay(date, 1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void initSendTemplateFirstData(Date date) {
		boolean nextDay = false;
		int init = 2;
		try {
			for(int i=0;i<init;i++) {
				totalPlanSend = generalInfoRepository.getAllGeneralList().size();
				WaSendTemplate waSend = new WaSendTemplate();
				waSend.setDate(date);
				waSend.setTotalPlanSendTemplate(nextDay?0:totalPlanSend);
				waSend.setTotalActualSendTemplate(nextDay?0:getActualData(date, waSendTemplate));
				waSend.setPendingEnroute(0);
				waSend.setReject(0);
				waSend.setError(0);
				waSend.setDeviationData(waSend.getTotalPlanSendTemplate() - waSend.getTotalActualSendTemplate());
				waSendTemplateRepository.saveFlush(waSend);
				date = getNextDay(date, 1);
				nextDay = true;
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
				updateOtpStatus(waOtp);
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
		List<WaPooling> waPoolUpdate = waPoolRepository.getByDateAndTotalActualData(getNextDay(date, 1));
		if(CommonUtil.isNotNullOrEmpty(waPoolUpdate)) {
			for(WaPooling waPool : waPoolUpdate) {
				actualPool = getActualData(waPool.getDate(), overdueMessagePooling);
				waPool.setTotalActualPool(actualPool);
				waPool.setDeviationData(waPool.getTotalPlanPool() - waPool.getTotalActualPool());
				waPoolRepository.merge(waPool);
				}
			}
		if(!checkData(getNextDay(date, 1), overdueMessagePooling)){
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
	
	public void insertAndUpdateSendData(Date date) { 
		try {
		List<WaSendTemplate> waSendUpdate = waSendTemplateRepository.getListWaSendToUpdateByDate(getNextDay(date, 1));
		if(CommonUtil.isNotNullOrEmpty(waSendUpdate)) {
			for(WaSendTemplate waSend : waSendUpdate) {
				if(waSend.getDate().compareTo(date) == 0) {
					if(waSend.getTotalPlanSendTemplate() == 0) {
						totalPlanSend = generalInfoRepository.getAllGeneralList().size();
						waSend.setTotalPlanSendTemplate(totalPlanSend);
					}
					waSend.setTotalActualSendTemplate(getActualData(waSend.getDate(), waSendTemplate));
					waSend = getStatusSend(waSend);
					waSend.setDeviationData(waSend.getTotalPlanSendTemplate() - waSend.getTotalActualSendTemplate());
				}else {
					waSend = getStatusSend(waSend);
					waSend.setTotalActualSendTemplate(getActualData(waSend.getDate(), waSendTemplate));
					waSend.setDeviationData(waSend.getTotalPlanSendTemplate() - waSend.getTotalActualSendTemplate());
				}
				waPoolRepository.merge(waSend);
			}
		}
		if(!checkData(getNextDay(date, 1), waSendTemplate)){
			WaSendTemplate waSend = new WaSendTemplate();
			waSend.setDate(getNextDay(date, 1));
			waSend.setTotalPlanSendTemplate(0);
			waSend.setTotalActualSendTemplate(0);
			waSend.setPendingEnroute(0);
			waSend.setReject(0);
			waSend.setError(0);
			waSend.setDeviationData(waSend.getTotalPlanSendTemplate() - waSend.getTotalActualSendTemplate());
			waSendTemplateRepository.saveFlush(waSend);
		}
		}catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	public void insertAndUpdateDataOtp(Date date) { 
		try {
		List<WaOTP> waOtpUpdate = waOtpRepository.getWaOtpListToUpdate(getNextDay(date, 1));
		if(CommonUtil.isNotNullOrEmpty(waOtpUpdate)) {
			for(WaOTP waOtp : waOtpUpdate) {
				updateOtpStatus(waOtp);
				waOtpRepository.merge(waOtp);
				}
			}
		if(!checkData(getNextDay(date, 1), waOtp)){
			WaOTP waOtp = new WaOTP();
			waOtp.setDate(getNextDay(date, 1));
			updateOtpStatus(waOtp);
			waOtpRepository.saveFlush(waOtp);
		}
		}catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	public void updateOtpStatus(WaOTP waOtp) {
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
	}
	
	public int getActualData(Date date, String processType) {
		int totalActual = 0;
		try {
		SummaryProcess summaryActualPooling = summaryProcessRepository.getSummaryProcessByDate(date, processType);
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
			case "OverdueMessagePooling":
				WaPooling waPool =  waPoolRepository.getByDate(date);
				if(CommonUtil.isNotNullOrEmpty(waPool)) {
					result = true;
				}
				break;
			case "SendTemplateMessageWA":
				WaSendTemplate waSend = waSendTemplateRepository.getByDate(date);
				if(CommonUtil.isNotNullOrEmpty(waSend)) {
					result = true;
				}
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
	
	public WaSendTemplate getStatusSend(WaSendTemplate waSend) {
		try {
			int pending = 0;
			int reject = 0;
			int error = 0;
			List<Archive> list = archiveRepository.getListByDate(waSend.getDate());
			if(CommonUtil.isNotNullOrEmpty(list)) {
				for(Archive arc : list) {
					if(arc.getStatus().toUpperCase().contains("PENDING")) {
						pending++;
					}else if(arc.getStatus().toUpperCase().contains("REJECT")) {
						reject++;
					}
					else {
						error++;
					}
				}
			}
			waSend.setPendingEnroute(pending);
			waSend.setReject(reject);
			waSend.setError(error);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return waSend;
	}
	
}
