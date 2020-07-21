package fid.corefin.batch.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WA_POOLING")
public class WaPooling {

	@Id
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "TOTAL_PLAN_POOL")
	private int totalPlanPool;
	
	@Column(name = "TOTAL_ACTUAL_POOL")
	private int totalActualPool;
	
	@Column(name = "DEVIATION_DATA")
	private int deviationData;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalPlanPool() {
		return totalPlanPool;
	}

	public void setTotalPlanPool(int totalPlanPool) {
		this.totalPlanPool = totalPlanPool;
	}

	public int getTotalActualPool() {
		return totalActualPool;
	}

	public void setTotalActualPool(int totalActualPool) {
		this.totalActualPool = totalActualPool;
	}

	public int getDeviationData() {
		return deviationData;
	}

	public void setDeviationData(int deviationData) {
		this.deviationData = deviationData;
	}
		
}
