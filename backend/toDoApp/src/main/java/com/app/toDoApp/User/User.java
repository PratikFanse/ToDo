//package com.app.toDoApp.User;
//
//import javax.persistence.*;
//
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(nullable = false)
//    private String name;
//    @Column(nullable = false)
//    private String lastname;
//    @Column(nullable = false)
//    private String birthdate;
//    @Column(nullable = false,unique = true)
//    private String username;
//    //	@JsonIgnore
//    @Column
//    private String password;
//    @Column(nullable = false)
//    private boolean emailstatus;
//    @Column(nullable = false)
//    private boolean accstatus;
//    @Column(nullable = false)
//    private String role;
//
//
//    public User(){}
//    public User(int id, String name, String lastname,String birthdate, String username, String password, boolean emailstatus, boolean accstatus, String role) {
//        this.id = id;
//        this.name = name;
//        this.lastname = lastname;
//        this.birthdate= birthdate;
//        this.username = username;
//        this.password = password;
//        this.emailstatus = emailstatus;
//        this.accstatus = accstatus;
//        this.role = role;
//    }
//
//    public int getId() {return id;}
//    public void setId(int id) {this.id = id;}
//
//    public String getName() {return name;}
//    public void setName(String name) {this.name = name;}
//
//    public String getLastname() {return lastname;}
//    public void setLastname(String lastname) {this.lastname = lastname;}
//
//    public String getBirthdate() {return birthdate;}
//    public void setBirthdate(String birthdate) {this.birthdate = birthdate;}
//
//    public String getUsername() {return username;}
//    public void setUsername(String username) {this.username = username;}
//
//    public String getPassword() {return password;}
//    public void setPassword(String password) {this.password = password;}
//
//    public boolean getEmailstatus() {return emailstatus;}
//    public void setEmailstatus(boolean emailstatus) {this.emailstatus = emailstatus;}
//
//    public boolean getAccstatus() {return accstatus;}
//    public void setAccstatus(boolean accstatus) {this.accstatus = accstatus;}
//
//    public String getRole() {return role;}
//    public void setRole(String role) {this.role = role;}
//
//    @Override
//    public String toString() {
//        return "DAOUser{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", birthdate='" + birthdate + '\'' +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", emailstatus=" + emailstatus +
//                ", accstatus=" + accstatus +
//                ", role='" + role + '\'' +
//                '}';
//    }
//}
