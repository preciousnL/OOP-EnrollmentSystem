package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList<Course> courses = new ArrayList<>();
    private String course;

    public Instructor(int id, String name){
        super (id, name);
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }
}
