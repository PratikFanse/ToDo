package com.app.toDoApp.tasks;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskid;
    @Column(nullable = false)
    private String task;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private int userid;

    public Task(){}

    public Task(int taskId, String task, String status, int taskid) {
        this.taskid = taskid;
        this.task = task;
        this.status = status;
        this.userid= userid;
    }

    public int getTaskid() {return taskid;}
    public void setTaskid(int taskid) {this.taskid = taskid;}

    public String getTask() {return task;}
    public void setTask(String task) {this.task = task;}

    public String getStatus() {return status;}
    public void setStatus(String taskStatus) {this.status = taskStatus;}

    public int getUserid() {return userid;}
    public void setUserid(int userid) {this.userid = userid;}
}
