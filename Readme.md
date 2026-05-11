# OOP Enrollment System

-----
**Author**: Precious Nicole Lasin

**Description**: A comprehensive Java-based Enrollment System implementing Object-Oriented Programming principles with interface-driven architecture.

This project is a capstone implementation demonstrating OOP concepts including Abstraction, Inheritance, Encapsulation, and Polymorphism through a console-based enrollment management system.

## Project Description

The OOP Enrollment System is designed to manage student enrollments, course registrations, instructor assignments, department management, and tuition fee processing. The system follows a clean architecture separating business logic from entity classes using Java interfaces and service implementations.

### Key Components:
- **Student Portal**: Register students, enroll in courses, and manage tuition payments
- **Instructor Portal**: Manage instructors and assign them to sections
- **Department Management**: Organize courses under departments with department heads
- **Section Management**: Create course sections with capacity limits
- **Enrollment System**: Handle student-course enrollments with exception handling

## Features

### Core Features
- **Student Management**: Register, display, update, and remove students
- **Course Management**: Add, display, update, and remove courses
- **Instructor Management**: Manage instructors with full CRUD operations
- **Department Management**: Create departments and assign department heads
- **Section Management**: Create sections with max capacity and enroll students
- **Tuition Fee Management**: Calculate fees, apply scholarships, process payments
- **Enrollment Management**: Enroll students in courses and sections

### Advanced Features
- **Input Validation**: Duplicate ID checking, input type validation
- **Section Capacity Validation**: SectionFullException handling when section is full
- **Interface-Based Architecture**: Clean separation using service interfaces
- **CRUD Operations**: Full Create, Read, Update, Delete for all entities
- **Console/CLI Interface**: Interactive menu-driven system

## OOP Concepts Implemented

### 1. Abstraction
- Abstract `Person` class serves as base for `Student` and `Instructor`
- Service interfaces (`IStudentService`, `ICourseService`, etc.) define contracts
- Implementation details hidden behind interface methods

### 2. Inheritance
- `Student` and `Instructor` inherit from `Person` (IS-A relationship)
- Service wrapper classes (`StudentRegistration`, `CourseRegistration`) delegate to implementations
- Code reuse through inheritance hierarchy

### 3. Encapsulation
- Private fields with public getters/setters in all entity classes
- Business logic separated into service layers
- Data hiding and controlled access to internal state

### 4. Polymorphism
- Interface references point to different implementation objects
- Method overriding in service implementations
- Runtime polymorphism through interface method calls

## Interface Architecture

### Service Interfaces
| Interface | Purpose |
|-----------|---------|
| `IStudentService` | Student CRUD operations |
| `ICourseService` | Course CRUD operations |
| `IInstructorService` | Instructor CRUD operations |
| `ITuitionService` | Tuition calculation and payment |
| `IEnrollmentService` | Student-course enrollment |
| `IDepartmentService` | Department management |
| `ISectionService` | Section management with exception handling |

### Implementation Classes
- `StudentServiceImpl` / `StudentRegistration`
- `CourseServiceImpl` / `CourseRegistration`
- `InstructorServiceImpl`
- `TuitionServiceImpl` / `TuitionFeePayment`
- `EnrollmentServiceImpl`
- `DepartmentServiceImpl` / `DepartmentRegistration`
- `SectionServiceImpl` / `SectionRegistration`

### Entity Classes
- `Person` (abstract base class)
- `Student` (extends Person)
- `Instructor` (extends Person)
- `Course`
- `Department`
- `Section`

### Exception Handling
- `SectionFullException`: Custom exception for section capacity limits

## How to Run the Program

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal or IDE (Eclipse, IntelliJ, VS Code)

### Compilation
```bash
# Navigate to source directory
cd src/main/java

# Compile all Java files
javac org/example/Main.java org/example/model/*.java org/example/service/*.java org/example/exceptions/*.java
```

### Running the Program
```bash
# Run from compiled classes
cd src/main/java
java org.example.Main
```

### Or using the run script (if available):
```bash
./run.sh
```

### Using IDE
1. Import the project into your IDE
2. Set `src/main/java` as source root
3. Run `Main.java` as Java application

## Project Structure
```
OOP-EnrollmentSystem/
├── src/
│   ├── main/java/org/example/
│   │   ├── Main.java
│   │   ├── model/
│   │   │   ├── Person.java
│   │   │   ├── Student.java
│   │   │   ├── Instructor.java
│   │   │   ├── Course.java
│   │   │   ├── Department.java
│   │   │   └── Section.java
│   │   ├── service/
│   │   │   ├── IStudentService.java
│   │   │   ├── ICourseService.java
│   │   │   ├── IInstructorService.java
│   │   │   ├── ITuitionService.java
│   │   │   ├── IEnrollmentService.java
│   │   │   ├── IDepartmentService.java
│   │   │   ├── ISectionService.java
│   │   │   └── [Implementation Classes]
│   │   └── exceptions/
│   │       └── SectionFullException.java
│   └── test/java/org/example/
│       └── service/
│           ├── CourseRegistrationTest.java
│           ├── StudentRegistrationTest.java
│           ├── TuitionFeePaymentTest.java
│           ├── DuplicateStudentIdTest.java
│           ├── EnrollmentValidationTest.java
│           ├── PaymentBalanceTest.java
│           ├── SectionFullValidationTest.java
│           ├── TuitionFeeCalculationTest.java
│           └── RunTests.java
├── pom.xml
└── README.md
```

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
