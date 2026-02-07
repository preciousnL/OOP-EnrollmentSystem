package org.example;

public class Course {
    private String courseCode;
    private String courseName;
    private String courseProgram;

    public Course(){

    }

    public String getCourseID(){
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
        System.out.printf("Course Code: %s", courseCode);
        System.out.printf("\nCourse Name: %s", courseName);
        System.out.printf("\nCourse Program: %s\n", courseProgram);
    }
}
