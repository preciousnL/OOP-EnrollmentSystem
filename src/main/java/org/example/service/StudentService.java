package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public interface StudentService {

    void addStudent(Student student);

    void displayStudent();

    void updateStudent();

    void removeStudent();

    Student getStudentBySpecialNumber(int specialNumber);

    Student getStudentById(int id);

    ArrayList<Student> getAllStudents();
}