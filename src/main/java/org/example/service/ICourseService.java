package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

public interface ICourseService {
    void save(Course course);

    void displayAll();

    void updateCourse();

    void removeCourse();

    Course getCourseById(String courseId);

    ArrayList<Course> getAllCourses();
}