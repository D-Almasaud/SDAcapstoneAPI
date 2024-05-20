package pojos.RoleServices;

import java.io.Serializable;

public class UpdateExistingRolePOJO implements Serializable {
	private int id;
	private String name;
	private int appId;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAppId(int appId){
		this.appId = appId;
	}

	public int getAppId(){
		return appId;
	}

	public UpdateExistingRolePOJO() {
	}

	public UpdateExistingRolePOJO(int id, String name, int appId) {
		this.id = id;
		this.name = name;
		this.appId = appId;
	}


	@Override
 	public String toString(){
		return 
			"UpdateExistingRoleDTO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",app_id = '" + appId + '\'' + 
			"}";
		}
}