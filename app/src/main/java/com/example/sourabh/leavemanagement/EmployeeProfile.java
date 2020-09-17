package com.example.sourabh.leavemanagement;

public class EmployeeProfile {

  private   String emailid,name,dept,doj;
    public EmployeeProfile()
    {

    }

    public EmployeeProfile(String emailid, String name, String dept, String doj) {
        this.emailid = emailid;
        this.name = name;
        this.dept = dept;
        this.doj = doj;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getDoj() {
        return doj;
    }
}
