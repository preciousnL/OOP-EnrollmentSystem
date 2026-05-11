package org.example.service;

import org.example.model.Section;
import org.example.model.Student;
import org.example.exceptions.SectionFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for section full validation.
 * Tests that sections cannot exceed their maximum capacity.
 */
public class SectionFullValidationTest {

    private Section section;
    private static final int MAX_CAPACITY = 3;

    @BeforeEach
    void setUp() {
        // Create a section with small capacity for testing
        section = new Section();
        section.setSectionName("Section A");
        section.setMaxCapacity(MAX_CAPACITY);
    }

    @Test
    void testEnrollStudentWithinCapacity() {
        // Create and enroll a student
        Student student = new Student();
        student.setId(1);
        student.setName("Student One");

        // Should not throw exception when enrolling within capacity
        assertDoesNotThrow(() -> section.enrollStudent(student),
            "Should allow enrollment within capacity");

        // Verify student is enrolled
        assertEquals(1, section.getEnrolledStudents().size(),
            "Section should have 1 enrolled student");
    }

    @Test
    void testEnrollUpToMaxCapacity() throws SectionFullException {
        // Enroll students up to max capacity
        for (int i = 1; i <= MAX_CAPACITY; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("Student " + i);
            section.enrollStudent(student);
        }

        // Verify section is at full capacity
        assertEquals(MAX_CAPACITY, section.getEnrolledStudents().size(),
            "Section should be at full capacity");
    }

    @Test
    void testEnrollBeyondCapacityThrowsException() throws SectionFullException {
        // Fill section to capacity
        for (int i = 1; i <= MAX_CAPACITY; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("Student " + i);
            section.enrollStudent(student);
        }

        // Try to enroll one more student - should throw SectionFullException
        Student extraStudent = new Student();
        extraStudent.setId(MAX_CAPACITY + 1);
        extraStudent.setName("Extra Student");

        SectionFullException exception = assertThrows(SectionFullException.class,
            () -> section.enrollStudent(extraStudent),
            "Should throw SectionFullException when exceeding capacity");

        // Verify exception message contains section name
        assertTrue(exception.getMessage().contains("Section A"),
            "Exception message should mention section name");
        assertTrue(exception.getMessage().contains("maximum capacity"),
            "Exception message should mention capacity");
    }

    @Test
    void testGetMaxCapacity() {
        // Verify max capacity is correctly set
        assertEquals(MAX_CAPACITY, section.getMaxCapacity(),
            "Max capacity should match the set value");
    }

    @Test
    void testEmptySectionHasZeroEnrolled() {
        // Verify new section has no enrolled students
        assertEquals(0, section.getEnrolledStudents().size(),
            "New section should have 0 enrolled students");
    }
}
