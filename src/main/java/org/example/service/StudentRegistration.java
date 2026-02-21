package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    private ArrayList<Student> students = new ArrayList();
    static Scanner scan = new Scanner(System.in);
    static int index;
    static String name;
    static int id;
    static String program;
    static String ans;

    //create
    public void addStudent(Student student){
        students.add(student);
        for (int i = 0; i < students.size(); i++) {
            if(students.size() - 1 == i){
                System.out.printf("Your special number is %s", i);
                System.out.println(" ");
            }
        }
    }

    //read
    public void displayAll(){
        if (students.isEmpty()){
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nDo you want to read all? (Yes/ No): ");
        ans = scan.nextLine();
        if (ans.equalsIgnoreCase("yes")){
            for(int i = 0; i < students.size(); i++){
                System.out.println(students.get(i).getStudID());
                System.out.println(students.get(i).getStudName());
                System.out.println(students.get(i).getStudProgram());
            }
        } else if (ans.equalsIgnoreCase("no")){
            System.out.print("Enter special number: ");
            index = scan.nextInt();
            if (index <= students.size()){
                System.out.println(students.get(index).getStudID());
                System.out.println(students.get(index).getStudName());
                System.out.println(students.get(index).getStudProgram());
            } else {
                System.out.println("Invalid input. Try again.");
            }
        } else {
            System.out.println("Invalid input. Try again.");
        }
    }

    //update
    public void updateStudent(){
        if (students.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();

        System.out.print("Name: ");
        name = scan.nextLine();
        System.out.print("Age: ");
        id = scan.nextInt();

        students.get(index).setStudName(name);
        students.get(index).setStudID(id);
        students.get(index).setStudProgram(program);
        System.out.println("Update Successful!");
    }

    //delete
    public void removeStudent(){
        if (students.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();
        students.remove(index);
        System.out.println("Remove Successful!");
    }
}

