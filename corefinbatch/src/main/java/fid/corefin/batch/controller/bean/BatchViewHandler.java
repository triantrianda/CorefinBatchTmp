package fid.corefin.batch.controller.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

import fid.corefin.batch.model.DMBatch;
import fid.corefin.batch.model.GeneralBatchInfo;
import fid.corefin.batch.model.JournalBatch;
import fid.corefin.batch.model.NotifBatchMColl;
import fid.corefin.batch.model.NotifBatchMPos;
import fid.corefin.batch.model.SynchBatch;

import fid.corefin.batch.model.entity.GlJournalQueue;
import fid.corefin.batch.model.entity.GlJournalQueueArchive;
import fid.corefin.batch.model.entity.MobileNotification;
import fid.corefin.batch.model.entity.MobileNotificationArchive;
import fid.corefin.batch.model.entity.MobileSync;
import fid.corefin.batch.model.entity.MobileSyncArchive;
import fid.corefin.batch.service.BatchMonitoringService;
import fid.corefin.batch.model.entity.WaOTP;
import fid.corefin.batch.model.entity.WaPooling;
import fid.corefin.batch.model.entity.WaSendTemplate;

@ManagedBean
@SessionScoped
public class BatchViewHandler {
	@Inject
	private BatchMonitoringService batchMonitoringService;

	private List<GeneralBatchInfo> generalBatchInfoList = new ArrayList<GeneralBatchInfo>();

	private List<JournalBatch> journalQueueList = new ArrayList<JournalBatch>();
	
	private List<GlJournalQueue> glJournalQueueList = new ArrayList<GlJournalQueue>();
	
	private List<GlJournalQueueArchive> glJournalQueueArchiveList = new ArrayList<GlJournalQueueArchive>();
	
	private GlJournalQueue glJournalQueue = new GlJournalQueue();

	private List<DMBatch> dmBatchList = new ArrayList<DMBatch>();
	
	private List<SynchBatch> synchBatchList = new ArrayList<SynchBatch>();
	
	private List<NotifBatchMPos> mPosNotifBatchList = new ArrayList<NotifBatchMPos>();
	
	private List<NotifBatchMColl> mCollNotifBatchList = new ArrayList<NotifBatchMColl>();
	
	private List<WaPooling> messagePoolBatchList = new ArrayList<WaPooling>();
	
	private List<WaOTP> messageOtpBatchList = new ArrayList<WaOTP>();
	
	private List<WaSendTemplate> messageSendTemplateBatchList = new ArrayList<WaSendTemplate>();
	
	private List<MobileSync> mobileSyncList = new ArrayList<MobileSync>();

	private List<MobileSyncArchive> mobileSyncArchiveList = new ArrayList<MobileSyncArchive>();
	
	private List<MobileNotification> mobileNotificationList = new ArrayList<MobileNotification>();
	
	private List<MobileNotificationArchive> mobileNotificationArchiveList = new ArrayList<MobileNotificationArchive>();

	private TreeNode selectedNode;

	private boolean showMessagePooling;
	
	private boolean showMessageSendTemplate;
	
	private boolean showMessageOTP;
	
	private boolean showGeneral;

	private boolean showJournal;
	
	private boolean showJournalArchive;
	private boolean showMobileSync;
	private boolean showMobileSyncArchive;
	private boolean showMobileNotif;
	private boolean showMobileNotifArchive;

	private boolean showMDBatch;

	private boolean showNotifMPos;
	
	private boolean showNotifMColl;

	private boolean showSynch;
	
	private Date date1;
    private Date date2;
    private Date date1JA;
    private Date date2JA;
    private String refId;
    private String journalId;
	private String moduleJ; 
    private String moduleJA;
    private String selectedSearchType;
    private boolean searchByModule;
    private boolean searchByRefId;
    private boolean searchByJournalId;
    private boolean searchByStatementText;
    private boolean searchByParameter;
    private final String DefaultSearch = "MODULE";
    

	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@ManagedProperty("#{batchOption}")
	private BatchOption batchOption;

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}
	
	public boolean isShowMessagePool() {
		return showMessagePooling;
	}
	
	public boolean isShowMessageSendTemplate() {
		return showMessageSendTemplate;
	}
	
	public boolean isShowMessageOTP() {
		return showMessageOTP;
	}

	public boolean isShowJournal() {
		return showJournal;
	}

	public boolean isShowJournalArchive() {
		return showJournalArchive;
	}

	public boolean isShowMDBatch() {
		return showMDBatch;
	}

	public boolean isShowGeneral() {
		return showGeneral;
	}

	public boolean isShowNotifMColl() {
		return showNotifMColl;
	}

	public boolean isShowSynch() {
		return showSynch;
	}
	
	public boolean isShowNotifMPos() {
		return showNotifMPos;
	}
	
	public boolean isShowMobileSync() {
		return showMobileSync;
	}
	
	public boolean isShowMobileSyncArchive() {
		return showMobileSyncArchive;
	}
	
	public boolean isShowMobileNotif() {
		return showMobileNotif;
	}
	
	public boolean isShowMobileNotifArchive() {
		return showMobileNotifArchive;
	}

	public List<GeneralBatchInfo> getGeneralBatchInfoList() {
		return generalBatchInfoList;
	}

	public void setBatchOption(BatchOption batchOption) {
		this.batchOption = batchOption;
	}

	public BatchOption getBatchOption() {
		return batchOption;
	}

	public boolean isSearchByModule() {
		return searchByModule;
	}
	
	public boolean isSearchByRefId() {
		return searchByRefId;
	}
	
	public boolean isSearchByJournalId() {
		return searchByJournalId;
	}
	
	public boolean isSearchByStatementText() {
		return searchByStatementText;
	}
	
	public boolean isSearchByParameter() {
		return searchByParameter;
	}
	
	public void onNodeSelect(NodeSelectEvent event) throws Exception {
		showMessagePooling = false;
		showMessageSendTemplate = false;
		showMessageOTP = false;
		showGeneral = false;
		showJournal = false;
		showJournalArchive = false;
		showMobileSync = false;
		showMobileSyncArchive = false;
		showMobileNotif = false;
		showMobileNotifArchive = false;
		showMDBatch = false;
		showNotifMColl = false;
		showNotifMPos = false;
		showSynch = false;
		date1 = null;
		date2 = null;
		date1JA = null;
		date2JA = null;
		moduleJ = null;
		moduleJA = null;
		searchByModule = true;
		searchByRefId = false;
		searchByJournalId = false;
		searchByStatementText = false;
		searchByParameter = false;
		selectedSearchType = DefaultSearch;
		
		/*
		 * try { closeAfter = HibernateHelper.beginTx(); Session session =
		 * HibernateHelper.getSession();
		 * 
		 * List<GlJournalQueue> listOfUserAppr =
		 * session.createCriteria(GlJournalQueue.class).list();
		 * 
		 * } catch (Exception e) { HibernateHelper.rollbackTx(closeAfter); }
		 */
		
		Date date = new Date();

		TreeNode treeNode = event.getTreeNode();
		TreeNode parent = treeNode.getParent();
		if (parent.getParent() == null) {
			init();
		} else {
			String node = treeNode.getData().toString();
			System.out.println(node);

			switch (node) {
			case "WA Pooling":
				showMessagePooling = true;
				messagePoolBatchList = batchOption.getMessagePoolBatch();
				break;
			case "WA Send Template":
				showMessageSendTemplate = true;
				messageSendTemplateBatchList = batchOption.getMessageWaSendTemplate();
				break;
			case "WA OTP":
				showMessageOTP = true;
				messageOtpBatchList = batchOption.getMessageOtpBatch();
				break;
			case "Journal Queue":
				showJournal = true;
				//journalQueueList = batchOption.getJournalBatchInfoList();
				glJournalQueueList = batchMonitoringService.getGlJournalQueue(dateFormat.format(date));
				break;
			case "Journal Queue Archive":
				showJournalArchive = true;
				glJournalQueueArchiveList = batchMonitoringService.getGlJournalQueueArchive(dateFormat.format(date));
				break;
			case "Mobile Synchronize":
				showMobileSync = true;
				mobileSyncList = batchMonitoringService.getMobileSyncCurrentDate(sdf.parse(sdf.format(date)));
				break;	
			case "Mobile Synchronize Archive":
				showMobileSyncArchive = true;
				mobileSyncArchiveList = batchMonitoringService.getMobileSyncArcCurrentDate(sdf.parse(sdf.format(date)));
				break;
			case "Mobile Notification":
				showMobileNotif = true;
				mobileNotificationList = batchMonitoringService.getMobileNotifCurrentDate(sdf.parse(sdf.format(date)));
				break;
			case "Mobile Notification Archive":
				showMobileNotifArchive = true;
				mobileNotificationArchiveList = batchMonitoringService.getMobileNotifArchiveCurrentDate(sdf.parse(sdf.format(date)));
				break;
			case "Daily":
				showMDBatch = true;
				dmBatchList = batchOption.getDailyBatchInfoList();
				break;
			case "Monthly":
				showMDBatch = true;
				dmBatchList = batchOption.getMonthlyBatchInfoList();
				break;
			case "Data Syncronization":
				showSynch = true;
				synchBatchList = batchOption.getSynchBatchInfoList();
				break;
			case "mPos - Notification":
				showNotifMPos = true;
				mPosNotifBatchList = batchOption.getNotifBatchMPosInfoList();
				break;
			case "mColl - Notification":
				showNotifMColl = true;
				mCollNotifBatchList = batchOption.getNotifBatchMCollInfoList();
				break;
			default:
				break;
			}
		}
	}
	
	public void buttonAction(ActionEvent ae) {
		try {
			if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
				if (date1.compareTo(date2) > 0) {
					FacesContext.getCurrentInstance().addMessage("formID:dateFrom", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Date From cannot greater then Date To."));
				}
				
				if (moduleJ == null) {
					glJournalQueueList = batchMonitoringService.getGlJournalQueueFromTo(dateFormat.format(date1), dateFormat.format(date2));
				}
				else {
					glJournalQueueList = batchMonitoringService.getGlJournalQueueFromToWithModule(dateFormat.format(date1), dateFormat.format(date2), moduleJ);
				}	
			} else {
				glJournalQueueList = batchMonitoringService.getGlJournalQueueByRefId(refId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buttonActionJA(ActionEvent ae) {
		try {
			if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
				if (date1JA.compareTo(date2JA) > 0) {
					FacesContext.getCurrentInstance().addMessage("formID:dateFromJA", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Date From cannot greater then Date To."));
				}
				
				if (moduleJA == null) {
					glJournalQueueArchiveList = batchMonitoringService.getGlJournalQueueArchiveFromTo(dateFormat.format(date1JA), dateFormat.format(date2JA));
				} else {
					glJournalQueueArchiveList = batchMonitoringService.getGlJournalQueueArchiveFromToWithModule(dateFormat.format(date1JA), dateFormat.format(date2JA), moduleJA);
				}
			} else if(selectedSearchType.equalsIgnoreCase("RefId")) {
				glJournalQueueArchiveList = batchMonitoringService.getGlJournalQueueArchiveByRefId(refId);
			} else if(selectedSearchType.equalsIgnoreCase("JournalId")) {
				glJournalQueueArchiveList = batchMonitoringService.getGlJournalQueueArchiveByJournalId(journalId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search(ActionEvent ae) {
		try {
			String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("searchParam");
			switch (param) {
			case "MobileSync":
				if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
					if(!validate()) {
						mobileSyncList = batchMonitoringService.getMobileSyncByExecutionDate(date1, date2);
					}
				} else {
					mobileSyncList = batchMonitoringService.getMobileSyncByStatement(refId);
				}
				break;
			case "MobileSyncArchive":
				if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
					if(!validate()) {
						mobileSyncArchiveList = batchMonitoringService.getMobileSyncArcByExecutionDate(date1, date2);
					} 
				} else {
					mobileSyncArchiveList = batchMonitoringService.getMobileSyncArcByStatement(refId);
					}
				break;
			case "MobileNotification":
				if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
					if(!validate()) {
						mobileNotificationList = batchMonitoringService.getMobileNotifCustomDate(date1, date2);
					}
				} else {
					mobileNotificationList = batchMonitoringService.getMobileNotifByParam(refId);
				}
				break;
			case "MobileNotificationArchive":
				if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
					if(!validate()) {
						mobileNotificationArchiveList = batchMonitoringService.getMobileNotifArchiveCustomDate(date1, date2);
					}
				} else {
					mobileNotificationArchiveList = batchMonitoringService.getMobileNotifArchiveByParam(param);
				}
				break;
			default:
				break;
			}
			
//			if(param.equalsIgnoreCase("MobileSync")) {
//				if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
//					if(date1.compareTo(date2) > 0) {
//						FacesContext.getCurrentInstance().addMessage("formID:dateFromMSync", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Date From cannot greater then Date To."));
//					} else {
//						mobileSyncList = batchMonitoringService.getMobileSyncByExecutionDate(date1, date2);
//					}
//				} else {
//					mobileSyncList = batchMonitoringService.getMobileSyncByStatement(refId);
//				}
//			} else {
//				if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
//					if(date1.compareTo(date2) > 0) {
//						FacesContext.getCurrentInstance().addMessage("formID:dateFromMSync", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Date From cannot greater then Date To."));
//					} else {
//						mobileSyncArchiveList = batchMonitoringService.getMobileSyncArcByExecutionDate(date1, date2);
//					}
//				} else {
//					mobileSyncArchiveList = batchMonitoringService.getMobileSyncArcByStatement(refId);
//				}
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		showGeneral = true;
		generalBatchInfoList = batchOption.getGeneralBatchInfoList();
	}

	public void refreshBatchInfo(String id) throws Exception {
		switch(id) {
		case "refWaPool":
			messagePoolBatchList = batchOption.getMessagePoolBatch();
			break;
		case "refWaSendTemplate":
			messageSendTemplateBatchList = batchOption.getMessageWaSendTemplate();
			break;
		case "refWaOtp":
			messageOtpBatchList = batchOption.getMessageOtpBatch();
			break;
		default:
			break;
		}
		//System.out.println("REFRESH ID : " + id);
	}
	
	public void changeParamSearch(final AjaxBehaviorEvent event) {
		if(selectedSearchType.equalsIgnoreCase(DefaultSearch)) {
			searchByModule = true;
			searchByRefId = false;
			searchByJournalId = false;
			searchByStatementText = false;
			searchByParameter = false;
		} else if (selectedSearchType.equalsIgnoreCase("RefId")){
			searchByModule = false;
			searchByRefId = true;
			searchByJournalId = false;
			searchByStatementText = false;
			searchByParameter = false;
		} else if (selectedSearchType.equalsIgnoreCase("JournalId")){
			searchByModule = false;
			searchByRefId = false;
			searchByJournalId = true;
			searchByStatementText = false;
			searchByParameter = false;
		} else if(selectedSearchType.equalsIgnoreCase("StatementText")){
			searchByModule = false;
			searchByRefId = false;
			searchByJournalId = false;
			searchByStatementText = true;
			searchByParameter = false;
		} else if(selectedSearchType.equalsIgnoreCase("Parameter")) {
			searchByModule = false;
			searchByRefId = false;
			searchByJournalId = false;
			searchByStatementText = false;
			searchByParameter = true;
		}
	}
	
	public boolean validate() {
		boolean result = false;
		if(date1.compareTo(date2) > 0) {
			FacesContext.getCurrentInstance()
			.addMessage("formID:dateFromMSync", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Date From cannot greater then Date To."));
			result = true;
		}
		return result;
	}

	public List<JournalBatch> getJournalQueueList() {
		return journalQueueList;
	}
	
	public List<GlJournalQueue> getGlJournalQueueList() {
		return glJournalQueueList;
	}

	public List<GlJournalQueueArchive> getGlJournalQueueArchiveList() {
		return glJournalQueueArchiveList;
	}

	public GlJournalQueue getGlJournalQueue() {
		return glJournalQueue;
	}

	public void setGlJournalQueue(GlJournalQueue glJournalQueue) {
		this.glJournalQueue = glJournalQueue;
	}

	public List<DMBatch> getDmBatchList() {
		return dmBatchList;
	}
	
	public List<NotifBatchMColl> getmCollNotifBatchList() {
		return mCollNotifBatchList;
	}
	
	public List<NotifBatchMPos> getmPosNotifBatchList() {
		return mPosNotifBatchList;
	}
	
	public List<SynchBatch> getSynchBatchList() {
		return synchBatchList;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getDate1JA() {
		return date1JA;
	}

	public void setDate1JA(Date date1ja) {
		date1JA = date1ja;
	}

	public Date getDate2JA() {
		return date2JA;
	}

	public void setDate2JA(Date date2ja) {
		date2JA = date2ja;
	}
	
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getModuleJ() {
		return moduleJ;
	}

	public void setModuleJ(String moduleJ) {
		this.moduleJ = moduleJ;
	}

	public String getModuleJA() {
		return moduleJA;
	}

	public void setModuleJA(String moduleJA) {
		this.moduleJA = moduleJA;
	}
	
	public List<WaPooling> getMessagePoolBatchList() {
		return messagePoolBatchList;
	}
	
	public List<WaOTP> getMessageOtpBatchList() {
		return messageOtpBatchList;
	}
	
	public List<WaSendTemplate> getMessageSendTemplateBatchList() {
		return messageSendTemplateBatchList;
	}
	
	public List<MobileSync> getMobileSyncList() {
		return mobileSyncList;
	}

	public void setMobileSyncList(List<MobileSync> mobileSyncList) {
		this.mobileSyncList = mobileSyncList;
	}

	public List<MobileSyncArchive> getMobileSyncArchiveList() {
		return mobileSyncArchiveList;
	}

	public void setMobileSyncArchiveList(List<MobileSyncArchive> mobileSyncArchiveList) {
		this.mobileSyncArchiveList = mobileSyncArchiveList;
	}
	
	public List<MobileNotification> getMobileNotificationList() {
		return mobileNotificationList;
	}

	public void setMobileNotificationList(List<MobileNotification> mobileNotificationList) {
		this.mobileNotificationList = mobileNotificationList;
	}

	public List<MobileNotificationArchive> getMobileNotificationArchiveList() {
		return mobileNotificationArchiveList;
	}

	public void setMobileNotificationArchiveList(List<MobileNotificationArchive> mobileNotificationArchiveList) {
		this.mobileNotificationArchiveList = mobileNotificationArchiveList;
	}
	
	public BatchMonitoringService getBatchMonitoringService() {
		return batchMonitoringService;
	}
	
	public String getSelectedSearchType() {
		return selectedSearchType;
	}

	public void setSelectedSearchType(String selectedSearchType) {
		this.selectedSearchType = selectedSearchType;
	}
	
	public String getJournalId() {
		return journalId;
	}

	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}


}
