package pojos.organization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrgnizationPOJO {

	@JsonProperty("founder_id")
	private int founderId;

	public CreateOrgnizationPOJO(int founderId, String name) {
		this.founderId = founderId;
		this.name = name;
	}

	@JsonProperty("name")
	private String name;

	public int getFounderId(){
		return founderId;
	}

	public String getName(){
		return name;
	}
}