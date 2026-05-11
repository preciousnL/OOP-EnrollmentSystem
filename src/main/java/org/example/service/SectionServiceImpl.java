package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.model.Student;
import org.example.exceptions.SectionFullException;

import java.util.ArrayList;
import java.util.Scanner;

public class SectionServiceImpl implements ISectionService {

    private ArrayList<Section> sections = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public SectionServiceImpl() {
        // Pre-loaded sections (will be populated when courses are available)
    }

    @Override
    public void addSection(Section section) {
        sections.add(section);
        System.out.printf("%nSection added successfully. Special number: %d%n", sections.size());
    }

    @Override
    public void displaySections() {
        if (sections.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo sections found.");
            return;
        }

        System.out.println("\nAVAILABLE SECTIONS");
        System.out.printf("%-3s %-15s %-30s %-15s %-10s %-15s%n", "No", "Section", "Course", "Instructor", "Capacity", "Enrolled");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < sections.size(); i++) {
            Section s = sections.get(i);
            String courseName = s.getCourse() != null ? s.getCourse().getCourseName() : "None";
            String instructorName = s.getInstructor() != null ? s.getInstructor().getName() : "None";
            System.out.printf("%-3d %-15s %-30s %-15s %-10d %-15d%n",
                    i + 1,
                    s.getSectionName(),
                    courseName,
                    instructorName,
                    s.getMaxCapacity(),
                    s.getEnrolledStudents().size());
        }
    }

    @Override
    public void displaySectionsByCourse(Course course) {
        if (sections.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo sections found.");
            return;
        }

        System.out.println("\nSECTIONS FOR COURSE: " + course.getCourseName());
        System.out.printf("%-3s %-15s %-15s %-10s %-15s%n", "No", "Section", "Instructor", "Capacity", "Enrolled");
        System.out.println("---------------------------------------------------------------------------------");

        int count = 0;
        for (int i = 0; i < sections.size(); i++) {
            Section s = sections.get(i);
            if (s.getCourse() != null && s.getCourse().equals(course)) {
                count++;
                String instructorName = s.getInstructor() != null ? s.getInstructor().getName() : "None";
                System.out.printf("%-3d %-15s %-15s %-10d %-15d%n",
                        i + 1,
                        s.getSectionName(),
                        instructorName,
                        s.getMaxCapacity(),
                        s.getEnrolledStudents().size());
            }
        }

        if (count == 0) {
            System.out.println("No sections available for this course.");
        }
    }

    @Override
    public void updateSection() {
        if (sections.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo sections to update.");
            return;
        }

        System.out.print("\nEnter section special number: ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < sections.size()) {
            System.out.print("\nSection Name: ");
            String name = scan.nextLine();

            System.out.print("Max Capacity: ");
            int capacity = scan.nextInt();
            scan.nextLine();

            sections.get(index - 1).setSectionName(name);
            sections.get(index - 1).setMaxCapacity(capacity);

            System.out.println("\n===================================================");
            System.out.println("Section updated successfully!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public void removeSection() {
        if (sections.isEmpty()) {
            System.out.println("\n===================================================");
            System.out.println("\nNo sections to remove.");
            return;
        }

        System.out.print("\nEnter section special number: ");
        int index = scan.nextInt();
        scan.nextLine();

        if (index - 1 >= 0 && index - 1 < sections.size()) {
            sections.remove(index - 1);
            System.out.println("\n===================================================");
            System.out.println("Section removed successfully!");
        } else {
            System.out.println("\n===================================================");
            System.out.println("Invalid input. Try again.");
        }
    }

    @Override
    public void enrollStudentToSection(int sectionIndex, Student student) throws SectionFullException {
        if (sectionIndex - 1 >= 0 && sectionIndex - 1 < sections.size()) {
            sections.get(sectionIndex - 1).enrollStudent(student);
            System.out.println("Student enrolled in section successfully!");
        } else {
            System.out.println("Invalid section number.");
        }
    }

    @Override
    public void assignInstructorToSection(int sectionIndex, Instructor instructor) {
        if (sectionIndex - 1 >= 0 && sectionIndex - 1 < sections.size()) {
            sections.get(sectionIndex - 1).setInstructor(instructor);
            System.out.println("Instructor assigned to section successfully!");
        } else {
            System.out.println("Invalid section number.");
        }
    }

    @Override
    public void assignCourseToSection(int sectionIndex, Course course) {
        if (sectionIndex - 1 >= 0 && sectionIndex - 1 < sections.size()) {
            sections.get(sectionIndex - 1).setCourse(course);
            System.out.println("Course assigned to section successfully!");
        } else {
            System.out.println("Invalid section number.");
        }
    }

    @Override
    public Section getSectionByIndex(int index) {
        if (index - 1 >= 0 && index - 1 < sections.size()) {
            return sections.get(index - 1);
        }
        return null;
    }

    @Override
    public ArrayList<Section> getAllSections() {
        return sections;
    }
}
