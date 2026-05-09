package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration implements ICourseService {
    private ArrayList<Course> courses = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int index;
    static String name;
    static String courseId;
    static String program;
    static String ans;

    public CourseRegistration() {
        courses.add(new Course("INFASEC2", "Information Assurance and Security 2", "BS Information Technology"));
        courses.add(new Course("ITSYSDE", "System Analysis and Design", "BS Information Technology"));
        courses.add(new Course("ITPROMA", "Project Management", "BS Information Technology"));
        courses.add(new Course("INFOMAN", "Information Management", "BS Information Technology"));
        courses.add(new Course("ITELECT1", "IT Electives 1", "BS Information Technology"));
        courses.add(new Course("LINUSYST", "Linux System and Network Administration", "BS Information Technology"));
        courses.add(new Course("PATHFI4", "Physical Activity Towards Health 4", "BS Information Technology"));
        courses.add(new Course("INTEPROG", "Integrative Programming", "BS Information Technology"));
        courses.add(new Course("DISMATH", "Discrete Math", "BS Information Technology"));
    }

    @Override
    public void save(Course course) {
        courses.add(course);
        System.out.printf("%nYour special number is %d%n", courses.size());
    }

    @Override
    public void displayAll() {
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
                System.out.println("Course ID: " + courses.get(i).getcourseID());
                System.out.println("Course Name: " + courses.get(i).getcourseName());
                System.out.println("Program: " + courses.get(i).getProgram());
                System.out.println("\n===================================================");
            }
        } else if (ans.equalsIgnoreCase("no")) {
            System.out.print("Enter special number: ");
            index = Integer.parseInt(scan.nextLine());

            if (index - 1 >= 0 && index - 1 < courses.size()) {
                System.out.println("\n===================================================");
                System.out.println("\nCourse ID: " + courses.get(index - 1).getcourseID());
                System.out.println("Course Name: " + courses.get(index - 1).getcourseName());
                System.out.println("Program: " + courses.get(index - 1).getProgram());
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

    @Override
    public void updateCourse() {
        if (courses.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = Integer.parseInt(scan.nextLine());

        if (index - 1 >= 0 && index - 1 < courses.size()) {
            System.out.print("\nCourse ID: ");
            courseId = scan.nextLine();

            System.out.print("Course Name: ");
            name = scan.nextLine();

            System.out.print("Program: ");
            program = scan.nextLine();

            courses.get(index - 1).setCourseID(courseId);
            courses.get(index - 1).setCourseName(name);
            courses.get(index - 1).setProgram(program);

            System.out.println("\n===================================================");
            System.out.println("Update Successful!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public void removeCourse() {
        if (courses.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = Integer.parseInt(scan.nextLine());

        if (index - 1 >= 0 && index - 1 < courses.size()) {
            courses.remove(index - 1);
            System.out.println("\n===================================================");
            System.out.println("Remove Successful!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getcourseID() != null && course.getcourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return courses;
    }
}