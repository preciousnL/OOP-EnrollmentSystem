package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

public class CourseServiceImpl implements ICourseService {
    private ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void save(Course course) {
        courseList.add(course);
        System.out.println("Course saved successfully.");
    }

    @Override
    public void displayAll() {
        if (courseList.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course course : courseList) {
            System.out.println("Course ID: " + course.getcourseID());
            System.out.println("Course Name: " + course.getcourseName());
            System.out.println("Program: " + course.getProgram());
            System.out.println();
        }
    }

    @Override
    public void updateCourse() {
        System.out.println("Update course functionality to be implemented.");
    }

    @Override
    public void removeCourse() {
        System.out.println("Remove course functionality to be implemented.");
    }

    @Override
    public Course getCourseById(String courseId) {
        for (Course course : courseList) {
            if (course.getcourseID() != null && course.getcourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return courseList;
    }
}
