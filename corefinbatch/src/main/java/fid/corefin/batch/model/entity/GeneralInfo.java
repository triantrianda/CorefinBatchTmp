package fid.corefin.batch.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "GENERAL_INFORMATION")
@IdClass(OverdueMessageId.class)
public class GeneralInfo {
	@Id
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Id
	@Column(name = "CONTRACT_NO")
	private String contractNo;

	@Column(name = "CDB_NO")
	private String cdbNo;

//	@Id
	@Column(name = "PERIOD")
	private int period;

	@Column(name = "DUEDATE_PAYMENT")
	private Date overdueDate;

	@Column(name = "TEMPLATE_NAME")
	private String templateName;

	@Column(name = "NAME_SPACE")
	private String nameSpace;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

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

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
class OverdueMessageId implements Serializable {

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
}