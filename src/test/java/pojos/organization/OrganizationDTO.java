package pojos.organization;

import java.io.Serializable;

public class OrganizationDTO implements Serializable {
	private String name;
	private int founderId;
	private String createdAt;
	private int createdBy;
	private String updatedAt;
	private int updatedBy;

	public OrganizationDTO(String name, int founderId, String createdAt, int createdBy, String updatedAt, int updatedBy) {
		this.name = name;
		this.founderId = founderId;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public OrganizationDTO() {
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFounderId(int founderId){
		this.founderId = founderId;
	}

	public int getFounderId(){
		return founderId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setCreatedBy(int createdBy){
		this.createdBy = createdBy;
	}

	public int getCreatedBy(){
		return createdBy;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUpdatedBy(int updatedBy){
		this.updatedBy = updatedBy;
	}

	public int getUpdatedBy(){
		return updatedBy;
	}

	@Override
 	public String toString(){
		return 
			"OrganizationDTO{" + 
			"name = '" + name + '\'' + 
			",founder_id = '" + founderId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",created_by = '" + createdBy + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",updated_by = '" + updatedBy + '\'' + 
			"}";
		}
}