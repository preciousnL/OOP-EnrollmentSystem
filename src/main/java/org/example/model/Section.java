package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor instructor;
    private List<Student> enrolledStudents;

    public Section() {
        this.enrolledStudents = new ArrayList<>();
    }

    public Section(String sectionName, int maxCapacity, Instructor instructor) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
