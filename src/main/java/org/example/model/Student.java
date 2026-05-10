package org.example.model;

import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<Course> courses = new ArrayList<>();
    private String studProgram;

    public Student() {
    }

    public Student(int id, String name, String program) {
        super(id, name);
        this.studProgram = program;
    }

    public String getStudProgram() {
        return studProgram;
    }

    public void setStudProgram(String studProgram) {
        this.studProgram = studProgram;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
