package com.jocata.sms.service;

import com.jocata.sms.entity.StudentEntity;
import com.jocata.sms.form.StudentForm;

import java.util.List;

public interface StudentService {
    String createStudent(StudentForm studentForm);

    List<StudentEntity> getAllStudents();

    StudentEntity getStudentById(String id);

    StudentEntity getStudentById(String name , String email);

    String updateStudent(StudentForm studentForm);

    String deleteStudent(String id);
}
