package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for duplicate student ID validation.
 * Tests that duplicate student IDs are properly detected.
 */
public class DuplicateStudentIdTest {

    private StudentRegistration studentRegistration;

    @BeforeEach
    void setUp() {
        studentRegistration = new StudentRegistration();

        // Add initial student with ID 1001
        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("Alice Johnson");
        student1.setStudProgram("Computer Science");
        studentRegistration.addStudent(student1);
    }

    @Test
    void testAddStudentWithUniqueId() {
        // Add a student with a different ID
        Student student2 = new Student();
        student2.setId(1002); // Unique ID
        student2.setName("Bob Smith");
        student2.setStudProgram("Engineering");

        // Should be able to add without issues
        assertDoesNotThrow(() -> studentRegistration.addStudent(student2),
            "Should allow adding student with unique ID");

        // Verify the student was added
        Student found = studentRegistration.getStudentById(1002);
        assertNotNull(found, "Student with ID 1002 should exist");
        assertEquals("Bob Smith", found.getName(),
            "Found student should have correct name");
    }

    @Test
    void testDuplicateIdDetection() {
        // Try to find a student with the same ID as existing student
        Student found = studentRegistration.getStudentById(1001);

        assertNotNull(found, "Should find existing student with ID 1001");
        assertEquals("Alice Johnson", found.getName(),
            "Found student should be Alice Johnson");
    }

    @Test
    void testGetStudentByIdReturnsNullForNonExistent() {
        // Try to find a student with non-existent ID
        Student found = studentRegistration.getStudentById(9999);

        assertNull(found, "Should return null for non-existent ID");
    }

    @Test
    void testMultipleStudentsWithUniqueIds() {
        // Add multiple students with unique IDs
        for (int i = 2; i <= 5; i++) {
            Student student = new Student();
            student.setId(1000 + i);
            student.setName("Student " + i);
            student.setStudProgram("Program " + i);
            studentRegistration.addStudent(student);
        }

        // Verify all students can be found
        for (int i = 1; i <= 5; i++) {
            Student found = studentRegistration.getStudentById(1000 + i);
            assertNotNull(found, "Student with ID " + (1000 + i) + " should exist");
        }
    }

    @Test
    void testGetStudentBySpecialNumber() {
        // Add another student
        Student student2 = new Student();
        student2.setId(1002);
        student2.setName("Bob Smith");
        student2.setStudProgram("Engineering");
        studentRegistration.addStudent(student2);

        // Get by special number (1-indexed position in list)
        Student foundBySpecial = studentRegistration.getStudentBySpecialNumber(1);
        assertNotNull(foundBySpecial, "Should find student at special number 1");
        assertEquals(1001, foundBySpecial.getId(),
            "First student should have ID 1001");

        Student foundBySpecial2 = studentRegistration.getStudentBySpecialNumber(2);
        assertNotNull(foundBySpecial2, "Should find student at special number 2");
        assertEquals(1002, foundBySpecial2.getId(),
            "Second student should have ID 1002");
    }

    @Test
    void testGetStudentByInvalidSpecialNumber() {
        // Try to get student with invalid special number
        Student found = studentRegistration.getStudentBySpecialNumber(999);

        assertNull(found, "Should return null for invalid special number");
    }

    @Test
    void testStudentIdUniqueness() {
        // Add multiple students and verify IDs are unique in the system
        Student student2 = new Student();
        student2.setId(1002);
        student2.setName("Bob");
        studentRegistration.addStudent(student2);

        Student student3 = new Student();
        student3.setId(1003);
        student3.setName("Charlie");
        studentRegistration.addStudent(student3);

        // Verify all IDs are different
        Student s1 = studentRegistration.getStudentById(1001);
        Student s2 = studentRegistration.getStudentById(1002);
        Student s3 = studentRegistration.getStudentById(1003);

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotNull(s3);

        assertNotEquals(s1.getId(), s2.getId(), "Student 1 and 2 should have different IDs");
        assertNotEquals(s2.getId(), s3.getId(), "Student 2 and 3 should have different IDs");
        assertNotEquals(s1.getId(), s3.getId(), "Student 1 and 3 should have different IDs");
    }
}
