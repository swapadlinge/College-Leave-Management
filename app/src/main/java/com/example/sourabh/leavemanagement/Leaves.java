package com.example.sourabh.leavemanagement;

public class Leaves {
    String id, name, dept ,days, date , month ,year ,reason,status;

    public Leaves()
    {

    }

    public Leaves(String id, String name, String dept, String days, String date, String month, String year, String reason, String status) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.days = days;
        this.date = date;
        this.month = month;
        this.year = year;
        this.reason = reason;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getDays() {
        return days;
    }

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }
}
