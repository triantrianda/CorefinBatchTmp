package fid.corefin.batch.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

import fid.corefin.batch.model.DMBatch;
import fid.corefin.batch.model.GeneralBatchInfo;
import fid.corefin.batch.model.JournalBatch;
import fid.corefin.batch.model.NotifBatchMColl;
import fid.corefin.batch.model.NotifBatchMPos;
import fid.corefin.batch.model.SynchBatch;
import fid.corefin.batch.model.entity.WaOTP;
import fid.corefin.batch.model.entity.WaPooling;

@ManagedBean
@SessionScoped
public class BatchViewHandler {

	private List<GeneralBatchInfo> generalBatchInfoList = new ArrayList<GeneralBatchInfo>();

	private List<JournalBatch> journalQueueList = new ArrayList<JournalBatch>();

	private List<DMBatch> dmBatchList = new ArrayList<DMBatch>();
	
	private List<SynchBatch> synchBatchList = new ArrayList<SynchBatch>();
	
	private List<NotifBatchMPos> mPosNotifBatchList = new ArrayList<NotifBatchMPos>();
	
	private List<NotifBatchMColl> mCollNotifBatchList = new ArrayList<NotifBatchMColl>();
	
	private List<WaPooling> messagePoolBatchList = new ArrayList<WaPooling>();
	
	private List<WaOTP> messageOtpBatchList = new ArrayList<WaOTP>();

	private TreeNode selectedNode;

	private boolean showMessagePooling;
	
	private boolean showMessageSendTemplate;
	
	private boolean showMessageOTP;
	
	private boolean showGeneral;

	private boolean showJournal;

	private boolean showMDBatch;

	private boolean showNotifMPos;
	
	private boolean showNotifMColl;

	private boolean showSynch;

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

	public List<GeneralBatchInfo> getGeneralBatchInfoList() {
		return generalBatchInfoList;
	}

	public void setBatchOption(BatchOption batchOption) {
		this.batchOption = batchOption;
	}

	public BatchOption getBatchOption() {
		return batchOption;
	}


	public void onNodeSelect(NodeSelectEvent event) throws Exception {
		showMessagePooling = false;
		showMessageSendTemplate = false;
		showMessageOTP = false;
		showGeneral = false;
		showJournal = false;
		showMDBatch = false;
		showNotifMColl = false;
		showNotifMPos = false;
		showSynch = false;

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
				break;
			case "WA OTP":
				showMessageOTP = true;
				messageOtpBatchList = batchOption.getMessageOtpBatch();
				break;
			case "Journal Queue":
				showJournal = true;
				journalQueueList = batchOption.getJournalBatchInfoList();
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

	@PostConstruct
	public void init() {
		showGeneral = true;
		generalBatchInfoList = batchOption.getGeneralBatchInfoList();
	}

	public void refreshBatchInfo(String id) {
		System.out.println("REFRESH ID : " + id);
	}

	public List<JournalBatch> getJournalQueueList() {
		return journalQueueList;
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
	
	public List<WaPooling> getMessagePoolBatchList() {
		return messagePoolBatchList;
	}
	
	public List<WaOTP> getMessageOtpBatchList() {
		return messageOtpBatchList;
	}
	
}
