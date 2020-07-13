package fid.corefin.batch.model;

import java.util.Date;

public class DMBatch {

	private String id;

	private String start;

	private String end;

	private String dateExecution;

	private Date executionStart;

	private Date executionEnd;

	private String description;

	private String information;

	private Integer sequence;

	public DMBatch(String id, String start, String end, String dateExecution, Date executionStart, Date executionEnd,
			String description, String information, Integer sequence) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.dateExecution = dateExecution;
		this.executionStart = executionStart;
		this.executionEnd = executionEnd;
		this.description = description;
		this.information = information;
		this.sequence = sequence;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Date getExecutionStart() {
		return executionStart;
	}

	public void setExecutionStart(Date executionStart) {
		this.executionStart = executionStart;
	}

	public Date getExecutionEnd() {
		return executionEnd;
	}

	public void setExecutionEnd(Date executionEnd) {
		this.executionEnd = executionEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(String dateExecution) {
		this.dateExecution = dateExecution;
	}

}
