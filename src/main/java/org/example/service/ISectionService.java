package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;
import org.example.exceptions.SectionFullException;
import java.util.ArrayList;

public interface ISectionService {
    void addSection(Section section);
    void displaySections();
    void displaySectionsByCourse(Course course);
    void updateSection();
    void removeSection();
    void enrollStudentToSection(int sectionIndex, Student student) throws SectionFullException;
    void assignInstructorToSection(int sectionIndex, Instructor instructor);
    void assignCourseToSection(int sectionIndex, Course course);
    Section getSectionByIndex(int index);
    ArrayList<Section> getAllSections();
}
