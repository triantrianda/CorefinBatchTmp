package fid.corefin.batch.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

import fid.corefin.batch.data.ParameterRepository;
import fid.corefin.batch.model.DMBatch;
import fid.corefin.batch.model.GeneralBatchInfo;
import fid.corefin.batch.model.JournalBatch;
import fid.corefin.batch.model.NotifBatchMColl;
import fid.corefin.batch.model.NotifBatchMPos;
import fid.corefin.batch.model.SynchBatch;
import fid.corefin.batch.model.entity.Parameter;
import fid.corefin.batch.service.BatchMonitoringService;
import fid.corefin.batch.util.Repository;

@ManagedBean
@SessionScoped
public class BatchViewHandler {
	@Inject
	private BatchMonitoringService batchMonitoringService;

	private List<GeneralBatchInfo> generalBatchInfoList = new ArrayList<GeneralBatchInfo>();

	private List<JournalBatch> journalQueueList = new ArrayList<JournalBatch>();

	private List<DMBatch> dmBatchList = new ArrayList<DMBatch>();
	
	private List<SynchBatch> synchBatchList = new ArrayList<SynchBatch>();
	
	private List<NotifBatchMPos> mPosNotifBatchList = new ArrayList<NotifBatchMPos>();
	
	private List<NotifBatchMColl> mCollNotifBatchList = new ArrayList<NotifBatchMColl>();

	private TreeNode selectedNode;

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


	public void onNodeSelect(NodeSelectEvent event) {
		
		String value = batchMonitoringService.getParameterValue(1);

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
}
