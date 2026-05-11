package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentServiceImpl implements IEnrollmentService {

    private IStudentService studentService;
    private ICourseService courseService;
    private Map<Integer, List<Course>> studentEnrollments = new HashMap<>();

    public EnrollmentServiceImpl() {
    }

    public EnrollmentServiceImpl(IStudentService studentService, ICourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public void enrollCourse(Student student, Course course) {
        if (student != null && course != null) {
            studentEnrollments.putIfAbsent(student.getId(), new ArrayList<>());
            studentEnrollments.get(student.getId()).add(course);
            System.out.println("Successfully enrolled " + student.getName() + " in " + course.getCourseName());
        } else {
            System.out.println("Enrollment failed. Invalid student or course.");
        }
    }

    @Override
    public void enrollCoursesByStudentId(int studentId, int[] courseIds) {
        if (studentService != null && courseService != null) {
            Student student = studentService.getStudentById(studentId);
            if (student != null) {
                for (int courseIndex : courseIds) {
                    Course course = courseService.getCourseByIndex(courseIndex);
                    if (course != null) {
                        enrollCourse(student, course);
                    } else {
                        System.out.println("Course with index " + courseIndex + " not found.");
                    }
                }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Student/Course services not initialized.");
        }
    }

    @Override
    public void displayStudentCourses(Student student) {
        if (student != null) {
            System.out.println("\nCourses for " + student.getName() + ":");
            List<Course> enrolledCourses = studentEnrollments.get(student.getId());
            if (enrolledCourses == null || enrolledCourses.isEmpty()) {
                System.out.println("No courses enrolled.");
            } else {
                for (Course course : enrolledCourses) {
                    System.out.println("- " + course.getCourseCode() + ": " + course.getCourseName());
                }
            }
        }
    }
}
