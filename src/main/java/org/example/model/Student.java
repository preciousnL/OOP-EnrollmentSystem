package org.example.model;

import java.util.ArrayList;

public class Student extends Person{
    private ArrayList<Course> courses = new ArrayList<>();
    private String studProgram;

    public Student(int id, String name, String program) {
        super(id, name);
        this.studProgram = program;
    }

    public String getStudProgram(){
        return studProgram;
    }

    public void setStudProgram(String studProgram){
        this.studProgram = studProgram;
    }

    public void display(){
        System.out.println("\nStudent Details:");
        System.out.printf("Student ID: %d", getId());
        System.out.printf("\nStudent Name: %s", getName());
        System.out.printf("\nStudent Program: %s\n", getStudProgram());
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }
}
