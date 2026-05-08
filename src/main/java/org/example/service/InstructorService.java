package org.example.service;

import org.example.model.Instructor;
import java.util.ArrayList;

public interface InstructorService {

    void addInstructor(Instructor instructor);

    void displayInstructor();

    void updateInstructor();

    void removeInstructor();

    Instructor getInstructorBySpecialNumber(int specialNumber);

    Instructor getInstructorById(int id);

    ArrayList<Instructor> getAllInstructors();
}