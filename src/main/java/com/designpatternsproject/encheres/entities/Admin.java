package com.designpatternsproject.encheres.entities;

public class Admin {
	private Long idAdmin;
	private String login;
	private String password;
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	
	

}
