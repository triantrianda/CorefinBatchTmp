package fid.corefin.batch.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "M_NOTIF_ARCHIVE")
public class MobileNotificationArchive {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;
	
	@Column(name = "FID_USER", nullable = true)
    private String fidUser;
	
	@Column(name = "STATUS_NOTIF", nullable = true)
    private String statusNotif;
	
	@Column(name = "PARAMETER", nullable = true)
    private String parameter;
	
	@Column(name = "TEXT", nullable = true)
    private String text;
	
	@Column(name = "TITLE", nullable = true)
    private String title;

	@Column(name = "ACTION_TYPE", nullable = true)
    private String actionType;

	@Column(name = "ACTIVE_IND", nullable = true)
    private Character activeInd;
	
	@Column(name = "PRIORITY", nullable = true)
    private Integer priority;
	
	@Column(name = "RETRY", nullable = true)
    private Long retry;
	
	@Column(name = "STATUS", nullable = true)
	private Character status;
	
	@Column(name = "CREATE_BY", nullable = true)
    private String createBy;
	
	@Column(name = "CREATE_DATE", nullable = true)
    private Date createDate;
	
	@Column(name = "LAST_UPDATE_BY", nullable = true)
    private String lastUpdateBy;
	
	@Column(name = "LAST_UPDATE_DATE", nullable = true)
    private Date lastUpdateDate;
	
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
	
	public String getFidUser() {
		return fidUser;
	}

	public void setFidUser(String fidUser) {
		this.fidUser = fidUser;
	}

	public String getStatusNotif() {
		return statusNotif;
	}

	public void setStatusNotif(String statusNotif) {
		this.statusNotif = statusNotif;
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

	public Character getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(Character activeInd) {
		this.activeInd = activeInd;
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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
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

}
