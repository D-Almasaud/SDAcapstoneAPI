package pojos.UserServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserPOJO implements Serializable {
	private Integer id;
	private int app_id;
	private long organization_id;
	private String email;
	private String subscription_id;
	private int default_role_id;
	private List<UserGroupsPOJO> user_groups;

	public CreateUserPOJO() {
	}

	public CreateUserPOJO(Integer id,int app_id, long organization_id, String email, String subscription_id, int default_role_id, List<UserGroupsPOJO> user_groups) {
		this.id = id;
		this.app_id = app_id;
		this.organization_id = organization_id;
		this.email = email;
		this.subscription_id = subscription_id;
		this.default_role_id = default_role_id;
		this.user_groups = user_groups;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public void setApp_id(int app_id){
		this.app_id = app_id;
	}

	public Integer getId() {
		return id;
	}

	public int getApp_id(){
		return app_id;
	}

	public void setOrganization_id(long organization_id){
		this.organization_id = organization_id;
	}

	public long getOrganization_id(){
		return organization_id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setSubscription_id(String subscription_id){
		this.subscription_id = subscription_id;
	}

	public String getSubscription_id(){
		return subscription_id;
	}

	public void setDefault_role_id(int default_role_id){
		this.default_role_id = default_role_id;
	}

	public int getDefault_role_id(){
		return default_role_id;
	}

public void setUser_groups(List<UserGroupsPOJO> user_groups){
	this.user_groups = user_groups;
}

public List<UserGroupsPOJO> getUser_groups(){
	return user_groups;
}

	@Override
	public String toString() {
		return "CreateUserPOJO{" +
				"id=" + id +
				", app_id=" + app_id +
				", organization_id=" + organization_id +
				", email='" + email + '\'' +
				", subscription_id='" + subscription_id + '\'' +
				", default_role_id=" + default_role_id +
				", user_groups=" + user_groups +
				'}';
	}
}