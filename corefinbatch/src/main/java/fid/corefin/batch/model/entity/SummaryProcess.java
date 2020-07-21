package fid.corefin.batch.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUMMARY_PROCESS")
public class SummaryProcess  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUMMARY_ID")
	private Integer summary_id;

	@Column(name = "CREATE_DATE")
	private Date create_date;

	@Column(name = "PROCESS_TYPE")
	private String process_type;

	@Column(name = "DESCRIPTION")
	private String description;

	public Integer getSummary_id() {
		return summary_id;
	}

	public void setSummary_id(Integer summary_id) {
		this.summary_id = summary_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getProcess_type() {
		return process_type;
	}

	public void setProcess_type(String process_type) {
		this.process_type = process_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
