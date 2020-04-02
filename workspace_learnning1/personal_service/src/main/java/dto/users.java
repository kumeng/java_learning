package dto;

import java.io.Serializable;

public class users implements Serializable {


	private String username;
	private String password;
	private computer cp;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public computer getCp() {
		return cp;
	}
	public void setCp(computer cp) {
		this.cp = cp;
	}	
}
