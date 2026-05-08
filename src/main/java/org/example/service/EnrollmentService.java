package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

public interface EnrollmentService {

    void enrollCourse(Student student, Course course);

    void enrollCoursesBySpecialNumber(int studentSpecialNumber, int[] courseIndexes);

    void enrollCoursesByStudentId(int studentId, int[] courseIndexes);

    void displayStudentCourses(Student student);
}