package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class StudentServiceImpl implements IStudentService {
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    public void saveStudent(Student student) {
        studentList.add(student);
        System.out.println("Student saved successfully.");
    }

    @Override
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : studentList) {
            System.out.println("Student ID: " + student.getPersonID());
            System.out.println("Student Name: " + student.getPersonName());
            System.out.println("Program: " + student.getProgram());
            System.out.println();
        }
    }

    @Override
    public void updateStudent() {
        System.out.println("Update student functionality to be implemented.");
    }

    @Override
    public void removeStudent() {
        System.out.println("Remove student functionality to be implemented.");
    }

    @Override
    public Student getStudentById(String studentId) {
        for (Student student : studentList) {
            if (student.getPersonID() != null && student.getPersonID().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return studentList;
    }
}
