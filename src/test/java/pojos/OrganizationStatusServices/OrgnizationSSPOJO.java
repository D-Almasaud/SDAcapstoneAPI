package pojos.OrganizationStatusServices;

import java.io.Serializable;

public class OrgnizationSSPOJO implements Serializable {
	private Object id;
	private String name;
	private String description;

	public OrgnizationSSPOJO() {
	}

	public OrgnizationSSPOJO(Object id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public void setId(Object id){
		this.id = id;
	}

	public Object getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"OrgnizationSSPOJO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}