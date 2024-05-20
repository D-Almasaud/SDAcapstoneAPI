package pojos.MembershipService;

import java.io.Serializable;

public class MembershipResponseDTO implements Serializable {
	private String defaultRoleName;
	private boolean isActive;
	private int membershipTypeId;
	private boolean isOwner;
	private String createdAt;
	private String appShortName;
	private String organizationName;
	private boolean isDefault;
	private int createdBy;
	private String subscriptionId;
	private String appName;
	private String updatedAt;
	private int userId;
	private long organizationId;
	private int updatedBy;
	private int defaultRoleId;
	private String appLogoUrl;
	private int id;
	private boolean isIndividualMembership;
	private int appId;
	private String username;

	public void setDefaultRoleName(String defaultRoleName){
		this.defaultRoleName = defaultRoleName;
	}

	public String getDefaultRoleName(){
		return defaultRoleName;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setMembershipTypeId(int membershipTypeId){
		this.membershipTypeId = membershipTypeId;
	}

	public int getMembershipTypeId(){
		return membershipTypeId;
	}

	public void setIsOwner(boolean isOwner){
		this.isOwner = isOwner;
	}

	public boolean isIsOwner(){
		return isOwner;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setAppShortName(String appShortName){
		this.appShortName = appShortName;
	}

	public String getAppShortName(){
		return appShortName;
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

	public void setCreatedBy(int createdBy){
		this.createdBy = createdBy;
	}

	public int getCreatedBy(){
		return createdBy;
	}

	public void setSubscriptionId(String subscriptionId){
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionId(){
		return subscriptionId;
	}

	public void setAppName(String appName){
		this.appName = appName;
	}

	public String getAppName(){
		return appName;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setOrganizationId(long organizationId){
		this.organizationId = organizationId;
	}

	public long getOrganizationId(){
		return organizationId;
	}

	public void setUpdatedBy(int updatedBy){
		this.updatedBy = updatedBy;
	}

	public int getUpdatedBy(){
		return updatedBy;
	}

	public void setDefaultRoleId(int defaultRoleId){
		this.defaultRoleId = defaultRoleId;
	}

	public int getDefaultRoleId(){
		return defaultRoleId;
	}

	public void setAppLogoUrl(String appLogoUrl){
		this.appLogoUrl = appLogoUrl;
	}

	public String getAppLogoUrl(){
		return appLogoUrl;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIsIndividualMembership(boolean isIndividualMembership){
		this.isIndividualMembership = isIndividualMembership;
	}

	public boolean isIsIndividualMembership(){
		return isIndividualMembership;
	}

	public void setAppId(int appId){
		this.appId = appId;
	}

	public int getAppId(){
		return appId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"default_role_name = '" + defaultRoleName + '\'' + 
			",is_active = '" + isActive + '\'' + 
			",membership_type_id = '" + membershipTypeId + '\'' + 
			",is_owner = '" + isOwner + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",app_short_name = '" + appShortName + '\'' + 
			",organization_name = '" + organizationName + '\'' + 
			",is_default = '" + isDefault + '\'' + 
			",created_by = '" + createdBy + '\'' + 
			",subscription_id = '" + subscriptionId + '\'' + 
			",app_name = '" + appName + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",organization_id = '" + organizationId + '\'' + 
			",updated_by = '" + updatedBy + '\'' + 
			",default_role_id = '" + defaultRoleId + '\'' + 
			",app_logo_url = '" + appLogoUrl + '\'' + 
			",id = '" + id + '\'' + 
			",is_individual_membership = '" + isIndividualMembership + '\'' + 
			",app_id = '" + appId + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}