package fid.corefin.batch.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "WA_SEND_TEMPLATE")
public class WaSendTemplate {
	@Id
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "TOTAL_PLAN_SEND_TEMPLATE")
	private int totalPlanSendTemplate;
	
	@Column(name = "TOTAL_ACTUAL_SEND_TEMPLATE")
	private int totalActualSendTemplate;
	
	@Column(name = "PENDING_ENROUTE")
	private int pendingEnroute;
	
	@Column(name = "REJECT")
	private int reject;
	
	@Column(name = "ERROR")
	private int error;
	
	@Column(name = "DEVIATION_DATA")
	private int deviationData;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalPlanSendTemplate() {
		return totalPlanSendTemplate;
	}

	public void setTotalPlanSendTemplate(int totalPlanSendTemplate) {
		this.totalPlanSendTemplate = totalPlanSendTemplate;
	}

	public int getTotalActualSendTemplate() {
		return totalActualSendTemplate;
	}

	public void setTotalActualSendTemplate(int totalActualSendTemplate) {
		this.totalActualSendTemplate = totalActualSendTemplate;
	}

	public int getPendingEnroute() {
		return pendingEnroute;
	}

	public void setPendingEnroute(int pendingEnroute) {
		this.pendingEnroute = pendingEnroute;
	}

	public int getReject() {
		return reject;
	}

	public void setReject(int reject) {
		this.reject = reject;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public int getDeviationData() {
		return deviationData;
	}

	public void setDeviationData(int deviationData) {
		this.deviationData = deviationData;
	}
	
}