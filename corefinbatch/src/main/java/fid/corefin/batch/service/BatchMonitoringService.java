package fid.corefin.batch.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.apache.logging.log4j.Logger;

import fid.corefin.batch.data.GlJournalQueueRepository;
import fid.corefin.batch.data.MobileNotificationArchiveRepository;
import fid.corefin.batch.data.MobileNotificationRepository;
import fid.corefin.batch.data.MobileSyncArchiveRepository;
import fid.corefin.batch.data.MobileSyncRepository;
import fid.corefin.batch.data.GlJournalQueueArchiveRepository;
import fid.corefin.batch.model.entity.GlJournalQueue;
import fid.corefin.batch.model.entity.GlJournalQueueArchive;
import fid.corefin.batch.model.entity.MobileNotification;
import fid.corefin.batch.model.entity.MobileNotificationArchive;
import fid.corefin.batch.model.entity.MobileSync;
import fid.corefin.batch.model.entity.MobileSyncArchive;
import fid.corefin.batch.util.CommonUtil;

@Singleton
public class BatchMonitoringService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject
	private GlJournalQueueRepository glJournalQueueRepository;
	
	@Inject
	private GlJournalQueueArchiveRepository glJournalQueueArchiveRepository;
	
	@Inject 
	private MobileSyncRepository mobileSyncRepository;
	
	@Inject
	private MobileSyncArchiveRepository mobileSyncArchiveRepository;
	
	@Inject
	private MobileNotificationRepository mobileNotificationRepository;
	
	@Inject
	private MobileNotificationArchiveRepository mobileNotificationArchiveRepository;
	
	@Inject
	private Logger logger;
	
//	@Transactional(readOnly = true)
//	public String getParameterValue(int id) {
//		try {
//			Parameter param = paramRepository.getParameterById(id);
//			return param.getValue();
//		}catch (Exception e) {
//			e.printStackTrace();
//			//logger.error("Failed to fetch data ||"+ e.getMessage());
//			throw e;
//		}
//	}
	
	@Transactional(readOnly = true)
	public char getParameterValueGlJournalQue(int id) {
		try {
			GlJournalQueue param = glJournalQueueRepository.getParameterById(id);
			return param.getStatus();
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to fetch data ||"+ e.getMessage());
			throw e;
		}
	}
	
	@SuppressWarnings("static-access")
	public List<GlJournalQueue> getGlJournalQueue(String createDate) throws Exception {
		try {
			List<GlJournalQueue> listData = glJournalQueueRepository.getGlJournalQueue(createDate);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueue> getGlJournalQueueFromTo(String from, String to) throws Exception {
		try {
			List<GlJournalQueue> listData = glJournalQueueRepository.getGlJournalQueueFromTo(from, to);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueue> getGlJournalQueueFromToWithModule(String from, String to, String module) throws Exception {
		try {
			List<GlJournalQueue> listData = glJournalQueueRepository.getGlJournalQueueFromToWithModule(from, to, module);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueue> getGlJournalQueueByRefId(String refId) throws Exception{
		try {
			List<GlJournalQueue> listData = glJournalQueueRepository.getGlJournalQueueByRefId(refId);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	@SuppressWarnings("static-access")
	public List<GlJournalQueueArchive> getGlJournalQueueArchive(String createDate) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchive(createDate);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveFromTo(String from, String to) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchiveFromTo(from, to);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveFromToWithModule(String from, String to, String module) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchiveFromToWithModule(from, to, module);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveByRefId(String refId) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchiveByRefId(refId);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveByJournalId(String journalId) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchiveByJournalId(journalId);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileSync> getMobileSyncCurrentDate(Date date) throws Exception {
		try {
			Date nextDate = getNextDay(date, 1);
			String dateMillis = String.valueOf(date.getTime());
			String nextDateMillis = String.valueOf(nextDate.getTime());
			List<MobileSync> listData = mobileSyncRepository.getMobileSyncByExecutionDate(dateMillis, nextDateMillis);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Synchronize || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileSync> getMobileSyncByExecutionDate(Date from, Date to) throws Exception {
		try {
			Date nextDate = getNextDay(to, 1);
			String fromMilis = String.valueOf(from.getTime());
			String toMilis = String.valueOf(nextDate.getTime());
			List<MobileSync> listData = mobileSyncRepository.getMobileSyncByExecutionDate(fromMilis, toMilis);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Synchronize || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileSync> getMobileSyncByStatement(String refId) throws Exception {
		try {
			List<MobileSync> listData = mobileSyncRepository.getMobileSyncByStatement(refId);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Synchronize || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileSyncArchive> getMobileSyncArcCurrentDate(Date date) throws Exception {
		try {
			Date nextDate = getNextDay(date, 1);
			String dateMillis = String.valueOf(date.getTime());
			String nextDateMillis = String.valueOf(nextDate.getTime());
			List<MobileSyncArchive> listData = mobileSyncArchiveRepository.getMobileSyncArcByExecutionDate(dateMillis, nextDateMillis);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Synchronize Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileSyncArchive> getMobileSyncArcByExecutionDate(Date from, Date to) throws Exception {
		try {
			Date nextDate = getNextDay(to, 1);
			String fromMilis = String.valueOf(from.getTime());
			String toMilis = String.valueOf(nextDate.getTime());
			List<MobileSyncArchive> listData = mobileSyncArchiveRepository.getMobileSyncArcByExecutionDate(fromMilis, toMilis);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Synchronize Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileSyncArchive> getMobileSyncArcByStatement(String refId) throws Exception {
		try {
			List<MobileSyncArchive> listData = mobileSyncArchiveRepository.getMobileSyncArcByStatement(refId);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Synchronize Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileNotification> getMobileNotifCurrentDate(Date date) throws Exception {
		try {
			List<MobileNotification> listData = mobileNotificationRepository.getMobileNotificationByDate(date);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Notification || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileNotification> getMobileNotifByParam(String param) throws Exception {
		try {
			List<MobileNotification> listData = mobileNotificationRepository.getMobileNotificationByParam(param);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Notification || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileNotification> getMobileNotifCustomDate(Date dateFrom, Date dateTo) throws Exception {
		try {
			List<MobileNotification> listData = mobileNotificationRepository.getMobileNotificationByDate(dateFrom, dateTo);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Notification || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileNotificationArchive> getMobileNotifArchiveCurrentDate(Date date) throws Exception {
		try {
			List<MobileNotificationArchive> listData = mobileNotificationArchiveRepository.getMobileNotificationArchiveByDate(date);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Notification Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileNotificationArchive> getMobileNotifArchiveCustomDate(Date dateFrom, Date dateTo) throws Exception {
		try {
			List<MobileNotificationArchive> listData = mobileNotificationArchiveRepository.getMobileNotificationArchiveByDate(dateFrom, dateTo);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Notification Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<MobileNotificationArchive> getMobileNotifArchiveByParam(String param) throws Exception {
		try {
			List<MobileNotificationArchive> listData = mobileNotificationArchiveRepository.getMobileNotificationArchiveByParam(param);
			return listData;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Mobile Notification Archive || " + e.getMessage());
			throw e;
		}
	}
	
	public List<SelectItem> getListOfModule() {
		return Module.getListOf();
	}
	
	private enum Module {
		AdvanceFirstInstallment("AD"){
			@Override
			public String toString() {
				return "AD (Advance First Installment)";
			}
		},
		AccrueInsuranceIncome("AE"){
			@Override
			public String toString() {
				return "AE (Accrue Insurance Income)";
			}
		},
		BulkPayment("BP"){
			@Override
			public String toString() {
				return "BP (Bulk Payment)";
			}
		},
		CashTransactionBulk("CB"){
			@Override
			public String toString() {
				return "CB (Cash Transaction Bulk)";
			}
		},
		CashTransferPayment("CP"){
			@Override
			public String toString() {
				return "CP (Cash Tranfer Payment)";
			}
		},
		CashTransaction("CT"){
			@Override
			public String toString() {
				return "CT (Cash Transaction)";
			}
		},
		DisburseCP("DP"){
			@Override
			public String toString() {
				return "DP (Disburse CP)";
			}
		},
		DisbursementTransaction("DT"){
			@Override
			public String toString() {
				return "DT (Disbursement Transaction)";
			}
		},
		ExcessInsurance("EI"){
			@Override
			public String toString() {
				return "EI (Excess Insurance)";
			}
		},
		FAServicePaymentBulkPayment("FB"){
			@Override
			public String toString() {
				return "FB (FA Service Payment Bulk Payment)";
			}
		},
		FAServicePaymentTransaction("FT"){
			@Override
			public String toString() {
				return "FT (FA Service Payment Transaction)";
			}
		},
		InsurancePaymentBulkPayment("IB"){
			@Override
			public String toString() {
				return "IB (Insurance Payment Bulk Payment)";
			}
		},
		Impairment("IM"){
			@Override
			public String toString() {
				return "IM (Impairment)";
			}
		},
		InsurancePaymentTransaction("IT"){
			@Override
			public String toString() {
				return "IT (Insurance Payment Transaction)";
			}
		},
		LifeInsurancePayment("LP"){
			@Override
			public String toString() {
				return "LP (Life Insurance Payment)";
			}
		},
		NewContract("NC"){
			@Override
			public String toString() {
				return "NC (New Contract)";
			}
		},
		CashOverbook("OB"){
			@Override
			public String toString() {
				return "OB (Cash Overbook)";
			}
		},
		OptionFeeDisburse("OF"){
			@Override
			public String toString() {
				return "OF (Option Fee Disburse)";
			}
		},
		PdcPayment("PP"){
			@Override
			public String toString() {
				return "PP (PDC Payment)";
			}
		},
		ProcurementPrepaymentBulkPayment("RB"){
			@Override
			public String toString() {
				return "RB (Procurement Prepayment Bulk Payment)";
			}
		},
		RefundCommission("RC"){
			@Override
			public String toString() {
				return "RC (Refund Commission)";
			}
		},
		RefundPaymentBulk("RF"){
			@Override
			public String toString() {
				return "RF (Refund Payment Bulk)";
			}
		},
		RefundPaymentTransaction("RR"){
			@Override
			public String toString() {
				return "RR (Refund Payment Transaction)";
			}
		},
		ProcurementPrepaymentTransaction("RT"){
			@Override
			public String toString() {
				return "RT (Procurement Prepayment Transaction)";
			}
		},
		FAServicePrepaymentBulk("SB"){
			@Override
			public String toString() {
				return "SB (FA Service Prepayment Bulk)";
			}
		},
		StandingInstruction("SI"){
			@Override
			public String toString() {
				return "SI (Standing Instruction)";
			}
		},
		FAServicePaymentRefund("SR"){
			@Override
			public String toString() {
				return "SR (FA Service Payment Refund)";
			}
		},
		FAServicePrepaymentTransaction("ST"){
			@Override
			public String toString() {
				return "ST (FA Service Prepayment Transaction)";
			}
		},
		ProcurementPaymentBulkPayment("TB"){
			@Override
			public String toString() {
				return "TB (Procurement Payment Bulk Payment)";
			}
		},
		ProcurementPaymentTransaction("TT"){
			@Override
			public String toString() {
				return "TT (Procurement Payment Transaction)";
			}
		},
		VaPayment("VA"){
			@Override
			public String toString() {
				return "VA (VA Payment)";
			}
		},
		WriteOff("WO"){
			@Override
			public String toString() {
				return "WO (Write Off)";
			}
		};
		
		private String val;
		private static final List<SelectItem> listOf = new ArrayList<SelectItem>();
		
		Module(String val){
			this.val = val;
		}
		
		@SuppressWarnings("unused")
		public static Module valOf(String prm) {
	        if (prm.equals(Module.VaPayment.getVal())) {
	            return Module.VaPayment;
	        }else if(prm.equals(Module.BulkPayment.getVal())){
	            return Module.BulkPayment;
	        }else if(prm.equals(Module.CashTransferPayment)){
	            return Module.CashTransferPayment;
	        }else if(prm.equals(Module.PdcPayment)){
	            return Module.PdcPayment;
	        }else if(prm.equals(Module.CashTransaction.getVal())){
	            return Module.CashTransaction;
	        }else if(prm.equals(Module.CashTransactionBulk)){
	            return Module.CashTransactionBulk;
	        }else if(prm.equals(Module.NewContract.getVal())){
	            return Module.NewContract;
	        }else if(prm.equals(Module.OptionFeeDisburse.getVal())){
	            return Module.OptionFeeDisburse;
	        }else if(prm.equals(Module.AccrueInsuranceIncome.getVal())){
	            return Module.AccrueInsuranceIncome;
	        }else if(prm.equals(Module.AdvanceFirstInstallment.getVal())){
	            return Module.AdvanceFirstInstallment;
	        }else if(prm.equals(Module.DisbursementTransaction.getVal())){
	            return Module.DisbursementTransaction;
	        }else if(prm.equals(Module.ProcurementPrepaymentTransaction.getVal())){
	            return Module.ProcurementPrepaymentTransaction;
	        }else if(prm.equals(Module.ProcurementPrepaymentBulkPayment.getVal())){
	            return Module.ProcurementPrepaymentBulkPayment;
	        }else if(prm.equals(Module.ProcurementPaymentBulkPayment.getVal())){
	            return Module.ProcurementPaymentBulkPayment;
	        }else if(prm.equals(Module.ProcurementPaymentTransaction.getVal())){
	            return Module.ProcurementPaymentTransaction;
	        }else if(prm.equals(Module.InsurancePaymentTransaction.getVal())){
	            return Module.InsurancePaymentTransaction;
	        }else if(prm.equals(Module.InsurancePaymentBulkPayment.getVal())){
	            return Module.InsurancePaymentBulkPayment;
	        }else if(prm.equals(Module.FAServicePrepaymentTransaction)){
	            return Module.FAServicePrepaymentTransaction;
	        }else if(prm.equals(Module.FAServicePrepaymentBulk.getVal())){
	            return Module.FAServicePrepaymentBulk;
	        }else if(prm.equals(Module.FAServicePaymentTransaction.getVal())){
	            return Module.FAServicePaymentTransaction;
	        }else if(prm.equals(Module.FAServicePaymentBulkPayment.getVal())){
	            return Module.FAServicePaymentBulkPayment;
	        }else if(prm.equals(Module.FAServicePaymentRefund.getVal())){
	            return Module.FAServicePaymentRefund;
	        }else if(prm.equals(Module.Impairment.getVal())){
	            return Module.Impairment;
	        }else if(prm.equals(Module.CashOverbook.getVal())){
	            return Module.CashOverbook;
	        }else if(prm.equals(Module.LifeInsurancePayment.getVal())){
	            return Module.LifeInsurancePayment;
	        }else if(prm.equals(Module.RefundPaymentBulk.getVal())){
	            return Module.RefundPaymentBulk;
	        }else if(prm.equals(Module.RefundPaymentTransaction.getVal())){
	            return Module.RefundPaymentTransaction;
	        }else if(prm.equals(Module.RefundCommission.getVal())){
	            return Module.RefundCommission;
	        }else if(prm.equals(Module.DisburseCP.getVal())){
	            return Module.DisburseCP;
	        }else if(prm.equals(Module.ExcessInsurance.getVal())){
	            return Module.ExcessInsurance;
	        }else if(prm.equals(Module.StandingInstruction.getVal())){
	            return Module.StandingInstruction;
	        }else if(prm.equals(Module.WriteOff.getVal())){
	            return Module.WriteOff;
	        }
	        return null;
	    }

	    public String getVal() {
	        return val;
	    }

	    public static List<SelectItem> getListOf() {
	        if (CommonUtil.isNullOrEmpty(listOf)) {
	            synchronized (listOf) {
	                if (CommonUtil.isNullOrEmpty(listOf)) {
	                    for (Module val : Module.values()) {
	                        listOf.add(new SelectItem(val.getVal(), val.toString()));
	                    }
	                }
	            }
	        }
	        return listOf;
	    }
	    
	}
	
	public Date getNextDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
}
