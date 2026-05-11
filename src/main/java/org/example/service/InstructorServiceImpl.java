package org.example.service;

import org.example.model.Instructor;
import java.util.ArrayList;

public class InstructorServiceImpl implements IInstructorService {
    private ArrayList<Instructor> instructors = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        System.out.println("Instructor added successfully.");
    }

    @Override
    public void displayInstructor() {
        if (instructors.isEmpty()) {
            System.out.println("No instructors found.");
            return;
        }
        System.out.println("\nInstructors:");
        for (Instructor instructor : instructors) {
            System.out.printf("ID: %s, Name: %s\n", instructor.getId(), instructor.getName());
        }
    }

    @Override
    public void updateInstructor() {
        System.out.println("Update instructor functionality to be implemented.");
    }

    @Override
    public void removeInstructor() {
        System.out.println("Remove instructor functionality to be implemented.");
    }

    @Override
    public Instructor getInstructorById(int id) {
        for (Instructor instructor : instructors) {
            if (instructor.getId() == id) {
                return instructor;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Instructor> getAllInstructors() {
        return instructors;
    }
}
