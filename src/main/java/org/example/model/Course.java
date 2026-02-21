package org.example.model;

public class Course {
    private String courseCode;
    private String courseName;
    private String courseProgram;

    public Course(){

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

    public void display(){
        System.out.println("\nCourse Details:");
        System.out.printf("Course Code: %s", getCourseCode());
        System.out.printf("\nCourse Name: %s", getCourseName());
        System.out.printf("\nCourse Program: %s\n", getCourseProgram());
    }
}
