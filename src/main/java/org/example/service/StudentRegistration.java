package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    private ArrayList<Student> students = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int index;
    static String name;
    static int id;
    static String program;
    static String ans;

    public void addStudent(Student student) {
        students.add(student);
        System.out.printf("\nYour special number is %d%n", students.size());
    }

    public void displayStudent() {
        if (students.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nDo you want to read all? (Yes/No): ");
        ans = scan.nextLine();

        if (ans.equalsIgnoreCase("yes")) {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("\n===================================================");
                System.out.println("\nSpecial Number: " + (i + 1));
                System.out.println("Student ID: " + students.get(i).getId());
                System.out.println("Student Name: " + students.get(i).getName());
                System.out.println("Program: " + students.get(i).getStudProgram());

                System.out.println("\nStudent Enrolled Courses:");
                if (students.get(i).getCourses().isEmpty()) {
                    System.out.println("No enrolled subject.");
                    System.out.println("\n===================================================");

                } else {
                    for (Course course : students.get(i).getCourses()) {
                        System.out.println("        - " + course.getCourseCode() + " : " + course.getCourseName());
                        System.out.println("\n===================================================");

                    }
                }
            }
        } else if (ans.equalsIgnoreCase("no")) {
            System.out.print("\nEnter special number: ");
            index = scan.nextInt();
            scan.nextLine();

            if (index - 1 >= 0 && index - 1 < students.size()) {
                Student student = students.get(index - 1);

                System.out.println("\n===================================================");
                System.out.println("\nStudent ID: " + student.getId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Program: " + student.getStudProgram());

                System.out.println("\nStudent Enrolled Courses:");
                if (student.getCourses().isEmpty()) {
                    System.out.println("None");
                    System.out.println("\n===================================================");
                } else {
                    for (Course course : student.getCourses()) {
                        System.out.println("        - " + course.getCourseCode() + " : " + course.getCourseName());
                        System.out.println("\n===================================================");

                    }
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }
        } else {
            System.out.println("Invalid input. Try again.");
        }
    }

    public void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < students.size()) {
            System.out.print("\nName: ");
            name = scan.nextLine();

            System.out.print("ID: ");
            id = scan.nextInt();
            scan.nextLine();

            System.out.print("Program: ");
            program = scan.nextLine();

            students.get(index - 1).setName(name);
            students.get(index - 1).setId(id);
            students.get(index - 1).setStudProgram(program);

            System.out.println("\n===================================================");
            System.out.println("\nUpdate Successful!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("\nInvalid input. Try again.");
        }
    }

    // delete
    public void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < students.size()) {
            students.remove(index - 1);
            System.out.println("\n===================================================");
            System.out.println("\nRemove Successful!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("\nInvalid input. Try again.");
        }
    }

    public Student getStudentBySpecialNumber(int specialNumber) {
        if (specialNumber - 1 >= 0 && specialNumber - 1 < students.size()) {
            return students.get(specialNumber - 1);
        }
        return null;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }}