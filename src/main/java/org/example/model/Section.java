package org.example.model;

import java.util.ArrayList;
import java.util.List;

import org.example.exceptions.SectionFullException;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor instructor;
    private Course course;
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

    public Section(String sectionName, int maxCapacity, Instructor instructor, Course course) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.instructor = instructor;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void enrollStudent(Student student) throws SectionFullException {
        if (enrolledStudents.size() >= maxCapacity) {
            throw new SectionFullException("Section " + sectionName + " has reached its maximum capacity of " + maxCapacity + ".");
        }
        enrolledStudents.add(student);
    }
}
