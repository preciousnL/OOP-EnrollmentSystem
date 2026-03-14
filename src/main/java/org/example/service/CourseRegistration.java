package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    private ArrayList<Course> courses = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int index;
    static String name;
    static String code;
    static String program;
    static int units;
    static String ans;

    public CourseRegistration() {
        courses.add(new Course("INFASEC2", "Information Assurance and Security 2", "BS Information Technology", 3));
        courses.add(new Course("ITSYSDE", "System Analysis and Design", "BS Information Technology", 3));
        courses.add(new Course("ITPROMA", "Project Management", "BS Information Technology", 3));
        courses.add(new Course("INFOMAN", "Infomation Management", "BS Information Technology", 3));
        courses.add(new Course("ITELECT1", "IT Electives 1", "BS Information Technology", 3));
        courses.add(new Course("LINUSYST", "Linux System and Network Administration", "BS Information Technology", 3));
        courses.add(new Course("PATHFI4", "Physical Activity Towards Health 4", "BS Information Technology", 2));
        courses.add(new Course("INTEPROG", "Integrative Programming", "BS Information Technology", 3));
        courses.add(new Course("DISMATH", "Discrete Math", "BS Information Technology", 3));
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.printf("\nYour special number is %d%n", courses.size());
    }

    public void displayCourse() {
        if (courses.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nDo you want to read all? (Yes/No): ");
        ans = scan.nextLine();

        if (ans.equalsIgnoreCase("yes")) {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println("\n===================================================");
                System.out.println("\nSpecial Number: " + (i + 1));
                System.out.println("Course Code: " + courses.get(i).getCourseCode());
                System.out.println("Course Name: " + courses.get(i).getCourseName());
                System.out.println("Course Program: " + courses.get(i).getCourseProgram());
                System.out.println("Course Unit: " + courses.get(i).getUnits());
                System.out.println("\n===================================================");
            }
        } else if (ans.equalsIgnoreCase("no")) {
            System.out.print("Enter special number: ");
            index = scan.nextInt();
            scan.nextLine();

            if (index - 1 >= 0 && index - 1 < courses.size()) {
                System.out.println("\n===================================================");
                System.out.println("\nCourse Code: " + courses.get(index - 1).getCourseCode());
                System.out.println("Course Name: " + courses.get(index - 1).getCourseName());
                System.out.println("Course Program: " + courses.get(index - 1).getCourseProgram());
                System.out.println("Course Unit: " + courses.get(index - 1).getUnits());
                System.out.println("\n===================================================");
            } else {
                System.out.println("\n===================================================");
                System.out.println("Invalid input. Try again.");
            }
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    public void displayAvailableCourses() {
        if (courses.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo available courses.");
            return;
        }

        System.out.println("\nAVAILABLE COURSES");
        System.out.printf("%-3s %-12s %-45s %-10s%n","No","Code","Course Name","Units");
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            System.out.printf("%-3d %-12s %-45s %-10s%n",
                    i + 1,
                    c.getCourseCode(),
                    c.getCourseName(),
                    c.getUnits());
        }
    }

    public void updateCourse() {
        if (courses.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < courses.size()) {
            System.out.print("\nCourse Code: ");
            code = scan.nextLine();

            System.out.print("Course Name: ");
            name = scan.nextLine();

            System.out.print("Course Program: ");
            program = scan.nextLine();

            System.out.print("Course Unit: ");
            units = scan.nextInt();

            courses.get(index - 1).setCourseCode(code);
            courses.get(index - 1).setCourseName(name);
            courses.get(index - 1).setCourseProgram(program);
            courses.get(index - 1).setUnits(units);

            System.out.println("\n===================================================");
            System.out.println("Update Successful!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    public void removeCourse() {
        if (courses.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < courses.size()) {
            courses.remove(index - 1);
            System.out.println("\n===================================================");
            System.out.println("Remove Successful!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    public Course getCourseByIndex(int index) {
        if (index - 1 >= 0 && index - 1 < courses.size()) {
            return courses.get(index - 1);
        }
        return null;
    }


}