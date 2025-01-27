# Student Management System (SMS)

The Student Management System (SMS) is a robust Java-based application designed to manage data for students, courses, lecturers, and administrators. Built using the Model-View-Controller (MVC) architecture, it incorporates advanced programming concepts and techniques to deliver a flexible, scalable, and user-friendly system.

## Key Features

### Core Functionality:
- **Admin Login**: Provides secure access to administrative functions.
- **CRUD Operations**: Comprehensive Create, Read, Update, and Delete operations implemented for:
  - Students
  - Lectures
  - Courses
  - Addresses

### Entity Relationships:
- **Student Details**:
  - Each student has an `Address` object representing their address details.
  - Each student is associated with a list of `Courses`.
- **Course Details**:
  - Each course maintains a list of `Lecturers` teaching the course.
  
### Advanced Features:
- **File-Based Data Storage**:
  - Data persistence is achieved through a file system, ensuring flexibility and offline storage.
- **Event Manager**:
  - Centralized event management for handling CRUD operations efficiently.
- **Object-Oriented Design**:
  - Fully utilizes OOP principles (Encapsulation, Inheritance, Polymorphism, and Abstraction).
- **Auto-Generated IDs**:
  - Unique identifiers for each entity, ensuring no duplicates.
- **Duplicate Handling**:
  - Mechanisms to prevent duplicate entries in the system.
- **Reflection API**:
  - Dynamically retrieves and manipulates entity data at runtime.

## Project Structure

### MVC Architecture:
- **Model**: Defines entities such as `Student`, `Lecturer`, `Course`, `Address`, and handles data-related logic.
- **View**: Provides user interaction interfaces for data input and display.
- **Controller**: Manages business logic, processes user inputs, and updates the Model and View.

### Packages:
- `Controller`: Manages CRUD operations and business logic.
- `Service`: Implements core functionalities such as event handling and validation.
- `DAO`: Provides file-based data storage and retrieval operations.
- `Entity`: Defines core objects like `StudentEntity`, `AdminEntity`, `CoursesEntity`, etc.
- `Form`: Handles forms such as `StudentForm`, `AdminForm`, ensuring input is processed properly.

### Data Storage:
- Uses a map-based file system:
  - Class names as keys.
  - Lists of object instances as values.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/RaviAnnamdevula/SMS.git
   cd SMS
