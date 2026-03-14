package org.example.service;

import org.example.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseRegistrationTest {
    private CourseRegistration courseRegistration;

    @BeforeEach
    void setUp(){
        courseRegistration = new CourseRegistration();
    }

    @Test
    void testDefaultCoursesExist() {
        Course firstCourse = courseRegistration.getCourseByIndex(1);

        assertNotNull(firstCourse);
        assertEquals("INFASEC2", firstCourse.getCourseCode());
        assertEquals("Information Assurance and Security 2", firstCourse.getCourseName());
        assertEquals("BS Information Technology", firstCourse.getCourseProgram());
        assertEquals(3, firstCourse.getUnits());
    }

    @Test
    void testAddCourse() {
        CourseRegistration courseRegistration = new CourseRegistration();

        Course newCourse = new Course("OOPJAVA", "Object Oriented Programming", "BS Information Technology", 3);
        courseRegistration.addCourse(newCourse);

        Course result = courseRegistration.getCourseByIndex(10);

        assertNotNull(result);
        assertEquals("OOPJAVA", result.getCourseCode());
        assertEquals("Object Oriented Programming", result.getCourseName());
        assertEquals("BS Information Technology", result.getCourseProgram());
        assertEquals(3, result.getUnits());
    }

    @Test
    void testGetCourseByIndexReturnsNullIfInvalid() {
        CourseRegistration courseRegistration = new CourseRegistration();

        assertNull(courseRegistration.getCourseByIndex(0));
        assertNull(courseRegistration.getCourseByIndex(100));
    }
}