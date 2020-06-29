package com.app.toDoApp.userInfo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserInfo {

    @Id
    @Column(name="username",nullable = false)
    private String username;
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String birthdate;
    @Column(nullable = false)
    private boolean emailstatus;
    @Column(nullable = false)
    private boolean accstatus=true;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String lastactive;

    public UserInfo() {
    }

    public UserInfo(String username, int id, String name, String lastname, String birthdate, boolean emailstatus, boolean accstatus, String role, String lastactive) {
        this.username = username;
        this.id=id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.emailstatus = emailstatus;
        this.accstatus = accstatus;
        this.role = role;
        this.lastactive =lastactive;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

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

    public boolean getEmailstatus() {
        return emailstatus;
    }
    public void setEmailstatus(boolean emailstatus) {
        this.emailstatus = emailstatus;
    }

    public boolean getAccstatus() {return accstatus;}
    public void setAccstatus(boolean accstatus) {this.accstatus = accstatus;}

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getLastactive() {return lastactive;}
    public void setLastactive(String lastactive) {this.lastactive = lastactive;}

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", emailstatus=" + emailstatus +
                ", accstatus=" + accstatus +
                ", role='" + role + '\'' +
                '}';
    }
}
