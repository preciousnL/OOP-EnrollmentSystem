package org.example.service;

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

    // create
    public void addStudent(Student student) {
        students.add(student);
        System.out.printf("Your special number is %d%n", students.size() - 1);
    }

    // read
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nDo you want to read all? (Yes/No): ");
        ans = scan.nextLine();

        if (ans.equalsIgnoreCase("yes")) {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("\nSpecial Number: " + i);
                System.out.println("Student ID: " + students.get(i).getId());
                System.out.println("Student Name: " + students.get(i).getName());
                System.out.println("Program: " + students.get(i).getStudProgram());
            }
        } else if (ans.equalsIgnoreCase("no")) {
            System.out.print("Enter special number: ");
            index = scan.nextInt();

            if (index >= 0 && index < students.size()) {
                System.out.println("\nStudent ID: " + students.get(index).getId());
                System.out.println("Student Name: " + students.get(index).getName());
                System.out.println("Program: " + students.get(index).getStudProgram());
            } else {
                System.out.println("Invalid input. Try again.");
            }
        } else {
            System.out.println("Invalid input. Try again.");
        }
    }

    // update
    public void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();
        scan.nextLine();

        if (index >= 0 && index < students.size()) {
            System.out.print("Name: ");
            name = scan.nextLine();

            System.out.print("ID: ");
            id = scan.nextInt();
            scan.nextLine();

            System.out.print("Program: ");
            program = scan.nextLine();

            students.get(index).setName(name);
            students.get(index).setId(id);
            students.get(index).setStudProgram(program);

            System.out.println("Update Successful!");
        } else {
            System.out.println("Invalid input. Try again.");
        }
    }

    // delete
    public void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();

        if (index >= 0 && index < students.size()) {
            students.remove(index);
            System.out.println("Remove Successful!");
        } else {
            System.out.println("Invalid input. Try again.");
        }
    }
}