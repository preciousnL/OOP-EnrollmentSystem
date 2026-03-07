package org.example.model;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
import org.example.service.TuitionFeePayment;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();
        Scanner scan = new Scanner(System.in);

        while (true){
            String sName;
            String sProgram;
            String cCode;
            String cName;
            String cProgram;
            int sID;
            int choice;
            int ch;
            String ans;

            System.out.println("\n1 - Register | 2 - Read | 3 - Update | 4 - Delete | 5 - Exit");
            System.out.print("What to do?: ");
            choice = scan.nextInt();

            switch (choice) {

                //create
                case 1:
                    System.out.println("\n1 - Student | 2 - Course ");
                    System.out.print("What do you want to register?: ");
                    ch = scan.nextInt();

                    if (ch == 1){
                        scan.nextLine();
                        System.out.print("\nStudent ID: ");
                        sID = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Student Name: ");
                        sName = scan.nextLine();
                        System.out.print("Student Program: ");
                        sProgram = scan.nextLine();

                        Student p = new Student(sID, sName);
                        p.setId(sID);
                        p.setName(sName);
                        p.setStudProgram(sProgram);
                        studentRegistration.addStudent(p);

//                        while (true) {
//                            System.out.print("Proceed to Tuition Fee Calculator? (Yes/ No): ");
//                            ans = scan.nextLine();
//                            if (ans.equalsIgnoreCase("yes")) {
//                                TuitionFeePayment t = new TuitionFeePayment();
//
//                            } else if (ans.equalsIgnoreCase("no")) {
//                                return;
//                            } else {
//                                System.out.println("\nInvalid input. Please type 'Yes or No' only.");
//                            }
//                        }
                    } else if (ch == 2){
                        scan.nextLine();
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
                    } else if (ch == 3){
                        break;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;

                // read
                case 2:
                    while (true){
                        System.out.println("\n1 - Student | 2 - Course");
                        System.out.print("What do you want to read?: ");
                        ch = scan.nextInt();
                        if (ch == 1){
                            studentRegistration.displayAll();
                        } else if (ch == 2) {
                            courseRegistration.displayAll();
                        } else {
                            System.out.println("Invalid input. Try again.");
                        }
                        break;
                    }
                    break;

                    // update
                case 3:
                    while (true){
                        System.out.println("\n1 - Student | 2 - Course");
                        System.out.print("What do you want to update?: ");
                        ch = scan.nextInt();
                        if (ch == 1) {
                            studentRegistration.updateStudent();
                        } else if (ch == 2) {
                            courseRegistration.updateCourse();
                        } else {
                            System.out.println("Invalid input. Try again.");
                        }
                        break;
                    }
                    break;

                // delete
                case 4:
                    while (true){
                        System.out.println("\n1 - Student | 2 - Course");
                        System.out.print("What do you want to remove?: ");
                        ch = scan.nextInt();
                        if (ch == 1) {
                            studentRegistration.removeStudent();
                        } else if (ch == 2) {
                            courseRegistration.removeCourse();
                        } else {
                            System.out.println("Invalid input. Try again.");
                        }
                        break;
                    }
                    break;

                // exit
                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input. Try again.");
                    return;

            }
        }

    }
}