package edu.lawrence.getoutdoors.interfaces.dtos;

public class UserDTO{
	
	private String username;
	private String password;
	private String token;
	
	public UserDTO() {
		token = "";
	}
	
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

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}