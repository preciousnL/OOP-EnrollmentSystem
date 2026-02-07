package org.example;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.setStudID(2026123456);
        student.setStudName("John Doe");
        student.setStudProgram("Information Technology");

        Student student1 = new Student();
        student1.setStudID(202678910);
        student1.setStudName("Jane Doe");
        student1.setStudProgram("Information Technology");

        Course subject = new Course();
        subject.setCourseCode("INTEPROG");
        subject.setCourseName("Integrative Programming");
        subject.setCourseProgram("Information Technology");

        System.out.println("\nENROLLMENT SYSTEM");
        student.display();
        student1.display();
        subject.display();

    }
}