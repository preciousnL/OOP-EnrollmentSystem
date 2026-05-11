package org.example.service;

import java.util.ArrayList;

import org.example.model.Instructor;

public interface IInstructorService {
    void addInstructor(Instructor instructor);

    void displayInstructor();

    void updateInstructor();

    void removeInstructor();

    Instructor getInstructorById(int id);

    ArrayList<Instructor> getAllInstructors();
}