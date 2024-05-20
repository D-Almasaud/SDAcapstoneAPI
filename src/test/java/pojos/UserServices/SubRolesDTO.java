package pojos.UserServices;

import java.io.Serializable;

public class SubRolesDTO implements Serializable {
	private int roleId;
	private String name;
	private String subscriptionId;
	private long organizationId;
	private String organizationName;
	private boolean isDefault;
	private boolean jsonMemberDefault;

	public void setRoleId(int roleId){
		this.roleId = roleId;
	}

	public int getRoleId(){
		return roleId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSubscriptionId(String subscriptionId){
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionId(){
		return subscriptionId;
	}

	public void setOrganizationId(long organizationId){
		this.organizationId = organizationId;
	}

	public long getOrganizationId(){
		return organizationId;
	}

	public void setOrganizationName(String organizationName){
		this.organizationName = organizationName;
	}

	public String getOrganizationName(){
		return organizationName;
	}

	public void setIsDefault(boolean isDefault){
		this.isDefault = isDefault;
	}

	public boolean isIsDefault(){
		return isDefault;
	}

	public void setJsonMemberDefault(boolean jsonMemberDefault){
		this.jsonMemberDefault = jsonMemberDefault;
	}

	public boolean isJsonMemberDefault(){
		return jsonMemberDefault;
	}

	@Override
 	public String toString(){
		return 
			"SubRolesDTO{" + 
			"role_id = '" + roleId + '\'' + 
			",name = '" + name + '\'' + 
			",subscription_id = '" + subscriptionId + '\'' + 
			",organization_id = '" + organizationId + '\'' + 
			",organization_name = '" + organizationName + '\'' + 
			",is_default = '" + isDefault + '\'' + 
			",default = '" + jsonMemberDefault + '\'' + 
			"}";
		}
}