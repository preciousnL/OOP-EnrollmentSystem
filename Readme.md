# Interface-Driven Enrollment System

-----
**Author**: Precious Nicole Lasin

**Description**: OOP Enrollment System | Capstone Project | Interface-Based Architecture using Java Interfaces and Implementation Classes

This update improves the Enrollment System by applying interface-driven architecture following Object-Oriented Programming principles and capstone project requirements. Business logic was separated from entity classes through the use of Java interfaces and implementation classes.

The system now uses service interfaces as method contracts while implementation classes handle the actual operations for student management, course management, enrollment, instructor handling, and tuition processing.

Entity classes were also cleaned and simplified to contain only attributes, constructors, and getter/setter methods.

## Features Implemented
- Student Management
- Course Management
- Instructor Management
- Tuition Fee Management
- Enrollment Management
- CRUD Operations using ArrayLists
- Interface-Based Architecture
- Separation of Concerns
- Console/CLI-Based Functionality

## Service Interfaces
- StudentService
- CourseService
- InstructorService
- TuitionService
- EnrollmentService

## Implementation Classes
- StudentServiceImpl
- CourseServiceImpl
- InstructorServiceImpl
- TuitionServiceImpl
- EnrollmentServiceImpl

## Entity Classes Cleaned
- Student
- Instructor
- Course
- Person

The entity classes now contain only:
- attributes
- constructors
- getters/setters

---

**Screenshot**: IStudentService.java
![image11.png](src/main/resources/image/image11.png)

**Screenshot**: ICourseService.java
![image12.png](src/main/resources/image/image12.png)

**Screenshot**: IInstructorService.java
![image13.png](src/main/resources/image/image13.png)

**Screenshot**: ITuitionService.java
![image14.png](src/main/resources/image/image14.png)

**Screenshot**: IEnrollmentService.java
![image15.png](src/main/resources/image/image15.png)

**Screenshot**: StudentServiceImpl.java
![image16.png](src/main/resources/image/image16.png)

**Screenshot**: CourseServiceImpl.java
![image17.png](src/main/resources/image/image17.png)

**Screenshot**: TuitionServiceImpl.java
![image18.png](src/main/resources/image/image18.png)

**Screenshot**: Cleaned Student.java
![image19.png](src/main/resources/image/image19.png)

**Screenshot**: Cleaned Instructor.java
![image20.png](src/main/resources/image/image20.png)
