package fid.corefin.batch.model.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(name = "messageOverduePooling", procedureName = "FIN.MESSAGE_OVERDUE_POOLING", resultClasses = {
				OverdueMessagePool.class }, parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "targetDate"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "contractNo"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "phoneNumber"),
						@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "checkOverdueDays") })

@IdClass(OverdueMessagePoolId.class)
public class OverdueMessagePool {

	public static final String NamedQuery_MessageOverduePooling = "messageOverduePooling";

	@Id
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Id
	@Column(name = "IDF_FACILITY_NO")
	private String contractNo;

	@Column(name = "FID_CIF_CUSTOMER")
	private String cdbNo;

	@Column(name = "PERIOD")
	private Integer period;

	@Column(name = "DUE_DATE")
	private Date overdueDate;

	@Column(name = "TEMPLATE_NAME")
	private String templateName;

	@Column(name = "NAME_SPACE")
	private String nameSpace;

	@Column(name = "OVERDUE_DAYS")
	private Integer overdueDays;

	@Column(name = "INSTALLMENT_AMOUNT")
	private BigDecimal installmentAmount;

	@Column(name = "INSTALLMENT_AMOUNT_OVERDUE")
	private BigDecimal installmentAmountOverdue;

	@Column(name = "LATE_CHARGE_TOTAL")
	private BigDecimal lateChargeTotal;
	
	@Column(name = "LATE_CHARGE_UNPAID")
	private BigDecimal lateChargeUnpaid;
	
	@Column(name = "LATE_CHARGE_PAID")
	private BigDecimal lateChargePaid;

	@Column(name = "CONTR_DATE_EXP")
	private Date contractExpireDate;
	
	@Column(name = "LAST_POOLING_DATE")
	private Date lastPoolingDate;

	@Column(name = "LAST_PERIOD_PAID")
	private Integer lastPeriodPaid;
	
	@Column(name = "LAST_DUE_DATE_PAID")
	private Date lastDuedatePaid;
	
	@Column(name = "CURRENT_PERIOD")
	private Integer currentPeriod;
	
	@Column(name = "CURRENT_DUE_DATE")
	private Date currentDueDate; 

	@Column(name = "UNIT_BRAND")
	private String unitBrand;

	@Column(name = "UNIT_TYPE")
	private String unitType;

	@Column(name = "SECURITY_CODE")
	private String securityCode;

	@Column(name = "VA_NO")
	private String vaNo;
	
	@Column(name = "FIDG_FCLT_STATUS")
	private String status;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getCdbNo() {
		return cdbNo;
	}

	public void setCdbNo(String cdbNo) {
		this.cdbNo = cdbNo;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Date getOverdueDate() {
		return overdueDate;
	}

	public void setOverdueDate(Date overdueDate) {
		this.overdueDate = overdueDate;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public Integer getOverdueDays() {
		return overdueDays;
	}

	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}

	public BigDecimal getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(BigDecimal installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public BigDecimal getInstallmentAmountOverdue() {
		return installmentAmountOverdue;
	}

	public void setInstallmentAmountOverdue(BigDecimal installmentAmountOverdue) {
		this.installmentAmountOverdue = installmentAmountOverdue;
	}

	public BigDecimal getLateChargeTotal() {
		return lateChargeTotal;
	}

	public void setLateChargeTotal(BigDecimal lateChargeTotal) {
		this.lateChargeTotal = lateChargeTotal;
	}

	public BigDecimal getLateChargeUnpaid() {
		return lateChargeUnpaid;
	}

	public void setLateChargeUnpaid(BigDecimal lateChargeUnpaid) {
		this.lateChargeUnpaid = lateChargeUnpaid;
	}

	public BigDecimal getLateChargePaid() {
		return lateChargePaid;
	}

	public void setLateChargePaid(BigDecimal lateChargePaid) {
		this.lateChargePaid = lateChargePaid;
	}

	public Date getContractExpireDate() {
		return contractExpireDate;
	}

	public void setContractExpireDate(Date contractExpireDate) {
		this.contractExpireDate = contractExpireDate;
	}

	public Date getLastPoolingDate() {
		return lastPoolingDate;
	}

	public void setLastPoolingDate(Date lastPoolingDate) {
		this.lastPoolingDate = lastPoolingDate;
	}

	public Integer getLastPeriodPaid() {
		return lastPeriodPaid;
	}

	public void setLastPeriodPaid(Integer lastPeriodPaid) {
		this.lastPeriodPaid = lastPeriodPaid;
	}

	public Date getLastDuedatePaid() {
		return lastDuedatePaid;
	}

	public void setLastDuedatePaid(Date lastDuedatePaid) {
		this.lastDuedatePaid = lastDuedatePaid;
	}

	public Integer getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(Integer currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public Date getCurrentDueDate() {
		return currentDueDate;
	}

	public void setCurrentDueDate(Date currentDueDate) {
		this.currentDueDate = currentDueDate;
	}

	public String getUnitBrand() {
		return unitBrand;
	}

	public void setUnitBrand(String unitBrand) {
		this.unitBrand = unitBrand;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getVaNo() {
		return vaNo;
	}

	public void setVaNo(String vaNo) {
		this.vaNo = vaNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

class OverdueMessagePoolId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contractNo;
	private String phoneNumber;

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return false;
		if (obj == null)
			return false;
		if (!(obj instanceof OverdueMessagePoolId))
			return false;
		OverdueMessagePoolId id = (OverdueMessagePoolId) obj;
		return id.contractNo.equals(contractNo) && id.phoneNumber == phoneNumber;
	}
}