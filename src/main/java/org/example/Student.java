package org.example;

public class Student {
    private int studID;
    private String studName;
    private String studProgram;

    public Student(){

    }

    public Student(int studID, String studName, String studProgram){
        this.studID = studID;
        this.studName = studName;
        this.studProgram = studProgram;

    }

    public int getStudID(){
        return studID;
    }

    public void setStudID(int studID){
        this.studID = studID;
    }

    public String getStudName(){
        return studName;
    }

    public void setStudName(String studName){
        this.studName = studName;
    }

    public String getStudProgram(){
        return studProgram;
    }

    public void setStudProgram(String studProgram){
        this.studProgram = studProgram;
    }

    public void display(){
        System.out.printf("\nStudent ID: %d", studID);
        System.out.printf("\nStudent Name: %s", studName);
        System.out.printf("\nStudent Program: %s\n", studProgram);
    }
}
