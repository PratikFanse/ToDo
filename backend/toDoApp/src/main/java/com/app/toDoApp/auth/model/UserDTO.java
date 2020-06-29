package com.app.toDoApp.auth.model;

import java.util.Date;

public class UserDTO {
	private String name;
	private String lastname;
	private String birthdate;
	private String username;
	private String password;


	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}

	public String getBirthdate() {return birthdate;}
	public void setBirthdate(String birthdate) {this.birthdate = birthdate;}

	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

}