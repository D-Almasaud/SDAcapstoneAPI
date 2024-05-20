package pojos.UserGroupServices;

import java.io.Serializable;
//@JsonIgnoreProperties(ignoreUnknown = true) when add more info
public class UserGruopFullPOJO implements Serializable {
	private Integer id;
	private String name;
	private String short_name;
	private String description;
	private int group_type_id;
	private long organization_id;

	public UserGruopFullPOJO() {
	}

	public UserGruopFullPOJO(Integer id, String name, String short_name, String description, int group_type_id, long organization_id) {
		this.id = id;
		this.name = name;
		this.short_name = short_name;
		this.description = description;
		this.group_type_id = group_type_id;
		this.organization_id = organization_id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setShort_name(String short_name){
		this.short_name = short_name;
	}

	public String getShort_name(){
		return short_name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setGroup_type_id(int group_type_id){
		this.group_type_id = group_type_id;
	}

	public int getGroup_type_id(){
		return group_type_id;
	}

	public void setOrganization_id(long organization_id){
		this.organization_id = organization_id;
	}

	public long getOrganization_id(){
		return organization_id;
	}

	@Override
 	public String toString(){
		return 
			"UserGruopFullPOJO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",short_name = '" + short_name + '\'' +
			",description = '" + description + '\'' + 
			",group_type_id = '" + group_type_id + '\'' +
			",organization_id = '" + organization_id + '\'' +
			"}";
		}
}