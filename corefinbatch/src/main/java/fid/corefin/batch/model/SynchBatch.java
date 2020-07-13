package fid.corefin.batch.model;

import java.util.Date;

public class SynchBatch {

	private String batchCode;

	private Date executionDate;

	private String lookupNarrative;

	private String statementId;

	private String statementText;

	private Integer priority = 1;

	private Long retry = 1l;

	private String createBy;

	private Date createDate;

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
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

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public SynchBatch() {
		super();
	}

	public SynchBatch(String batchCode, Date executionDate, String lookupNarrative, String statementId,
			String statementText, Integer priority, Long retry, String createBy, Date createDate) {
		super();
		this.batchCode = batchCode;
		this.executionDate = executionDate;
		this.lookupNarrative = lookupNarrative;
		this.statementId = statementId;
		this.statementText = statementText;
		this.priority = priority;
		this.retry = retry;
		this.createBy = createBy;
		this.createDate = createDate;
	}

}
