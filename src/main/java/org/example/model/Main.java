package org.example.model;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
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

            System.out.println("\n1 - Register | 2 - Read | 3 - Update | 4 - Delete | 5 - Exit");
            System.out.print("What to do?: ");
            choice = scan.nextInt();

            switch (choice) {

                //create
                case 1:
                    System.out.println("\n1 - Student | 2 - Course");
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

                        Student p = new Student();
                        p.setStudID(sID);
                        p.setStudName(sName);
                        p.setStudProgram(sProgram);
                        studentRegistration.addStudent(p);
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
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;

                // read
                case 2:
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

                // update
                case 3:
                    System.out.println("\n1 - Student | 2 - Course");
                    System.out.print("What do you want to update?: ");
                    ch = scan.nextInt();
                    if (ch == 1){
                        studentRegistration.updateStudent();
                    } else if (ch == 2) {
                        courseRegistration.updateCourse();
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;

                // delete
                case 4:
                    System.out.println("\n1 - Student | 2 - Course");
                    System.out.print("What do you want to remove?: ");
                    ch = scan.nextInt();
                    if (ch == 1){
                        studentRegistration.removeStudent();
                    } else if (ch == 2) {
                        courseRegistration.removeCourse();
                    } else {
                        System.out.println("Invalid input. Try again.");
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