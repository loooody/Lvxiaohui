package com.company;

public class User {
    private String name;
    private String userPwd;
    private String grade;

    public User() {
    }

    public User(String name,String userPwd,String grade) {
        this.name = name;
        this.userPwd = userPwd;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
