package org.example.service;

import org.example.model.Student;

public class CampusRegistrar {
    private StudentRegistration registration;
    private CourseRegistration courseRegistration;

    public CampusRegistrar(StudentRegistration registration, CourseRegistration courseRegistration) {
        this.registration = registration;
        this.courseRegistration = courseRegistration;
    }

    public void saveStudent(Student student) {
        registration.saveStudent(student);
    }

    public void displayAllCourses() {
        courseRegistration.displayAll();
    }
}
