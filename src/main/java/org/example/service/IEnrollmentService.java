package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

public interface IEnrollmentService {
    void enrollCourse(Student student, Course course);

    void enrollCoursesByStudentId(String studentId, String[] courseIds);

    void displayStudentCourses(Student student);
}