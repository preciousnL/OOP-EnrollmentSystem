package org.example.model;

public class Course {

    private String courseCode;
    private String courseName;
    private String courseProgram;
    private int units;

    public Course(){}

    public Course(String courseCode, String courseName, String courseProgram, int units){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseProgram = courseProgram;
        this.units = units;
    }

    public String getCourseCode(){
        return courseCode;
    }

    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseProgram(){
        return courseProgram;
    }

    public void setCourseProgram(String courseProgram){
        this.courseProgram = courseProgram;
    }

    public int getUnits(){
        return units;
    }

    public void setUnits(int units){
        this.units = units;
    }
}