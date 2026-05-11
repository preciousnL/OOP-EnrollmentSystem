package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;
import org.example.exceptions.SectionFullException;
import java.util.ArrayList;

public class SectionRegistration implements ISectionService {

    private final SectionServiceImpl impl = new SectionServiceImpl();

    @Override
    public void addSection(Section section) {
        impl.addSection(section);
    }

    @Override
    public void displaySections() {
        impl.displaySections();
    }

    @Override
    public void displaySectionsByCourse(Course course) {
        impl.displaySectionsByCourse(course);
    }

    @Override
    public void updateSection() {
        impl.updateSection();
    }

    @Override
    public void removeSection() {
        impl.removeSection();
    }

    @Override
    public void enrollStudentToSection(int sectionIndex, Student student) throws SectionFullException {
        impl.enrollStudentToSection(sectionIndex, student);
    }

    @Override
    public void assignInstructorToSection(int sectionIndex, Instructor instructor) {
        impl.assignInstructorToSection(sectionIndex, instructor);
    }

    @Override
    public void assignCourseToSection(int sectionIndex, Course course) {
        impl.assignCourseToSection(sectionIndex, course);
    }

    @Override
    public Section getSectionByIndex(int index) {
        return impl.getSectionByIndex(index);
    }

    @Override
    public ArrayList<Section> getAllSections() {
        return impl.getAllSections();
    }
}
