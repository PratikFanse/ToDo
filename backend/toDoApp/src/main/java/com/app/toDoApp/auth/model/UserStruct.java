package com.app.toDoApp.auth.model;

import com.app.toDoApp.userInfo.UserInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Entity
public class UserStruct implements Serializable {
//    @Id
 public int id;
    public String username;
    public String password;
    public String name;
    public String lastname;
    public String birthdate;
    public boolean emailstatus;
    public boolean accstatus;
    public String role;
    public String lastActive;

    public UserStruct(String username, String password, String name, String lastname, String birthdate) {
        this.id = 0;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.emailstatus = false;
        this.accstatus = true;
        this.role = "user";
        this.lastActive= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public UserInfo getUserInfo(){
        return new UserInfo(username,id,name,lastname,birthdate,emailstatus,accstatus,role,lastActive);
    }
    public DAOUser getDAOUser(){
        return new DAOUser(id,username,password);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isEmailstatus() {
        return emailstatus;
    }
    public void setEmailstatus(boolean emailstatus) {
        this.emailstatus = emailstatus;
    }

    public boolean isAccstatus() {
        return accstatus;
    }
    public void setAccstatus(boolean accstatus) {
        this.accstatus = accstatus;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}
