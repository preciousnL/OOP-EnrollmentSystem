package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

/**
 * Delegates all logic to CourseServiceImpl.
 * Kept for backward compatibility with Main.java.
 */
public class CourseRegistration implements ICourseService {

    private final CourseServiceImpl impl = new CourseServiceImpl();

    @Override
    public void addCourse(Course course) {
        impl.addCourse(course);
    }

    @Override
    public void displayCourse() {
        impl.displayCourse();
    }

    @Override
    public void displayAvailableCourses() {
        impl.displayAvailableCourses();
    }

    @Override
    public void updateCourse() {
        impl.updateCourse();
    }

    @Override
    public void removeCourse() {
        impl.removeCourse();
    }

    @Override
    public Course getCourseByIndex(int index) {
        return impl.getCourseByIndex(index);
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return impl.getAllCourses();
    }
}