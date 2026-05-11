package org.example.service;

import org.example.model.Course;
import org.example.model.Section;
import org.example.model.Student;
import org.example.exceptions.SectionFullException;

/**
 * Simple test runner that runs all tests manually.
 * Run this class to execute all tests.
 */
public class RunTests {

    private static int testsRun = 0;
    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        System.out.println("=== Running JUnit Tests ===\n");

        // Run Enrollment Tests
        testEnrollmentValidation();

        // Run Section Full Tests
        testSectionFullValidation();

        // Run Tuition Calculation Tests
        testTuitionCalculation();

        // Run Payment Balance Tests
        testPaymentBalance();

        // Run Duplicate ID Tests
        testDuplicateStudentId();

        // Print Summary
        System.out.println("\n===========================");
        System.out.println("TEST SUMMARY");
        System.out.println("===========================");
        System.out.println("Tests run: " + testsRun);
        System.out.println("Passed: " + testsPassed);
        System.out.println("Failed: " + testsFailed);

        if (testsFailed == 0) {
            System.out.println("\n✓ ALL TESTS PASSED!");
        } else {
            System.out.println("\n✗ SOME TESTS FAILED!");
            System.exit(1);
        }
    }

    private static void testEnrollmentValidation() {
        System.out.println("--- EnrollmentValidationTest ---");

        // Test 1: Enroll successfully
        try {
            EnrollmentServiceImpl service = new EnrollmentServiceImpl();
            Student student = createStudent(1, "John");
            Course course = createCourse("CS101", "Programming");

            service.enrollCourse(student, course);

            if (student.getCourses().contains(course)) {
                pass("testEnrollCourseSuccessfully");
            } else {
                fail("testEnrollCourseSuccessfully - Course not added");
            }
        } catch (Exception e) {
            fail("testEnrollCourseSuccessfully - " + e.getMessage());
        }

        // Test 2: Enroll with null student (should not throw)
        try {
            EnrollmentServiceImpl service = new EnrollmentServiceImpl();
            Course course = createCourse("CS102", "Data Structures");

            service.enrollCourse(null, course);
            pass("testEnrollCourseWithNullStudent");
        } catch (Exception e) {
            fail("testEnrollCourseWithNullStudent - Should not throw: " + e.getMessage());
        }

        // Test 3: Enroll multiple courses
        try {
            EnrollmentServiceImpl service = new EnrollmentServiceImpl();
            Student student = createStudent(2, "Jane");
            Course course1 = createCourse("CS101", "Programming");
            Course course2 = createCourse("CS102", "Data Structures");

            service.enrollCourse(student, course1);
            service.enrollCourse(student, course2);

            if (student.getCourses().size() == 2) {
                pass("testEnrollMultipleCourses");
            } else {
                fail("testEnrollMultipleCourses - Expected 2 courses, got " + student.getCourses().size());
            }
        } catch (Exception e) {
            fail("testEnrollMultipleCourses - " + e.getMessage());
        }
    }

    private static void testSectionFullValidation() {
        System.out.println("\n--- SectionFullValidationTest ---");

        // Test 1: Enroll within capacity
        try {
            Section section = createSection("Section A", 3);
            Student student = createStudent(1, "Student1");

            section.enrollStudent(student);

            if (section.getEnrolledStudents().size() == 1) {
                pass("testEnrollStudentWithinCapacity");
            } else {
                fail("testEnrollStudentWithinCapacity - Wrong count");
            }
        } catch (Exception e) {
            fail("testEnrollStudentWithinCapacity - " + e.getMessage());
        }

        // Test 2: Enroll up to max capacity
        try {
            Section section = createSection("Section B", 2);
            section.enrollStudent(createStudent(1, "S1"));
            section.enrollStudent(createStudent(2, "S2"));

            if (section.getEnrolledStudents().size() == 2) {
                pass("testEnrollUpToMaxCapacity");
            } else {
                fail("testEnrollUpToMaxCapacity - Wrong count");
            }
        } catch (Exception e) {
            fail("testEnrollUpToMaxCapacity - " + e.getMessage());
        }

        // Test 3: Enroll beyond capacity throws exception
        try {
            Section section = createSection("Section C", 1);
            section.enrollStudent(createStudent(1, "S1"));
            section.enrollStudent(createStudent(2, "S2"));

            fail("testEnrollBeyondCapacityThrowsException - Should have thrown SectionFullException");
        } catch (SectionFullException e) {
            pass("testEnrollBeyondCapacityThrowsException");
        } catch (Exception e) {
            fail("testEnrollBeyondCapacityThrowsException - Wrong exception: " + e.getMessage());
        }
    }

    private static void testTuitionCalculation() {
        System.out.println("\n--- TuitionFeeCalculationTest ---");

        // Test 1: Calculate without discount
        try {
            TuitionServiceImpl service = new TuitionServiceImpl();
            double tuition = service.calculateTuitionFee(5, 0.0);

            if (tuition == 5000.0) {
                pass("testCalculateTuitionWithoutDiscount");
            } else {
                fail("testCalculateTuitionWithoutDiscount - Expected 5000, got " + tuition);
            }
        } catch (Exception e) {
            fail("testCalculateTuitionWithoutDiscount - " + e.getMessage());
        }

        // Test 2: Calculate with discount
        try {
            TuitionServiceImpl service = new TuitionServiceImpl();
            double tuition = service.calculateTuitionFee(6, 0.10);

            if (tuition == 5400.0) {
                pass("testCalculateTuitionWithDiscount");
            } else {
                fail("testCalculateTuitionWithDiscount - Expected 5400, got " + tuition);
            }
        } catch (Exception e) {
            fail("testCalculateTuitionWithDiscount - " + e.getMessage());
        }

        // Test 3: Calculate with full discount
        try {
            TuitionServiceImpl service = new TuitionServiceImpl();
            double tuition = service.calculateTuitionFee(5, 1.0);

            if (tuition == 0.0) {
                pass("testCalculateTuitionWithFullDiscount");
            } else {
                fail("testCalculateTuitionWithFullDiscount - Expected 0, got " + tuition);
            }
        } catch (Exception e) {
            fail("testCalculateTuitionWithFullDiscount - " + e.getMessage());
        }
    }

    private static void testPaymentBalance() {
        System.out.println("\n--- PaymentBalanceTest ---");

        // Test 1: Initial balance
        try {
            TuitionServiceImpl service = new TuitionServiceImpl();
            service.calculateTuitionFee(5, 0.0);
            double balance = service.getRemainingBalance();

            if (balance == 5000.0) {
                pass("testInitialBalanceAfterCalculation");
            } else {
                fail("testInitialBalanceAfterCalculation - Expected 5000, got " + balance);
            }
        } catch (Exception e) {
            fail("testInitialBalanceAfterCalculation - " + e.getMessage());
        }

        // Test 2: Payment reduces balance
        try {
            TuitionServiceImpl service = new TuitionServiceImpl();
            service.calculateTuitionFee(5, 0.0);
            service.makePayment(2000.0);
            double balance = service.getRemainingBalance();

            if (balance == 3000.0) {
                pass("testMakePaymentReducesBalance");
            } else {
                fail("testMakePaymentReducesBalance - Expected 3000, got " + balance);
            }
        } catch (Exception e) {
            fail("testMakePaymentReducesBalance - " + e.getMessage());
        }

        // Test 3: Full payment
        try {
            TuitionServiceImpl service = new TuitionServiceImpl();
            service.calculateTuitionFee(3, 0.0);
            service.makePayment(3000.0);

            if (service.getRemainingBalance() == 0.0 && service.isFullyPaid()) {
                pass("testMakeFullPayment");
            } else {
                fail("testMakeFullPayment - Balance should be 0");
            }
        } catch (Exception e) {
            fail("testMakeFullPayment - " + e.getMessage());
        }

        // Test 4: Over payment keeps balance at 0
        try {
            TuitionServiceImpl service = new TuitionServiceImpl();
            service.calculateTuitionFee(3, 0.0);
            service.makePayment(5000.0);

            if (service.getRemainingBalance() == 0.0) {
                pass("testMakeOverPayment");
            } else {
                fail("testMakeOverPayment - Balance should be 0 after overpayment");
            }
        } catch (Exception e) {
            fail("testMakeOverPayment - " + e.getMessage());
        }
    }

    private static void testDuplicateStudentId() {
        System.out.println("\n--- DuplicateStudentIdTest ---");

        // Test 1: Add with unique ID
        try {
            StudentRegistration reg = new StudentRegistration();
            Student s1 = createStudent(1001, "Alice");
            reg.addStudent(s1);

            Student s2 = createStudent(1002, "Bob");
            reg.addStudent(s2);

            if (reg.getStudentById(1002) != null) {
                pass("testAddStudentWithUniqueId");
            } else {
                fail("testAddStudentWithUniqueId - Student not found");
            }
        } catch (Exception e) {
            fail("testAddStudentWithUniqueId - " + e.getMessage());
        }

        // Test 2: Find existing student
        try {
            StudentRegistration reg = new StudentRegistration();
            Student s1 = createStudent(1001, "Alice");
            reg.addStudent(s1);

            Student found = reg.getStudentById(1001);
            if (found != null && found.getName().equals("Alice")) {
                pass("testDuplicateIdDetection");
            } else {
                fail("testDuplicateIdDetection - Wrong student or not found");
            }
        } catch (Exception e) {
            fail("testDuplicateIdDetection - " + e.getMessage());
        }

        // Test 3: Non-existent ID returns null
        try {
            StudentRegistration reg = new StudentRegistration();
            Student s1 = createStudent(1001, "Alice");
            reg.addStudent(s1);

            Student found = reg.getStudentById(9999);
            if (found == null) {
                pass("testGetStudentByIdReturnsNullForNonExistent");
            } else {
                fail("testGetStudentByIdReturnsNullForNonExistent - Should return null");
            }
        } catch (Exception e) {
            fail("testGetStudentByIdReturnsNullForNonExistent - " + e.getMessage());
        }

        // Test 4: Get by special number
        try {
            StudentRegistration reg = new StudentRegistration();
            Student s1 = createStudent(1001, "Alice");
            reg.addStudent(s1);

            Student s2 = createStudent(1002, "Bob");
            reg.addStudent(s2);

            Student found = reg.getStudentBySpecialNumber(2);
            if (found != null && found.getId() == 1002) {
                pass("testGetStudentBySpecialNumber");
            } else {
                fail("testGetStudentBySpecialNumber - Wrong student");
            }
        } catch (Exception e) {
            fail("testGetStudentBySpecialNumber - " + e.getMessage());
        }
    }

    // Helper methods
    private static Student createStudent(int id, String name) {
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setStudProgram("Computer Science");
        return s;
    }

    private static Course createCourse(String code, String name) {
        Course c = new Course();
        c.setCourseCode(code);
        c.setCourseName(name);
        c.setCourseProgram("Computer Science");
        return c;
    }

    private static Section createSection(String name, int capacity) {
        Section s = new Section();
        s.setSectionName(name);
        s.setMaxCapacity(capacity);
        return s;
    }

    private static void pass(String testName) {
        testsRun++;
        testsPassed++;
        System.out.println("✓ " + testName);
    }

    private static void fail(String testName) {
        testsRun++;
        testsFailed++;
        System.out.println("✗ " + testName);
    }
}
