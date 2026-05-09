package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList<Course> Courses = new ArrayList<>();

    public Instructor() {
    }

    public Instructor(String personID, String personName) {
        super(personID, personName);
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.Courses = courses;
    }

    @Override
    public void mainTask() {
        System.out.println("Welcome, professor!");
    }
}
