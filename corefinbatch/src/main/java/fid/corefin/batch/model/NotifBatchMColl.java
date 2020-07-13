package fid.corefin.batch.model;

import java.util.Date;

public class NotifBatchMColl {

	private Long id;

	private String facilityNo;

	private String customerName;

	private String activity;

	private Date activityDate;

	private String description;

	private Integer priority;

	private Long retry;

	private String createBy;

	private Date createDate;

	public String getFacilityNo() {
		return facilityNo;
	}

	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public NotifBatchMColl() {
		super();
	}

	public NotifBatchMColl(Long id, String facilityNo, String customerName, String activity, Date activityDate,
			String description, Integer priority, Long retry, String createBy, Date createDate) {
		super();
		this.id = id;
		this.facilityNo = facilityNo;
		this.customerName = customerName;
		this.activity = activity;
		this.activityDate = activityDate;
		this.description = description;
		this.priority = priority;
		this.retry = retry;
		this.createBy = createBy;
		this.createDate = createDate;
	}

}
