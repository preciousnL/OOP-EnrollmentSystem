package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration implements IStudentService {

    private ArrayList<Student> students = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    static int index;
    static String name;
    static String id;
    static String program;
    static String ans;

    @Override
    public void saveStudent(Student student) {

        students.add(student);

        System.out.printf("%nYour special number is %d%n", students.size());
    }

    @Override
    public void displayAllStudent() {

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
                System.out.println("Student ID: " + students.get(i).getPersonID());
                System.out.println("Student Name: " + students.get(i).getPersonName());
                System.out.println("Program: " + students.get(i).getProgram());

                System.out.println("\n===================================================");
            }

        } else if (ans.equalsIgnoreCase("no")) {

            System.out.print("\nEnter special number: ");
            index = Integer.parseInt(scan.nextLine());

            if (index - 1 >= 0 && index - 1 < students.size()) {

                Student student = students.get(index - 1);

                System.out.println("\n===================================================");
                System.out.println("\nStudent ID: " + student.getPersonID());
                System.out.println("Student Name: " + student.getPersonName());
                System.out.println("Program: " + student.getProgram());
                System.out.println("\n===================================================");

            } else {

                System.out.println("Invalid input. Try again.");
            }

        } else {

            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public void updateStudent() {

        if (students.isEmpty()) {

            System.out.println("\nNo created data yet.");

            return;
        }

        System.out.print("\nEnter special number: ");
        index = Integer.parseInt(scan.nextLine());

        if (index - 1 >= 0 && index - 1 < students.size()) {

            System.out.print("\nName: ");
            name = scan.nextLine();

            System.out.print("ID: ");
            id = scan.nextLine();

            System.out.print("Program: ");
            program = scan.nextLine();

            students.get(index - 1).setPersonName(name);
            students.get(index - 1).setPersonID(id);
            students.get(index - 1).setProgram(program);

            System.out.println("\n===================================================");
            System.out.println("\nUpdate Successful!");

        } else {

            System.out.println("\n===================================================");
            System.out.println("\nInvalid input. Try again.");
        }
    }

    @Override
    public void removeStudent() {

        if (students.isEmpty()) {

            System.out.println("\n===================================================");
            System.out.println("\nNo created data yet.");

            return;
        }

        System.out.print("\nEnter special number: ");
        index = Integer.parseInt(scan.nextLine());

        if (index - 1 >= 0 && index - 1 < students.size()) {

            students.remove(index - 1);

            System.out.println("\n===================================================");
            System.out.println("\nRemove Successful!");

        } else {

            System.out.println("\n===================================================");
            System.out.println("\nInvalid input. Try again.");
        }
    }

    @Override
    public Student getStudentById(String studentId) {

        for (Student student : students) {

            if (student.getPersonID() != null && student.getPersonID().equals(studentId)) {

                return student;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {

        return students;
    }
}