package com.jocata.sms.dao;

import com.jocata.sms.entity.StudentEntity;
import com.jocata.sms.form.StudentForm;

import java.util.List;

public interface StudentDao {

    String createStudent(StudentEntity studentEntity);

    List<StudentEntity> getAllStudents();

    StudentEntity getStudentById(String id);

    StudentEntity getStudentById(String name , String email);

    String updateStudent(StudentEntity studentForm);

    String deleteStudent(String id);
}
