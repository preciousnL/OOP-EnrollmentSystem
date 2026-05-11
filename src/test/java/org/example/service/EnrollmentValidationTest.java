package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for enrollment validation.
 * Tests student enrollment in courses functionality.
 */
public class EnrollmentValidationTest {

    private EnrollmentServiceImpl enrollmentService;
    private Student student;
    private Course course;

    @BeforeEach
    void setUp() {
        enrollmentService = new EnrollmentServiceImpl();

        // Create a test student
        student = new Student();
        student.setId(1);
        student.setName("John Doe");
        student.setStudProgram("Computer Science");

        // Create a test course
        course = new Course();
        course.setCourseCode("CS101");
        course.setCourseName("Introduction to Programming");
        course.setCourseProgram("Computer Science");
    }

    @Test
    void testEnrollCourseSuccessfully() {
        // Test enrolling a student in a course
        enrollmentService.enrollCourse(student, course);

        // Verify enrollment by checking if student has the course
        assertTrue(student.getCourses().contains(course),
            "Student should be enrolled in the course");
    }

    @Test
    void testEnrollCourseWithNullStudent() {
        // Test enrolling with null student - should not throw exception
        assertDoesNotThrow(() -> enrollmentService.enrollCourse(null, course),
            "Enrolling null student should not throw exception");
    }

    @Test
    void testEnrollCourseWithNullCourse() {
        // Test enrolling with null course - should not throw exception
        assertDoesNotThrow(() -> enrollmentService.enrollCourse(student, null),
            "Enrolling in null course should not throw exception");
    }

    @Test
    void testEnrollMultipleCourses() {
        // Create additional courses
        Course course2 = new Course();
        course2.setCourseCode("CS102");
        course2.setCourseName("Data Structures");
        course2.setCourseProgram("Computer Science");

        // Enroll in multiple courses
        enrollmentService.enrollCourse(student, course);
        enrollmentService.enrollCourse(student, course2);

        // Verify both courses are added
        assertEquals(2, student.getCourses().size(),
            "Student should be enrolled in 2 courses");
        assertTrue(student.getCourses().contains(course),
            "Student should have first course");
        assertTrue(student.getCourses().contains(course2),
            "Student should have second course");
    }
}
