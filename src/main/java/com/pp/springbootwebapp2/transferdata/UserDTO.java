package com.pp.springbootwebapp2.transferdata;

public class UserDTO {

	private String name;
	private String password;
	
	public UserDTO() {}
	
	public UserDTO(String name , String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
