package pojos.RoleServices;

import java.util.List;
import java.io.Serializable;

public class AddNewRolePOJO implements Serializable {
	private int id;
	private String name;
	private int appId;
	private String description;
	private List<PermissionsPOJO> permissions;

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

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPermissions(List<PermissionsPOJO> permissions){
		this.permissions = permissions;
	}

	public List<PermissionsPOJO> getPermissions(){
		return permissions;
	}

	public AddNewRolePOJO() {
	}

	public AddNewRolePOJO(int id, String name, int appId, String description, List<PermissionsPOJO> permissions) {
		this.id = id;
		this.name = name;
		this.appId = appId;
		this.description = description;
		this.permissions = permissions;
	}

	@Override
 	public String toString(){
		return 
			"AddNewRoleDTO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",app_id = '" + appId + '\'' + 
			",description = '" + description + '\'' + 
			",permissions = '" + permissions + '\'' + 
			"}";
		}
}