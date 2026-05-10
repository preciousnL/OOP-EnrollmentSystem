package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

public interface ICourseService {
    void addCourse(Course course);
    void displayCourse();
    void displayAvailableCourses();
    void updateCourse();
    void removeCourse();
    Course getCourseByIndex(int index);
    ArrayList<Course> getAllCourses();
}