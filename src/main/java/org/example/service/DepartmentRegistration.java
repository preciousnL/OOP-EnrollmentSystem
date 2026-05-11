package org.example.service;

import org.example.model.Department;
import org.example.model.Instructor;
import java.util.ArrayList;

/**
 * Delegates all logic to DepartmentServiceImpl.
 * Kept for backward compatibility with Main.java.
 */
public class DepartmentRegistration implements IDepartmentService {

    private final DepartmentServiceImpl impl = new DepartmentServiceImpl();

    @Override
    public void addDepartment(Department department) {
        impl.addDepartment(department);
    }

    @Override
    public void displayDepartments() {
        impl.displayDepartments();
    }

    @Override
    public void updateDepartment() {
        impl.updateDepartment();
    }

    @Override
    public void removeDepartment() {
        impl.removeDepartment();
    }

    @Override
    public void assignDepartmentHead(int departmentIndex, Instructor instructor) {
        impl.assignDepartmentHead(departmentIndex, instructor);
    }

    @Override
    public void addCourseToDepartment(int departmentIndex, String courseCode) {
        impl.addCourseToDepartment(departmentIndex, courseCode);
    }

    @Override
    public Department getDepartmentByIndex(int index) {
        return impl.getDepartmentByIndex(index);
    }

    @Override
    public ArrayList<Department> getAllDepartments() {
        return impl.getAllDepartments();
    }
}
