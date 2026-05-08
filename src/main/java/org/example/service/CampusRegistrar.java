











package org.example.service;

import org.example.model.Student;

public class CampusRegistrar {
    private StudentRegistration registration;
    private CourseReg courseReg;

    public CampusRegistrar(StudentRegistration registration, CourseReg courseReg){
        this.registration = registration;
        this.courseReg = courseReg;
    }

    public String saveStudent(Student student){
        registration.saveStudent(student);
        return "Success";
    }

    public void displayAllCourses(){
        courseReg.displayAll();
    }
}
