package org.example.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.example.model.Department;
import org.example.model.Instructor;

public class DepartmentServiceImpl implements IDepartmentService {

    private ArrayList<Department> departments = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public DepartmentServiceImpl() {
        // Pre-loaded departments
        departments.add(new Department("College of Computer Studies", "CCS"));
        departments.add(new Department("College of Engineering", "COE"));
        departments.add(new Department("College of Business", "COB"));
    }

    @Override
    public void addDepartment(Department department) {
        departments.add(department);
        System.out.printf("%nDepartment added successfully. Special number: %d%n", departments.size());
    }

    @Override
    public void displayDepartments() {
        if (departments.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo departments found.");
            return;
        }

        System.out.println("\nAVAILABLE DEPARTMENTS");
        System.out.printf("%-3s %-10s %-40s %-20s%n", "No", "Code", "Department Name", "Department Head");
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < departments.size(); i++) {
            Department d = departments.get(i);
            String headName = d.getDepartmentHead() != null ? d.getDepartmentHead().getName() : "None";
            System.out.printf("%-3d %-10s %-40s %-20s%n",
                    i + 1,
                    d.getDepartmentCode(),
                    d.getDepartmentName(),
                    headName);
        }
    }

    @Override
    public void updateDepartment() {
        if (departments.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo departments to update.");
            return;
        }

        System.out.print("\nEnter department special number: ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < departments.size()) {
            System.out.print("\nDepartment Name: ");
            String name = scan.nextLine();

            System.out.print("Department Code: ");
            String code = scan.nextLine();

            departments.get(index - 1).setDepartmentName(name);
            departments.get(index - 1).setDepartmentCode(code);

            System.out.println("\n===================================================");
            System.out.println("Department updated successfully!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public void removeDepartment() {
        if (departments.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo departments to remove.");
            return;
        }

        System.out.print("\nEnter department special number: ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < departments.size()) {
            departments.remove(index - 1);
            System.out.println("\n===================================================");
            System.out.println("Department removed successfully!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public void assignDepartmentHead(int departmentIndex, Instructor instructor) {
        if (departmentIndex - 1 >= 0 && departmentIndex - 1 < departments.size()) {
            departments.get(departmentIndex - 1).setDepartmentHead(instructor);
            System.out.println("Department head assigned successfully!");
        } else {
            System.out.println("Invalid department number.");
        }
    }

    @Override
    public void addCourseToDepartment(int departmentIndex, String courseCode) {
        System.out.println("Feature to link courses with departments to be implemented with CourseService integration.");
    }

    @Override
    public Department getDepartmentByIndex(int index) {
        if (index - 1 >= 0 && index - 1 < departments.size()) {
            return departments.get(index - 1);
        }
        return null;
    }

    @Override
    public ArrayList<Department> getAllDepartments() {
        return departments;
    }
}
