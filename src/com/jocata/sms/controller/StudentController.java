package com.jocata.sms.controller;

import com.jocata.sms.entity.StudentEntity;
import com.jocata.sms.form.AdminForm;
import com.jocata.sms.form.StudentForm;
import com.jocata.sms.service.StudentService;
import com.jocata.sms.service.impl.StudentServiceImpl;

import java.util.List;

public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    public String createStudent(StudentForm studentForm) {
        return studentService.createStudent(studentForm);

    }

    // Get All Students
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student by ID
    public StudentEntity getStudentById(String id) {
        return studentService.getStudentById(id);
    }

    public StudentEntity getStudentById(String name , String email) {
        return studentService.getStudentById(name , email);
    }

    // Update Student
    public String updateStudent(StudentForm studentForm) {
        return studentService.updateStudent(studentForm);

    }

    // Delete Student
    public String deleteStudent(String id) {
        return studentService.deleteStudent(id);

    }

}
