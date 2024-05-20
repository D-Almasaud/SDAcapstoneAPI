package pojos.UserServices;

import java.io.Serializable;

public class RecordsDTO implements Serializable {
	private int id;
	private String username;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
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
			"RecordsDTO{" + 
			"id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}