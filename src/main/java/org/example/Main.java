package org.example;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
import org.example.service.TuitionFeePayment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();
        TuitionFeePayment tuitionFeePayment = new TuitionFeePayment();
        Scanner scan = new Scanner(System.in);

        while (true) {
            String sName;
            String sProgram;
            String cCode;
            String cName;
            String cProgram;
            int sID;
            int choice;
            int ch;
            String ans;

            System.out.println("Welcome to Enrollment System!");
            System.out.println("1 - Student");
            System.out.println("2 - Instructor");
            System.out.print("Enter your type of entry: ");
            int type = scan.nextInt();

            if (type == 1) {
                Student s = new Student();
                s.mainTask();
            } else if (type == 2){
                Instructor i = new Instructor();
                i.mainTask();
            } else {
                System.out.println("\nInvalid input. Please type Yes or No only.");
            }

            while (true){
                System.out.println("\n========= Enrollment System =========");
                System.out.println("\n1 - Register");
                System.out.println("2 - Read");
                System.out.println("3 - Update");
                System.out.println("4 - Delete");
                System.out.println("5 - Enroll Course");
                System.out.println("6 - Pay Tuition");
                System.out.println("7 - Exit");
                System.out.println("\n=====================================");
                System.out.print("\nWhat to do?: ");
                choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        while (true) {
                            System.out.println("\n============ REGISTRATION ============");
                            System.out.println("1 - Student");
                            System.out.println("2 - Course");
                            System.out.println("3 - Back to Home");
                            System.out.println("======================================");
                            System.out.print("\nWhat do you want to register?: ");
                            ch = scan.nextInt();
                            scan.nextLine();

                            if (ch == 1) {
                                Student s = new Student();
                                s.mainTask();

                                System.out.print("\nStudent ID: ");
                                sID = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Student Name: ");
                                sName = scan.nextLine();

                                System.out.print("Student Program: ");
                                sProgram = scan.nextLine();

                                Student p = new Student(sID, sName, sProgram);
                                p.setStudProgram(sProgram);
                                studentRegistration.addStudent(p);

                                System.out.println("\n==================================================");
                                System.out.print("\nContinue to course registration? (Yes/No): ");
                                ans = scan.nextLine();

                                if (ans.equalsIgnoreCase("yes")) {
                                    courseRegistration.displayAvailableCourses();

                                    System.out.println("\n=================================================");
                                    System.out.print("How many courses do you want to register?: ");
                                    int numberOfCourses = scan.nextInt();
                                    scan.nextLine();

                                    for (int i = 0; i < numberOfCourses; i++) {
                                        System.out.println("\nChoose Course " + (i + 1));
                                        System.out.print("Enter course number: ");
                                        int index = scan.nextInt();
                                        scan.nextLine();

                                        Course selectedCourse = courseRegistration.getCourseByIndex(index);

                                        if (selectedCourse == null) {
                                            System.out.println("Invalid course number.");
                                            i--;
                                        } else if (p.getCourses().contains(selectedCourse)) {
                                            System.out.println("Course already added.");
                                            i--;
                                        } else {
                                            p.enrollCourse(selectedCourse);
                                            System.out.println("Course added successfully.");
                                        }

                                        System.out.println("Student Enrolled Courses:");
                                        if (p.getCourses().isEmpty()) {
                                            System.out.println("No enrolled subject.");
                                        } else {
                                            for (Course course : p.getCourses()) {
                                                System.out.println("\n    - " + course.getCourseCode() + " : " + course.getCourseName());
                                            }
                                        }
                                    }

                                    while (true) {
                                        System.out.print("\nContinue to Payment Process? (Yes/No): ");
                                        ans = scan.nextLine();

                                        if (ans.equalsIgnoreCase("yes")) {
                                            do {
                                                System.out.println("\n================ PAYMENT ================");
                                                System.out.println("1 - Calculate Total Tuition Fee");
                                                System.out.println("2 - Make Payment");
                                                System.out.println("3 - Check Balance");
                                                System.out.println("4 - Check if Fully Paid");
                                                System.out.println("5 - Back");
                                                System.out.print("\nWhat do you want to do?: ");
                                                ch = scan.nextInt();
                                                scan.nextLine();

                                                switch (ch) {
                                                    case 1:
                                                        int totalUnits = 0;

                                                        for (Course c : p.getCourses()) {
                                                            totalUnits += c.getUnits();
                                                        }

                                                        if (ans.equalsIgnoreCase("yes")) {
                                                            System.out.println("========== Scholarship Discount ==========");
                                                            System.out.println("Full Scholarship: 1.0 - 100%");
                                                            System.out.println("Special Scholarship: 0.75 - 75%");
                                                            System.out.println("Half Scholarship: 0.50 - 50%");
                                                            System.out.println("==========================================");
                                                            System.out.print("\nEnter discount rate: ");
                                                            double discountRate = scan.nextDouble();
                                                            scan.nextLine();

                                                            double total = tuitionFeePayment.calculateTuitionFee(totalUnits, discountRate);
                                                            System.out.println(tuitionFeePayment.displayTuitionFee(total));

                                                        } else if (ans.equalsIgnoreCase("no")) {
                                                            double total = tuitionFeePayment.calculateTuitionFee(totalUnits, 0);
                                                            System.out.println(tuitionFeePayment.displayTuitionFee(total));
                                                        } else {
                                                            System.out.println("\nInvalid input. Please type Yes or No only.");
                                                        }
                                                        break;

                                                    case 2:
                                                        System.out.print("\nEnter payment amount: ");
                                                        double payment = scan.nextDouble();
                                                        scan.nextLine();

                                                        tuitionFeePayment.makePayment(payment);
                                                        System.out.println("\n==========================================");
                                                        System.out.println("Payment successful.");

                                                        if (tuitionFeePayment.getRemainingBalance() != 0) {
                                                            System.out.println("\nRemaining Balance: " + tuitionFeePayment.getRemainingBalance());
                                                        } else {
                                                            System.out.println("\nStudent is fully paid.");
                                                        }
                                                        System.out.println("==========================================");
                                                        break;

                                                    case 3:
                                                        if (tuitionFeePayment.getRemainingBalance() == 0) {
                                                            System.out.println("No generated balance yet. Please check your Total Tuition Fee first.");
                                                        } else {
                                                            System.out.println("\n==========================================");
                                                            System.out.println("Remaining Balance: " + tuitionFeePayment.getRemainingBalance());
                                                            System.out.println("==========================================");
                                                        }
                                                        break;

                                                    case 4:
                                                        if (tuitionFeePayment.isFullyPaid()) {
                                                            System.out.println("\n==========================================");
                                                            System.out.println("Student is fully paid.");
                                                            System.out.println("==========================================");
                                                        } else {
                                                            System.out.println("\n==========================================");
                                                            System.out.println("Student still has balance.");
                                                            System.out.println("==========================================");
                                                        }
                                                        break;

                                                    case 5:
                                                        break;

                                                    default:
                                                        System.out.println("Invalid input. Try again.");
                                                }

                                            } while (ch != 5);
                                        } else if (ans.equalsIgnoreCase("no")) {
                                            break;
                                        } else {
                                            System.out.println("\nInvalid input. Please type Yes or No only.");
                                        }
                                    }
                                }

                            } else if (ch == 2) {
                                System.out.print("\nCourse Code: ");
                                cCode = scan.nextLine();

                                System.out.print("Course Name: ");
                                cName = scan.nextLine();

                                System.out.print("Course Program: ");
                                cProgram = scan.nextLine();

                                Course c = new Course();
                                c.setCourseCode(cCode);
                                c.setCourseName(cName);
                                c.setCourseProgram(cProgram);
                                courseRegistration.addCourse(c);

                            } else if (ch == 3) {
                                break;
                            } else {
                                System.out.println("Invalid input. Try again.");
                            }
                        }
                        break;

                    case 2:
                        while (true) {
                            System.out.println("\n============== DISPLAY ===============");
                            System.out.println("1 - Student");
                            System.out.println("2 - Course");
                            System.out.println("3 - Back to Home");
                            System.out.println("======================================");
                            System.out.print("\nWhat do you want to check?: ");
                            ch = scan.nextInt();
                            scan.nextLine();

                            if (ch == 1) {
                                studentRegistration.displayStudent();
                            } else if (ch == 2) {
                                while (true) {
                                    System.out.println("\n============== COURSES ===============");
                                    System.out.println("\n1 - Available Courses");
                                    System.out.println("2 - Registered Courses");
                                    System.out.println("3 - Back");
                                    System.out.println("\n=======================================");
                                    System.out.println("\nWhat do you want to check?: ");
                                    ch = scan.nextInt();

                                    if (ch == 1) {
                                        courseRegistration.displayCourse();
                                    } else if (ch == 2) {
                                        courseRegistration.displayAvailableCourses();
                                    } else if (ch == 3) {
                                        break;
                                    } else {
                                        System.out.println("\n=======================================");
                                        System.out.println("\nInvalid input. Try again.");
                                    }
                                }
                            } else if (ch == 3) {
                                break;
                            } else {
                                System.out.println("\n=======================================");
                                System.out.println("\nInvalid input. Try again.");
                            }
                        }
                        break;

                    case 3:
                        while (true) {
                            System.out.println("\n=============== UPDATE ===============");
                            System.out.println("1 - Student");
                            System.out.println("2 - Course");
                            System.out.println("3 - Back to Home");
                            System.out.println("======================================");
                            System.out.print("\nWhat do you want to update?: ");
                            ch = scan.nextInt();
                            scan.nextLine();

                            if (ch == 1) {
                                studentRegistration.updateStudent();
                            } else if (ch == 2) {
                                courseRegistration.updateCourse();
                            } else if (ch == 3) {
                                break;
                            } else {
                                System.out.println("Invalid input. Try again.");
                            }
                        }
                        break;

                    case 4:
                        while (true) {
                            System.out.println("\n=============== REMOVE ===============");
                            System.out.println("1 - Student");
                            System.out.println("2 - Course");
                            System.out.println("3 - Back to Home");
                            System.out.println("======================================");
                            System.out.print("\nWhat do you want to remove?: ");
                            ch = scan.nextInt();
                            scan.nextLine();

                            if (ch == 1) {
                                studentRegistration.removeStudent();
                            } else if (ch == 2) {
                                courseRegistration.removeCourse();
                            } else if (ch == 3) {
                                break;
                            } else {
                                System.out.println("Invalid input. Try again.");
                            }
                        }
                        break;

                    case 5:
                        while (true) {
                            System.out.println("\n============= ENROLL COURSE =============");
                            System.out.println("1 - Enroll using Student Special Number");
                            System.out.println("2 - Enroll using Student ID");
                            System.out.println("3 - Back to Home");
                            System.out.println("=========================================");
                            System.out.print("\nWhat do you want to do?: ");
                            ch = scan.nextInt();
                            scan.nextLine();

                            if (ch == 1) {
                                if (studentRegistration == null) {
                                    System.out.println("Student registration is not available.");
                                    break;
                                }

                                System.out.print("\nEnter student special number: ");
                                int studentSpecialNumber = scan.nextInt();
                                scan.nextLine();

                                Student student = studentRegistration.getStudentBySpecialNumber(studentSpecialNumber);

                                if (student == null) {
                                    System.out.println("Student not found.");
                                    break;
                                }

                                System.out.println("\nStudent Found:");
                                System.out.println("ID: " + student.getId());
                                System.out.println("Name: " + student.getName());
                                System.out.println("Program: " + student.getStudProgram());

                                courseRegistration.displayAvailableCourses();

                                System.out.print("\nHow many courses do you want to add?: ");
                                int numberOfCourses = scan.nextInt();
                                scan.nextLine();

                                for (int i = 0; i < numberOfCourses; i++) {
                                    System.out.print("\nEnter course special number: ");
                                    int courseIndex = scan.nextInt();
                                    scan.nextLine();

                                    Course selectedCourse = courseRegistration.getCourseByIndex(courseIndex);

                                    if (selectedCourse == null) {
                                        System.out.println("Invalid course number.");
                                        i--;
                                    } else if (student.getCourses().contains(selectedCourse)) {
                                        System.out.println("Course already enrolled.");
                                        i--;
                                    } else {
                                        student.enrollCourse(selectedCourse);
                                        System.out.println("Course added successfully.");
                                    }
                                }

                            } else if (ch == 2) {
                                System.out.print("\nEnter student ID: ");
                                int studentId = scan.nextInt();
                                scan.nextLine();

                                Student student = studentRegistration.getStudentById(studentId);

                                if (student == null) {
                                    System.out.println("Student not found.");
                                    break;
                                }

                                System.out.println("\nStudent Found:");
                                System.out.println("ID: " + student.getId());
                                System.out.println("Name: " + student.getName());
                                System.out.println("Program: " + student.getStudProgram());

                                courseRegistration.displayAvailableCourses();

                                System.out.print("\nHow many courses do you want to add?: ");
                                int numberOfCourses = scan.nextInt();
                                scan.nextLine();

                                for (int i = 0; i < numberOfCourses; i++) {
                                    System.out.print("\nEnter course special number: ");
                                    int courseIndex = scan.nextInt();
                                    scan.nextLine();

                                    Course selectedCourse = courseRegistration.getCourseByIndex(courseIndex);

                                    if (selectedCourse == null) {
                                        System.out.println("Invalid course number.");
                                        i--;
                                    } else if (student.getCourses().contains(selectedCourse)) {
                                        System.out.println("Course already enrolled.");
                                        i--;
                                    } else {
                                        student.enrollCourse(selectedCourse);
                                        System.out.println("Course added successfully.");
                                    }
                                }

                            } else if (ch == 3) {
                                break;
                            } else {
                                System.out.println("Invalid input. Try again.");
                            }
                        }
                        break;

                    case 6:
                        do {
                            System.out.println("\n================ PAYMENT ================");
                            System.out.println("1 - Calculate Total Tuition Fee");
                            System.out.println("2 - Make Payment");
                            System.out.println("3 - Check Balance");
                            System.out.println("4 - Check if Fully Paid");
                            System.out.println("5 - Back");
                            System.out.println("=========================================");
                            System.out.print("\nWhat do you want to do?: ");
                            ch = scan.nextInt();
                            scan.nextLine();

                            switch (ch) {
                                case 1:
                                    System.out.print("\nEnter special number: ");
                                    int specialNumber = scan.nextInt();
                                    scan.nextLine();

                                    Student student = studentRegistration.getStudentBySpecialNumber(specialNumber);

                                    if (student == null) {
                                        System.out.println("Invalid special number.");
                                        break;
                                    }

                                    if (student.getCourses().isEmpty()) {
                                        System.out.println("No records found.");
                                        break;
                                    }

                                    int totalUnits = 0;

                                    for (Course c : student.getCourses()) {
                                        totalUnits += c.getUnits();
                                    }

                                    System.out.print("\nAre you a scholar? (Yes/No): ");
                                    ans = scan.nextLine();

                                    if (ans.equalsIgnoreCase("yes")) {
                                        System.out.println("========== Scholarship Discount ==========");
                                        System.out.println("Full Scholarship: 1.0 - 100%");
                                        System.out.println("Special Scholarship: 0.75 - 75%");
                                        System.out.println("Half Scholarship: 0.50 - 50%");
                                        System.out.println("==========================================");
                                        System.out.print("\nEnter discount rate: ");
                                        double discountRate = scan.nextDouble();
                                        scan.nextLine();

                                        double total = tuitionFeePayment.calculateTuitionFee(totalUnits, discountRate);
                                        System.out.println(tuitionFeePayment.displayTuitionFee(total));

                                    } else if (ans.equalsIgnoreCase("no")) {
                                        double total = tuitionFeePayment.calculateTuitionFee(totalUnits, 0);
                                        System.out.println(tuitionFeePayment.displayTuitionFee(total));
                                    } else {
                                        System.out.println("\nInvalid input. Please type Yes or No only.");
                                    }
                                    break;

                                case 2:
                                    System.out.print("\nEnter payment amount: ");
                                    double payment = scan.nextDouble();
                                    scan.nextLine();

                                    tuitionFeePayment.makePayment(payment);
                                    System.out.println("\n==========================================");
                                    System.out.println("Payment successful.");

                                    if (tuitionFeePayment.getRemainingBalance() != 0) {
                                        System.out.println("\nRemaining Balance: " + tuitionFeePayment.getRemainingBalance());
                                    } else {
                                        System.out.println("\nStudent is fully paid.");
                                    }
                                    System.out.println("==========================================");
                                    break;

                                case 3:
                                    if (tuitionFeePayment.getRemainingBalance() == 0) {
                                        System.out.println("No generated balance yet. Please check your Total Tuition Fee first.");
                                    } else {
                                        System.out.println("\n==========================================");
                                        System.out.println("Remaining Balance: " + tuitionFeePayment.getRemainingBalance());
                                        System.out.println("==========================================");
                                    }
                                    break;

                                case 4:
                                    if (tuitionFeePayment.isFullyPaid()) {
                                        System.out.println("\n==========================================");
                                        System.out.println("Student is fully paid.");
                                        System.out.println("==========================================");
                                    } else {
                                        System.out.println("\n==========================================");
                                        System.out.println("Student still has balance.");
                                        System.out.println("==========================================");
                                    }
                                    break;

                                case 5:
                                    break;

                                default:
                                    System.out.println("Invalid input. Try again.");
                            }

                        } while (ch != 5);
                        break;

                    case 7:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid input. Try again.");
                    }
            }
        }
    }
}