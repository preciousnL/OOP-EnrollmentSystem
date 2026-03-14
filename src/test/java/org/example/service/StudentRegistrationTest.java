package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRegistrationTest {
    private StudentRegistration studentRegistration;

    @BeforeEach
    void setUp() {
        studentRegistration = new StudentRegistration();

    }

    @Test
    void testAddStudentAndGetBySpecialNumber() {

        Student student = new Student(101, "John", "BSIT");
        studentRegistration.addStudent(student);

        Student result = studentRegistration.getStudentBySpecialNumber(1);

        assertNotNull(result);
        assertEquals(101, result.getId());
        assertEquals("John", result.getName());
        assertEquals("BSIT", result.getStudProgram());
    }

    @Test
    void testGetStudentById() {

        Student student1 = new Student(101, "John", "BSIT");
        Student student2 = new Student(102, "Anna", "BSCS");

        studentRegistration.addStudent(student1);
        studentRegistration.addStudent(student2);

        Student result = studentRegistration.getStudentById(102);

        assertNotNull(result);
        assertEquals("Anna", result.getName());
        assertEquals("BSCS", result.getStudProgram());
    }

    @Test
    void testGetStudentByIdReturnsNullIfNotFound() {

        Student result = studentRegistration.getStudentById(999);

        assertNull(result);
    }

    @Test
    void testGetStudentBySpecialNumberReturnsNullIfInvalid() {

        assertNull(studentRegistration.getStudentBySpecialNumber(0));
        assertNull(studentRegistration.getStudentBySpecialNumber(1));
    }
}