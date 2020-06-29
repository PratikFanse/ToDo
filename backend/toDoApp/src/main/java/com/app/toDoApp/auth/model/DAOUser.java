package com.app.toDoApp.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true)
	private String username;
	@Column
	private String password;



	public DAOUser(){}
	public DAOUser(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	@Override
	public String toString() {
		return "DAOUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}