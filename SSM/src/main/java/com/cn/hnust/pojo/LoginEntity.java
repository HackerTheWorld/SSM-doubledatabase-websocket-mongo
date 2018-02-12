package com.cn.hnust.pojo;

public class LoginEntity {

	private Integer login_ID;
	private String username;
	private String password;
	private Integer user_id;
	private String token;
	private String headimg;

	public Integer getLogin_ID() {
		return login_ID;
	}

	public void setLogin_ID(Integer login_ID) {
		this.login_ID = login_ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg == null ? null : headimg.trim();
	}
}