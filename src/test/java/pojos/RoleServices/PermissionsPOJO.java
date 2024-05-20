package pojos.RoleServices;

import java.io.Serializable;

public class PermissionsPOJO implements Serializable {
	private int id;
	private String resource;
	private String action;
	private int appId;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setResource(String resource){
		this.resource = resource;
	}

	public String getResource(){
		return resource;
	}

	public void setAction(String action){
		this.action = action;
	}

	public String getAction(){
		return action;
	}

	public void setAppId(int appId){
		this.appId = appId;
	}

	public int getAppId(){
		return appId;
	}

	@Override
 	public String toString(){
		return 
			"PermissionsDTO{" + 
			"id = '" + id + '\'' + 
			",resource = '" + resource + '\'' + 
			",action = '" + action + '\'' + 
			",app_id = '" + appId + '\'' + 
			"}";
		}
}