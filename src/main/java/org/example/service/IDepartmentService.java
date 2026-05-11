package org.example.service;

import org.example.model.Department;
import org.example.model.Instructor;
import java.util.ArrayList;

public interface IDepartmentService {
    void addDepartment(Department department);
    void displayDepartments();
    void updateDepartment();
    void removeDepartment();
    void assignDepartmentHead(int departmentIndex, Instructor instructor);
    void addCourseToDepartment(int departmentIndex, String courseCode);
    Department getDepartmentByIndex(int index);
    ArrayList<Department> getAllDepartments();
}
