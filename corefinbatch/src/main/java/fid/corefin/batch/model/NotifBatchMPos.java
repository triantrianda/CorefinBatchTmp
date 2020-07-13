package fid.corefin.batch.model;

import java.util.Date;

public class NotifBatchMPos {

	private Long id;

	private String fidUser;

	private String parameter;

	private String text;

	private String title;

	private String actionType;

	private Integer priority = 1;

	private Long retry = 1l;

	private String createBy;

	private Date createDate;

	public NotifBatchMPos() {
		super();
	}

	public String getFidUser() {
		return fidUser;
	}

	public void setFidUser(String fidUser) {
		this.fidUser = fidUser;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotifBatchMPos(Long id, String fidUser, String parameter, String text, String title, String actionType,
			Integer priority, Long retry, String createBy, Date createDate) {
		super();
		this.id = id;
		this.fidUser = fidUser;
		this.parameter = parameter;
		this.text = text;
		this.title = title;
		this.actionType = actionType;
		this.priority = priority;
		this.retry = retry;
		this.createBy = createBy;
		this.createDate = createDate;
	}

}
