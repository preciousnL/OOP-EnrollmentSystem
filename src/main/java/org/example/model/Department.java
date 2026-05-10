package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private String departmentCode;
    private List<Course> courses;
    private Instructor departmentHead;

    public Department() {
        this.courses = new ArrayList<>();
    }

    public Department(String departmentName, String departmentCode) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.courses = new ArrayList<>();
    }

    public Department(String departmentName, String departmentCode, Instructor departmentHead) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.departmentHead = departmentHead;
        this.courses = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Instructor getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(Instructor departmentHead) {
        this.departmentHead = departmentHead;
    }
}
