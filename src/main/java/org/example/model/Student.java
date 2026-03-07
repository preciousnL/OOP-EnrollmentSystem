package org.example.model;

public class Student extends Person{
    private String studProgram;

    public Student(int id, String name){
        super (id, name);
    }

    public String getStudProgram(){
        return studProgram;
    }

    public void setStudProgram(String studProgram){
        this.studProgram = studProgram;
    }

    public void display(){
        System.out.println("\nStudent Details:");
        System.out.printf("Student ID: %d", getId());
        System.out.printf("\nStudent Name: %s", getName());
        System.out.printf("\nStudent Program: %s\n", getStudProgram());
    }
}
