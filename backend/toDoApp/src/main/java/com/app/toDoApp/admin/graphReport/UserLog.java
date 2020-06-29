package com.app.toDoApp.admin.graphReport;

public class UserLog {
    private String date;
    private int  count;

    public UserLog() { }

    public UserLog(String date,int count) {
        this.date = date;
        this.count = count;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
