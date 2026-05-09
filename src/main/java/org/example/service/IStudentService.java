package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public interface IStudentService {
    void saveStudent(Student student);

    void displayAllStudent();

    void updateStudent();

    void removeStudent();

    Student getStudentById(String studentId);

    ArrayList<Student> getAllStudents();
}