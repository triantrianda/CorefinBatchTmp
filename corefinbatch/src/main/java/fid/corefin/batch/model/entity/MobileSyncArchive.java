package fid.corefin.batch.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "M_SYNC_ARCHIVE")
public class MobileSyncArchive {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;
	
	@Column(name = "BATCH_CODE", nullable = true)
    private String batchCode;
	
	@Column(name = "EXECUTION_DATE", nullable = true)
    private String executionDate;
	
	@Column(name = "RUNNING_STATUS", nullable = true)
    private char runningStatus;
	
	@Column(name = "LOOKUP_NARRATIVE", nullable = true)
    private String lookupNarrative;
	
	@Column(name = "STATEMENT_ID", nullable = true)
    private String statementId;

	@Column(name = "STATEMENT_TEXT", nullable = true)
    private String statementText;

	@Column(name = "STATUS", nullable = true)
    private char status;
	
	@Column(name = "PRIORITY", nullable = true)
    private Integer priority;
	
	@Column(name = "RETRY", nullable = true)
    private Long retry;
	
	@Column(name = "PROCESSED_DATE", nullable = true)
    private Date processedDate;

	@Column(name = "CREATE_BY", nullable = true)
    private String createBy;
	
	@Column(name = "CREATE_DATE", nullable = true)
    private Date createDate;
	
	@Column(name = "RESPONSE", nullable = true)
    private String response;
	
	@Column(name = "RESPONSE_STATUS", nullable = true)
    private Integer responseStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public char getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(char runningStatus) {
		this.runningStatus = runningStatus;
	}

	public String getLookupNarrative() {
		return lookupNarrative;
	}

	public void setLookupNarrative(String lookupNarrative) {
		this.lookupNarrative = lookupNarrative;
	}

	public String getStatementId() {
		return statementId;
	}

	public void setStatementId(String statementId) {
		this.statementId = statementId;
	}

	public String getStatementText() {
		return statementText;
	}

	public void setStatementText(String statementText) {
		this.statementText = statementText;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Long getRetry() {
		return retry;
	}

	public void setRetry(Long retry) {
		this.retry = retry;
	}
	
	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	public Date getDateFromExecutionDate() {
		Long milliSeconds= Long.parseLong(executionDate);
		return new Date(milliSeconds);
	}

}
