package pojos.organization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizitionPOJO implements Serializable {
	private long id;
	private String name;
	private int founder_id;

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public OrganizitionPOJO() {
	}

	public OrganizitionPOJO(long id, String name, int founder_id) {
		this.id = id;
		this.name = name;
		this.founder_id = founder_id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFounder_id(int founder_id){
		this.founder_id = founder_id;
	}

	public int getFounder_id(){
		return founder_id;
	}

	@Override
 	public String toString(){
		return 
			"OrganizitionPOJO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",founder_id = '" + founder_id + '\'' +
			"}";
		}
}