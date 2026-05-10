package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList<Course> courses = new ArrayList<>();

    public Instructor() {
    }

    public Instructor(int id, String name) {
        super(id, name);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public void mainTask() {
        System.out.println("\nWelcome, professor!");
    }
}
