package fid.corefin.batch.model;

import java.util.Date;

public class JournalBatch {

	private Long id;

	private Long retry;

	private String refId;

	private String module;

	private String createBy;

	private Date createDate;

	private Integer priority;

	public JournalBatch(Long id, Long retry, String refId, String module, String createBy, Date createDate,
			Integer priority) {
		super();
		this.id = id;
		this.retry = retry;
		this.refId = refId;
		this.module = module;
		this.createBy = createBy;
		this.createDate = createDate;
		this.priority = priority;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
