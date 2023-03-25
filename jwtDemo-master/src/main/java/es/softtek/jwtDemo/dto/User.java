package es.softtek.jwtDemo.dto;

public class User {

	private String username;
	private String pwd;
	private String token;

	public String getUser() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
