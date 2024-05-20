package pojos.UserServices;

import java.io.Serializable;

public class UserGroupsPOJO implements Serializable {
	private int id;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"UserGroupsPOJO{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}