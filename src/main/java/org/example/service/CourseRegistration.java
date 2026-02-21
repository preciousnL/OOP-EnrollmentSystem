package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    private ArrayList<Course> courses = new ArrayList();
    static Scanner scan = new Scanner(System.in);
    static int index;
    static String name;
    static String code;
    static String program;
    static String ans;

    //create
    public void addCourse(Course course){
        courses.add(course);
        for (int i = 0; i < this.courses.size(); i++) {
            if(courses.size() - 1 == i){
                System.out.printf("Your special number is %s", i);
                System.out.println(" ");
            }
        }
    }

    //read
    public void displayAll(){
        if (courses.isEmpty()){
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nDo you want to read all? (Yes/ No): ");
        ans = scan.nextLine();
        if (ans.equalsIgnoreCase("yes")){
            for(int i = 0; i < courses.size(); i++){
                System.out.println(courses.get(i).getCourseName());
                System.out.println(courses.get(i).getCourseCode());
                System.out.println(courses.get(i).getCourseProgram());
            }
        } else if (ans.equalsIgnoreCase("no")){
            System.out.print("Enter special number: ");
            index = scan.nextInt();
            if (index <= courses.size()){
                System.out.println(courses.get(index).getClass());
                System.out.println(courses.get(index).getCourseCode());
                System.out.println(courses.get(index).getCourseProgram());
            } else {
                System.out.println("Invalid input. Try again.");
            }
        } else {
            System.out.println("Invalid input. Try again.");
        }
    }

    //update
    public void updateCourse(){
        if (courses.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();

        System.out.print("Course Code: ");
        code = scan.nextLine();
        System.out.print("Course Name: ");
        name = scan.nextLine();
        System.out.print("Course Program: ");
        program = scan.nextLine();

        courses.get(index).setCourseName(name);
        courses.get(index).setCourseCode(code);
        System.out.println("Update Successful!");
    }

    //delete
    public void removeCourse(){
        if (courses.isEmpty()) {
            System.out.println("\nNo created data yet.");
            return;
        }

        System.out.print("\nEnter special number: ");
        index = scan.nextInt();
        courses.remove(index);
        System.out.println("Remove Successful!");
    }
}

