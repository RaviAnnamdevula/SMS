package com.jocata.sms.dao.impl;

import com.jocata.sms.dao.StudentDao;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.entity.StudentEntity;
import com.jocata.sms.form.StudentForm;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.impl.EntityManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    EntityManager entityManager = new EntityManagerImpl();
    @Override
    public String createStudent(StudentEntity studentEntity) {

        StudentEntity studentEntity1 = getStudentById(studentEntity.getName() , studentEntity.getEmail());

        if(studentEntity1 != null){
            return studentEntity.getName()+" with email "+ studentEntity.getEmail()+" is already registered with ID: "+studentEntity1.getStudentId();
        }

        boolean isCreated = entityManager.save(StudentEntity.class ,studentEntity);
        if(!isCreated){
            return "Enter valid Details";
        }
        return "Student Details Saved Student ID is: "+studentEntity.getStudentId();
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<Object> objects = entityManager.get(StudentEntity.class);
        List<StudentEntity> studentEntities = new ArrayList<>();
        for (Object obj : objects){
            studentEntities.add((StudentEntity) obj);
        }
        return studentEntities;
    }

    @Override
    public StudentEntity getStudentById(String id) {
        List<Object> objects = entityManager.get(StudentEntity.class);
        for (Object obj : objects){
            StudentEntity studentEntity = (StudentEntity) obj ;
            if(studentEntity.getStudentId().equals(id)){
                return studentEntity;
            }
        }
        System.out.println("Id not present");
        return null;
    }

    @Override
    public StudentEntity getStudentById(String name , String email) {
        List<Object> objects = entityManager.get(StudentEntity.class);
        for (Object obj : objects){
            StudentEntity studentEntity = (StudentEntity) obj ;
            if(studentEntity.getName().equals(name) && studentEntity.getEmail().equals(email)){
                return studentEntity;
            }
        }
        return null;
    }


    @Override
    public String updateStudent(StudentEntity studentEntity) {
        boolean isUpdate = entityManager.update(StudentEntity.class, studentEntity);
        if(!isUpdate){
            return "Enter Details Properly";
        }
        return "Successfully Updated the Address Details your Id is "+studentEntity.getStudentId();
    }

    @Override
    public String deleteStudent(String id) {
        List<Object> objects = entityManager.get(StudentEntity.class);
        for (Object obj : objects){
            StudentEntity studentEntity = (StudentEntity) obj ;
            if(studentEntity.getStudentId().equals(id)){
                entityManager.delete(AddressEntity.class ,studentEntity);
                return "Address with Id "+studentEntity.getStudentId()+" deleted From the records";
            }
        }
        return  "Id not present";
    }
}
