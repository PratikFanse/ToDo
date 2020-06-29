package com.app.toDoApp.admin.graphReport;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GraphData{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String date;
    private int regcount;
    private int taskcount;

    public GraphData() {}

    public GraphData(String date, int regcount, int taskcount) {
        this.date = date;
        this.regcount = regcount;
        this.taskcount = taskcount;
    }

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public int getRegcount() {return regcount;}
    public void setRegcount(int regcount) {this.regcount = regcount;}

    public int getTaskcount() {return taskcount;}
    public void setTaskcount(int taskcount) {this.taskcount = taskcount;}

    @Override
    public String toString() {
        return "GraphData{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", regcount=" + regcount +
                ", taskcount=" + taskcount +
                '}';
    }
}
