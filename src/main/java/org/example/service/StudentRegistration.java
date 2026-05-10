package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

/**
 * Delegates all logic to StudentServiceImpl.
 * Kept for backward compatibility with Main.java.
 */
public class StudentRegistration implements IStudentService {

    private final StudentServiceImpl impl = new StudentServiceImpl();

    @Override
    public void addStudent(Student student) {
        impl.addStudent(student);
    }

    @Override
    public void displayStudent() {
        impl.displayStudent();
    }

    @Override
    public void updateStudent() {
        impl.updateStudent();
    }

    @Override
    public void removeStudent() {
        impl.removeStudent();
    }

    @Override
    public Student getStudentBySpecialNumber(int specialNumber) {
        return impl.getStudentBySpecialNumber(specialNumber);
    }

    @Override
    public Student getStudentById(int id) {
        return impl.getStudentById(id);
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return impl.getAllStudents();
    }
}