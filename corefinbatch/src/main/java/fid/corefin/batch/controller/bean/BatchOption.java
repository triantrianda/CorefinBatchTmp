package fid.corefin.batch.controller.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fid.corefin.batch.model.DMBatch;
import fid.corefin.batch.model.GeneralBatchInfo;
import fid.corefin.batch.model.JournalBatch;
import fid.corefin.batch.model.NotifBatchMColl;
import fid.corefin.batch.model.NotifBatchMPos;
import fid.corefin.batch.model.SynchBatch;
import fid.corefin.batch.model.entity.WaOTP;
import fid.corefin.batch.model.entity.WaPooling;
import fid.corefin.batch.model.entity.WaSendTemplate;
import fid.corefin.batch.service.MessagePoolingMonitoringService;

@ManagedBean
@SessionScoped
public class BatchOption implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -120578915494264956L;

	private List<GeneralBatchInfo> generalBatchInfoList = new ArrayList<GeneralBatchInfo>();

	private List<String> batchNames = new ArrayList<String>();
	
	@Inject
	MessagePoolingMonitoringService messagePoolService;

	public BatchOption() {

		generalBatchInfoList.add(new GeneralBatchInfo("WA Message Pooling", "Daily", "WAPOOL"));
		batchNames.add("WA Pooling");
		
		generalBatchInfoList.add(new GeneralBatchInfo("WA Send Template", "Daily", "WASEND"));
		batchNames.add("WA Send Template");
		
		generalBatchInfoList.add(new GeneralBatchInfo("WA OTP", "Daily", "WAOTP"));
		batchNames.add("WA OTP");

		generalBatchInfoList.add(new GeneralBatchInfo("Journal Queue", "Daily", "J"));
		batchNames.add("Journal Queue");
		
		generalBatchInfoList.add(new GeneralBatchInfo("Journal Queue Archive", "Daily", "Ja"));
		batchNames.add("Journal Queue Archive");
		
		generalBatchInfoList.add(new GeneralBatchInfo("Mobile Synchronize", "Daily", "MSYNC"));
		batchNames.add("Mobile Synchronize");
		
		generalBatchInfoList.add(new GeneralBatchInfo("Mobile Synchronize Archive", "Daily", "MSYNCARC"));
		batchNames.add("Mobile Synchronize Archive");
		
		generalBatchInfoList.add(new GeneralBatchInfo("Mobile Notification", "Daily", "MNOTIF"));
		batchNames.add("Mobile Notification");
		
		generalBatchInfoList.add(new GeneralBatchInfo("Mobile Notification Archive", "Daily", "MNOTIFARC"));
		batchNames.add("Mobile Notification Archive");
		
//		generalBatchInfoList.add(new GeneralBatchInfo("Monthly", "Monthly", "M"));
//		batchNames.add("Monthly");
//
//		generalBatchInfoList.add(new GeneralBatchInfo("Daily", "Daily", "D"));
//		batchNames.add("Daily");

//		generalBatchInfoList.add(new GeneralBatchInfo("Data Syncronization", "Daily", "S"));
//		batchNames.add("Data Syncronization");
//
//		generalBatchInfoList.add(new GeneralBatchInfo("mPos - Notification", "Daily", "P"));
//		batchNames.add("mPos - Notification");
//
//		generalBatchInfoList.add(new GeneralBatchInfo("mColl - Notification", "Daily", "C"));
//		batchNames.add("mColl - Notification");

	}

	public List<GeneralBatchInfo> getGeneralBatchInfoList() {
		return generalBatchInfoList;
	}

	public void setGeneralBatchInfoList(List<GeneralBatchInfo> generalBatchInfoList) {
		this.generalBatchInfoList = generalBatchInfoList;
	}

	public List<String> getBatchNames() {
		return batchNames;
	}

	public void setBatchNames(List<String> batchNames) {
		this.batchNames = batchNames;
	}

	public List<JournalBatch> getJournalBatchInfoList() {

		List<JournalBatch> journalBatchInfoList = new ArrayList<JournalBatch>();

		journalBatchInfoList
				.add(new JournalBatch(1256835L, 0L, "151722/CV20/001014", "AD", "KAMEI", new Date(1581431486000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256834L, 0L, "151722/CV20/001014", "AE", "KAMEI", new Date(1581431434000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256833L, 0L, "151722/CV20/001014", "NC", "KAMEI", new Date(1581431434000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256832L, 0L, "151186/CV20/000832", "AE", "KAMEI", new Date(1581431399000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256831L, 0L, "151186/CV20/000832", "NC", "KAMEI", new Date(1581431399000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256830L, 0L, "151480/CV20/000927", "AD", "KAMEI", new Date(1581431399000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256829L, 0L, "151480/CV20/000927", "AE", "KAMEI", new Date(1581431386000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256828L, 0L, "151480/CV20/000927", "NC", "KAMEI", new Date(1581430871000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256827L, 0L, "104823/CV20/000885", "AD", "KAMEI", new Date(1581430871000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256826L, 0L, "104823/CV20/000885", "AE", "KAMEI", new Date(1581430842000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256825L, 0L, "104823/CV20/000885", "NC", "KAMEI", new Date(1581430842000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256824L, 0L, "150017/CV20/000410", "AE", "KAMEI", new Date(1581430842000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256823L, 0L, "150017/CV20/000410", "NC", "KAMEI", new Date(1581430783000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256822L, 0L, "144984/CV19/010639", "AD", "KAMEI", new Date(1581430783000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256821L, 0L, "144984/CV19/010639", "AE", "KAMEI", new Date(1581430770000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256820L, 0L, "144984/CV19/010639", "NC", "KAMEI", new Date(1581430742000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256819L, 0L, "151194/CV20/000897", "AD", "KAMEI", new Date(1581430742000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256818L, 0L, "151194/CV20/000897", "AE", "KAMEI", new Date(1581430742000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256817L, 0L, "151194/CV20/000897", "NC", "KAMEI", new Date(1581430718000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256816L, 0L, "20200211-015", "CP", "DWI", new Date(1581430650000L), 3));
		journalBatchInfoList
				.add(new JournalBatch(1256815L, 0L, "20200211-014", "CP", "DWI", new Date(1581430650000L), 3));
		journalBatchInfoList.add(new JournalBatch(1256814L, 0L, "1230491", "VA", "ARDY", new Date(1581430250000L), 3));
		journalBatchInfoList.add(new JournalBatch(1256813L, 0L, "1230492", "VA", "ARDY", new Date(1581430250000L), 3));
		journalBatchInfoList.add(new JournalBatch(1256812L, 0L, "1230490", "VA", "ARDY", new Date(1581430249000L), 3));
		journalBatchInfoList.add(new JournalBatch(1256811L, 0L, "1230489", "VA", "ARDY", new Date(1581430218000L), 3));

		return journalBatchInfoList;
	}

	public List<DMBatch> getMonthlyBatchInfoList() {

		List<DMBatch> monthlyBatchInfoList = new ArrayList<DMBatch>();

		monthlyBatchInfoList.add(new DMBatch("10","0","7","1-1|2-1|3-1|4-1", new Date(1580786931000L), new Date(1580786931000L),"FA Depreciation","Executed 0 of 445 items",12));
		monthlyBatchInfoList.add(new DMBatch("13","0","7","26-0|27-0|28-0|29-0|30-0|31-0|1-1|2-1|3-1|4-1", new Date(1580786930000L), new Date(1580786931000L),"Interest Income","Executed 10031 of 23100 items",10));
		monthlyBatchInfoList.add(new DMBatch("14","0","7","1-1|2-1|3-1|4-1", new Date(1580786929000L), new Date(1580786930000L),"Facility Billing","Executed 0 of 26030 items",9));
		monthlyBatchInfoList.add(new DMBatch("15","0","7","26-0|27-0|28-0|29-0|30-0|31-0|1-1|2-1|3-1|4-1", new Date(1580786931000L), new Date(1580786931000L),"Facility Deffered Income","Executed 5932 of 23214 items",11));
		monthlyBatchInfoList.add(new DMBatch("16","0","7","3-0", new Date(1580700867000L), new Date(1580700868000L),"Collection Monthly","N/A",13));
		monthlyBatchInfoList.add(new DMBatch("17","0","7","3-0", new Date(1580700868000L), new Date(1580700870000L),"Distribute Monthly","N/A",14));
		monthlyBatchInfoList.add(new DMBatch("21","21","23","1-1|2-1|3-1|4-1", new Date(1580850429000L), new Date(1580857200000L),"FA Depreciation","Executed 0 of 445 items",19));
		monthlyBatchInfoList.add(new DMBatch("22","21","23","26-0|27-0|28-0|29-0|30-0|31-0|1-1|2-1|3-1|4-1", new Date(1580850429000L), new Date(1580850429000L),"Interest Income","Executed 10031 of 23100 items",17));
		monthlyBatchInfoList.add(new DMBatch("23","19","23","1-1|2-1|3-1|4-1", new Date(1580843230000L), new Date(1580843231000L),"Facility Billing","Executed 0 of 26030 items",16));
		monthlyBatchInfoList.add(new DMBatch("24","21","23","26-0|27-0|28-0|29-0|30-0|31-0|1-1|2-1|3-1|4-1", new Date(1580850429000L), new Date(1580850429000L),"Facility Deffered Income","Executed 5932 of 23214 items",18));

		return monthlyBatchInfoList;
	}
	
	public List<DMBatch> getDailyBatchInfoList() {

		List<DMBatch> dailyBatchInfoList = new ArrayList<DMBatch>();

		dailyBatchInfoList.add(new DMBatch("6","0","7","Every Day", new Date(1581293229000L), new Date(1581304018000L),"Late Charge Daily","Executed",1));
		dailyBatchInfoList.add(new DMBatch("9","0","7","Every Day", new Date(1581304018000L), new Date(1581304021000L),"Prepaid Allocation","Executed",2));
		dailyBatchInfoList.add(new DMBatch("11","0","7","Every Day", new Date(1581304021000L), new Date(1581304024000L),"Collection Daily","Executed",3));
		dailyBatchInfoList.add(new DMBatch("12","0","7","Every Day", new Date(1581304024000L), new Date(1581304026000L),"Distribution Daily","Executed",4));
		dailyBatchInfoList.add(new DMBatch("18","0","7","Every Day", new Date(1581304026000L), new Date(1581304027000L),"Facility Expire","Executed",5));
		dailyBatchInfoList.add(new DMBatch("19","0","7","Every Day", new Date(1581304027000L), new Date(1581304034000L),"Warning Letter","Executed",6));
		dailyBatchInfoList.add(new DMBatch("20","0","7","Every Day", new Date(1581304036000L), new Date(1581304517000L),"Collection Overdue Batch","Executed",8));
		dailyBatchInfoList.add(new DMBatch("25","0","7","Every Day", new Date(1581304034000L), new Date(1581304036000L),"BlackList Overdue Batch","Executed",7));

		return dailyBatchInfoList;
	}
	
	public List<NotifBatchMPos> getNotifBatchMPosInfoList() {

		List<NotifBatchMPos> notifBatchMPosInfoList = new ArrayList<NotifBatchMPos>();

		notifBatchMPosInfoList.add(new NotifBatchMPos(133417L,"RICHI","EB-P20200211030","SUNAR NENG","A","Approved",3,1L,"IRMA", new Date(1581509102000L)));
		notifBatchMPosInfoList.add(new NotifBatchMPos(133416L,"RIKI","EB-P20200210029","BAMBANG PRASETYO","A","Approved",3,1L,"ADITYA PRADANA", new Date(1581508807000L)));
		notifBatchMPosInfoList.add(new NotifBatchMPos(133415L,"SILVIA2","EB-P20200211030","SUNAR NENG","BM","DecisionPending",3,1L,"IRMA", new Date(1581508796000L)));
		notifBatchMPosInfoList.add(new NotifBatchMPos(133414L,"IMAMUDDIN2","EB-P20200211030","SUNAR NENG","BM","DecisionPending",3,1L,"IRMA", new Date(1581508796000L)));
		notifBatchMPosInfoList.add(new NotifBatchMPos(133413L,"HENDRY2","EB-P20200211030","SUNAR NENG","BM","DecisionPending",3,1L,"IRMA", new Date(1581508796000L)));
		notifBatchMPosInfoList.add(new NotifBatchMPos(133412L,"HANNES","EB-P20200211030","SUNAR NENG","BM","DecisionPending",3,1L,"IRMA", new Date(1581508796000L)));
		notifBatchMPosInfoList.add(new NotifBatchMPos(133411L,"DICKY2","EB-P20200211030","SUNAR NENG","BM","DecisionPending",3,1L,"IRMA", new Date(1581508796000L)));

		return notifBatchMPosInfoList;
	}

	public List<NotifBatchMColl> getNotifBatchMCollInfoList() {

		List<NotifBatchMColl> notifBatchMCollInfoList = new ArrayList<NotifBatchMColl>();
		
		notifBatchMCollInfoList.add(new NotifBatchMColl(232177L,"126253/CV19/004131","AWANAH","FP",new Date(1581427770000L),"Payment for overdue installment from period 11 with amount Rp. 0 via Payment Point",3,1L,"MERYANTO",new Date(1581503825000L)));
		notifBatchMCollInfoList.add(new NotifBatchMColl(232176L,"107530/CV18/007384","SYARIEF HIDAYATULLAH","FP",new Date(1581432147000L),"Payment for overdue installment from period 13 with amount Rp. 6,150,000.00 via Payment Point",3,1L,"MERYANTO",new Date(1581503801000L)));
		notifBatchMCollInfoList.add(new NotifBatchMColl(232175L,"142397/CV19/009690","BURHAN","FP",new Date(1581412881000L),"Payment for overdue installment from period 2 with amount Rp. 3,774,000.00 via Payment Point",3,1L,"MERYANTO",new Date(1581503756000L)));

		return notifBatchMCollInfoList;
	}
	
	public List<SynchBatch> getSynchBatchInfoList() {

		List<SynchBatch> synchBatchInfoList = new ArrayList<SynchBatch>();
		
		synchBatchInfoList.add(new SynchBatch("U/USR_USER/1581492416849", new Date(1581492416849L),"FIN.USR_USER","UPDATE","update user_definition set user_password = 'eca4c90adbd175a6e87c34425e3f9293786f620ca3685af6431967af53c00ec4c530747006a2b70b7dd2a8a74eb47c6690fe826192cd7fc5a42f904d2b31c089', password_expiry_days = ROUND(UNIX_TIMESTAMP('2020-04-12 14:26:56')*1000) , updated_by = 'null', updation_date = ROUND(UNIX_TIMESTAMP('2020-02-12 14:26:56')*1000) where user_id = 'SONY WIJAYA' ",3,1L,"NULL", new Date(1581517616000L)));
		synchBatchInfoList.add(new SynchBatch("I/PRM_BRANCH/1581491737736", new Date(1581491737736L),"FIN.FCLT_INTRODUCER","INSERT"," INSERT INTO fclt_introducer ( id, name, status, fid_supplier, created_by, creation_date, updated_by, updation_date, company_id, fidg_incentive_receiver ) VALUES ( '30259','KEMAL WIJAYA','A','875','TRIANA',ROUND(UNIX_TIMESTAMP(NOW(4))*1000),'TRIANA',ROUND(UNIX_TIMESTAMP(NOW(4))*1000),1,'SALES' ); ",3,1L,"TRIANA", new Date(1581516937000L)));
		synchBatchInfoList.add(new SynchBatch("I/FA_SUPPLIER_ASSET/1581490910990", new Date(1581490910990L),"FIN.FA_SUPPLIER_ASSET","INSERT","insert into dealer (   dealer_id_pk, fid_city, fid_branch,    fidg_supplier_group, address, bank_account,    bl_document_no, make_id_fk, dealer_name,    contact_name2, contact_name3, contact_phone,    contact_phone2, contact_phone3, contact_phone_area,    contact_phone_area2, contact_phone_area3, contact_title,    contact_title2, contact_title3, cr_document_no,    fax, fax_area, is_facility, is_fixed_asset,    main_product, name, legal_name,    npwp_no, phone, phone_area,    phone_other, remark,  active_ind,status,    created_by, creation_date, updated_by,    updation_date, laa_document_no, personal_id,    sign_speciment, company_id, contact_id_fk,    dealer_code, latitude, longitude) values (    '1131', '3573000000',    '6', 'EQUIP',    'Jalan Letjen S.Parman No. 96',  '',    '',  '55',    '', '',    '', '',    '', '',    '', '',    '', 'MR.',    'MR.', 'MR.',    '',  '',    '', '0',    '1', 'Electronic',    'HARTONO', 'HARTONO',    '',  '0817321212',    '',  '',    'Email: info@myhartono.com', 1, 'A',    'LINA', ROUND(UNIX_TIMESTAMP('2020-02-12 14:01:50')*1000),    'LINA', ROUND(UNIX_TIMESTAMP(NOW(4))*1000),    '',  '',    '0', '1',    null, '1131', '', '')",3,1L,"LINA", new Date(1581516110000L)));
		synchBatchInfoList.add(new SynchBatch("I/FA_SUPPLIER_ASSET/1581490762950", new Date(1581490762950L),"FIN.FA_SUPPLIER_ASSET","INSERT","insert into dealer (   dealer_id_pk, fid_city, fid_branch,    fidg_supplier_group, address, bank_account,    bl_document_no, make_id_fk, dealer_name,    contact_name2, contact_name3, contact_phone,    contact_phone2, contact_phone3, contact_phone_area,    contact_phone_area2, contact_phone_area3, contact_title,    contact_title2, contact_title3, cr_document_no,    fax, fax_area, is_facility, is_fixed_asset,    main_product, name, legal_name,    npwp_no, phone, phone_area,    phone_other, remark,  active_ind,status,    created_by, creation_date, updated_by,    updation_date, laa_document_no, personal_id,    sign_speciment, company_id, contact_id_fk,    dealer_code, latitude, longitude) values (    '1130', '3573000000',    '6', 'EQUIP',    'Jalan Sunadar Priyo Sudarmo 31 Kav 2 Kompleks Ruko Laguna ',  '',    '',  '55',    'Bapak Suharman', '',    '', '',    '', '',    '', '',    '', 'MR.',    'MR.', 'MR.',    '',  '478747',    '0341', '0',    '1', 'FIRE EXTINGUISHER',    'SURYA MITRA KENCANA', 'SURYA MITRA KENCANA',    '',  '478457',    '0341',  '',    '', 1, 'A',    'LINA', ROUND(UNIX_TIMESTAMP('2020-02-12 13:59:22')*1000),    'LINA', ROUND(UNIX_TIMESTAMP(NOW(4))*1000),    '',  '',    '0', '1',    null, '1130', '', '')",3,1L,"LINA", new Date(1581515962000L)));
		synchBatchInfoList.add(new SynchBatch("U/USR_USER/1581489909678", new Date(1581489909678L),"FIN.USR_USER","UPDATE","update user_definition set user_password = '1880bc0c07d8ac00d64d210948ba9b55292d0d5ff872948161ad9f1563e8404e62b4fd9fe4c19052d83ee6ab857a9e114d4fde45bc67b41078115226a1754255', password_expiry_days = ROUND(UNIX_TIMESTAMP('2020-04-12 13:45:09')*1000) , updated_by = 'null', updation_date = ROUND(UNIX_TIMESTAMP('2020-02-12 13:45:09')*1000) where user_id = 'ADITHYO PRADITHA' ",3,1L,"NULL", new Date(1581515109000L)));

		return synchBatchInfoList;
	}
	
	public List<WaPooling> getMessagePoolBatch() throws Exception {
		List<WaPooling> messagePoolBatchList = new ArrayList<WaPooling>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//for testing
			//String tgl = "2020-08-06";
			//for live
			String tgl = sdf.format(new Date());
			Date date = sdf.parse(tgl);
			messagePoolBatchList = messagePoolService.getMessagePoolBatchList(date);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messagePoolBatchList;
	}
	
	public List<WaSendTemplate> getMessageWaSendTemplate() throws Exception {
		List<WaSendTemplate> messageWaSendTemplate = new ArrayList<WaSendTemplate>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//for testing
			//String tgl = "2020-04-30";
			//for live
			String tgl = sdf.format(new Date());
			Date date = sdf.parse(tgl);
			messageWaSendTemplate = messagePoolService.getMessageSendTemplateBatchList(date);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return messageWaSendTemplate;
	}
	
	public List<WaOTP> getMessageOtpBatch(){
		List<WaOTP> waOtpList = new ArrayList<WaOTP>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//for testing
			//String tgl = "2020-07-24";
			//for live
			String tgl = sdf.format(new Date());
			Date date = sdf.parse(tgl);
			waOtpList = messagePoolService.getMessageOtpBatchList(date);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return waOtpList;
	}
	
}
