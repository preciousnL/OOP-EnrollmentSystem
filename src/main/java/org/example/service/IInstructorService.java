package org.example.service;

import org.example.model.Instructor;
import java.util.ArrayList;

public interface IInstructorService {
    void addInstructor(Instructor instructor);

    void displayInstructor();

    void updateInstructor();

    void removeInstructor();

    Instructor getInstructorById(String id);

    ArrayList<Instructor> getAllInstructors();
}