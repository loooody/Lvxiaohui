package com.company;

public class ReserInfo {
    private String ID;
    private String name_coach;
    private String name_stu;
    private String start_Time;
    private String end_Time;
    private String car_num;

    public ReserInfo() {
    }

    public ReserInfo(String ID,String name_coach,String name_stu,String start_Time,String end_Time,String car_num){
        this.ID = ID;
        this.name_coach = name_coach;
        this.name_stu = name_stu;
        this.start_Time = start_Time;
        this.end_Time = end_Time;
        this.car_num = car_num;
    }

    public String getID() {
        return ID;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public String getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(String end_Time) {
        this.end_Time = end_Time;
    }

    public String getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(String start_Time) {
        this.start_Time = start_Time;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName_stu() {
        return name_stu;
    }

    public void setName_stu(String name_stu) {
        this.name_stu = name_stu;
    }

    public String getName_coach() {
        return name_coach;
    }

    public void setName_coach(String name_coach) {
        this.name_coach = name_coach;
    }
}
