package fid.corefin.batch.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "GL_JOURNAL_QUEUE_ARCHIVE")
public class GlJournalQueueArchive {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;
	
	@Column(name = "RETRY", nullable = true)
    private Long retry;
	
	@Column(name = "REF_ID", nullable = true)
    private String refId;
	
	@Column(name = "MODULE", nullable = true)
    private String module;
	
	@Column(name = "MAKER", nullable = true)
    private String maker;
	
	@Column(name = "CHECKER", nullable = true)
    private String checker;

	@Column(name = "CREATE_BY", nullable = true)
    private String createBy;

	@Column(name = "CREATE_DATE", nullable = true)
    private Date createDate;
	
	@Column(name = "LAST_UPDATE_BY", nullable = true)
    private String lastUpdateBy;
	
	@Column(name = "LAST_UPDATE_DATE", nullable = true)
    private Date lastUpdateDate;
	
	@Column(name = "PROCESS_DATE", nullable = true)
    private Date processDate;
	
	@Column(name = "FID_JOURNAL", nullable = true)
    private String fIdJournal;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRetry() {
		return retry;
	}

	public void setRetry(Long retry) {
		this.retry = retry;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public String getfIdJournal() {
		return fIdJournal;
	}

	public void setfIdJournal(String fIdJournal) {
		this.fIdJournal = fIdJournal;
	}

}
