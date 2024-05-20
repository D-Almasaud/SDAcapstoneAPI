package pojos.UserStatusServices;

import java.io.Serializable;

public class USSPOJO implements Serializable {
	private Object id;
	private String name;
	private String description;

	public USSPOJO(Object id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public USSPOJO() {
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
			"USSPOJO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}