package pojos.UserServices;

import java.util.List;
import java.io.Serializable;

public class ResponseDTO implements Serializable {
	private String sub;
	private String subStatus;
	private int subDefaultMembershipTypeId;
	private int subId;
	private String subDefaultSubscriptionId;
	private int subApp;
	private String iss;
	private long subDefaultOrgId;
	private String nonce;
	private List<String> subPermissions;
	private List<String> aud;
	private String subDefaultOrgName;
	private String azp;
	private int subDefaultRoleId;
	private String exp;
	private String iat;
	private List<SubRolesDTO> subRoles;
	private String subDefaultOrgCurrency;

	public void setSub(String sub){
		this.sub = sub;
	}

	public String getSub(){
		return sub;
	}

	public void setSubStatus(String subStatus){
		this.subStatus = subStatus;
	}

	public String getSubStatus(){
		return subStatus;
	}

	public void setSubDefaultMembershipTypeId(int subDefaultMembershipTypeId){
		this.subDefaultMembershipTypeId = subDefaultMembershipTypeId;
	}

	public int getSubDefaultMembershipTypeId(){
		return subDefaultMembershipTypeId;
	}

	public void setSubId(int subId){
		this.subId = subId;
	}

	public int getSubId(){
		return subId;
	}

	public void setSubDefaultSubscriptionId(String subDefaultSubscriptionId){
		this.subDefaultSubscriptionId = subDefaultSubscriptionId;
	}

	public String getSubDefaultSubscriptionId(){
		return subDefaultSubscriptionId;
	}

	public void setSubApp(int subApp){
		this.subApp = subApp;
	}

	public int getSubApp(){
		return subApp;
	}

	public void setIss(String iss){
		this.iss = iss;
	}

	public String getIss(){
		return iss;
	}

	public void setSubDefaultOrgId(long subDefaultOrgId){
		this.subDefaultOrgId = subDefaultOrgId;
	}

	public long getSubDefaultOrgId(){
		return subDefaultOrgId;
	}

	public void setNonce(String nonce){
		this.nonce = nonce;
	}

	public String getNonce(){
		return nonce;
	}

	public void setSubPermissions(List<String> subPermissions){
		this.subPermissions = subPermissions;
	}

	public List<String> getSubPermissions(){
		return subPermissions;
	}

	public void setAud(List<String> aud){
		this.aud = aud;
	}

	public List<String> getAud(){
		return aud;
	}

	public void setSubDefaultOrgName(String subDefaultOrgName){
		this.subDefaultOrgName = subDefaultOrgName;
	}

	public String getSubDefaultOrgName(){
		return subDefaultOrgName;
	}

	public void setAzp(String azp){
		this.azp = azp;
	}

	public String getAzp(){
		return azp;
	}

	public void setSubDefaultRoleId(int subDefaultRoleId){
		this.subDefaultRoleId = subDefaultRoleId;
	}

	public int getSubDefaultRoleId(){
		return subDefaultRoleId;
	}

	public void setExp(String exp){
		this.exp = exp;
	}

	public String getExp(){
		return exp;
	}

	public void setIat(String iat){
		this.iat = iat;
	}

	public String getIat(){
		return iat;
	}

	public void setSubRoles(List<SubRolesDTO> subRoles){
		this.subRoles = subRoles;
	}

	public List<SubRolesDTO> getSubRoles(){
		return subRoles;
	}

	public void setSubDefaultOrgCurrency(String subDefaultOrgCurrency){
		this.subDefaultOrgCurrency = subDefaultOrgCurrency;
	}

	public String getSubDefaultOrgCurrency(){
		return subDefaultOrgCurrency;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"sub = '" + sub + '\'' + 
			",sub_status = '" + subStatus + '\'' + 
			",sub_default_membership_type_id = '" + subDefaultMembershipTypeId + '\'' + 
			",sub_id = '" + subId + '\'' + 
			",sub_default_subscription_id = '" + subDefaultSubscriptionId + '\'' + 
			",sub_app = '" + subApp + '\'' + 
			",iss = '" + iss + '\'' + 
			",sub_default_org_id = '" + subDefaultOrgId + '\'' + 
			",nonce = '" + nonce + '\'' + 
			",sub_permissions = '" + subPermissions + '\'' + 
			",aud = '" + aud + '\'' + 
			",sub_default_org_name = '" + subDefaultOrgName + '\'' + 
			",azp = '" + azp + '\'' + 
			",sub_default_role_id = '" + subDefaultRoleId + '\'' + 
			",exp = '" + exp + '\'' + 
			",iat = '" + iat + '\'' + 
			",sub_roles = '" + subRoles + '\'' + 
			",sub_default_org_currency = '" + subDefaultOrgCurrency + '\'' + 
			"}";
		}
}