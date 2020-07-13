package fid.corefin.batch.model;

public class GeneralBatchInfo {

	private String name;

	private String type;

	private String id;
	
	public GeneralBatchInfo() {
	}

	public GeneralBatchInfo(String name, String type, String id) {
		super();
		this.name = name;
		this.type = type;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
