package com.example.sourabh.leavemanagement;

public class HOD {
    String Name,Department,Password;
    public HOD()
    {

    }

    public HOD(String name, String department, String password) {
        Name = name;
        Department = department;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public String getDepartment() {
        return Department;
    }

    public String getPassword() {
        return Password;
    }
}
