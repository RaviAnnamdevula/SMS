package com.jocata.sms.dao.impl;

import com.jocata.sms.dao.CoursesDao;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.form.CoursesForm;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.impl.EntityManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class CoursesDaoImpl implements CoursesDao {
    EntityManager entityManager= new EntityManagerImpl();

    @Override
    public String createCourses(CoursesEntity coursesEntity) {

        CoursesEntity coursesEntity1 = getCourses(coursesEntity.getCourseName() , coursesEntity.getCourseType());

        if(coursesEntity1 != null){
            return coursesEntity.getCourseName()+" details is already registered with ID: "+coursesEntity1.getCourseId();
        }

        boolean isCreated = entityManager.save(CoursesEntity.class ,coursesEntity);
        if(!isCreated){
            return "Error Occurred";
        }
        return "Your Address is saved Successfully with ID: "+coursesEntity.getCourseId();
    }

    @Override
    public List<CoursesEntity> getAllCourses() {
        List<Object> objects = entityManager.get(CoursesEntity.class);
        List<CoursesEntity> coursesEntities = new ArrayList<>();
        for (Object obj : objects){
            coursesEntities.add((CoursesEntity) obj);
        }
        return coursesEntities;
    }

    @Override
    public CoursesEntity getCourses(String id) {
        List<Object> objects = entityManager.get(CoursesEntity.class);
        for (Object obj : objects){
            CoursesEntity coursesEntity = (CoursesEntity) obj ;
            if(coursesEntity.getCourseId().equals(id)){
                return coursesEntity;
            }
        }
        System.out.println("Id not present");
        return null;
    }

    @Override
    public CoursesEntity getCourses(String courseName, String courseType) {
        List<Object> objects = entityManager.get(CoursesEntity.class);
        for (Object obj : objects){
            CoursesEntity coursesEntity = (CoursesEntity) obj ;
            if(coursesEntity.getCourseName().equals(courseName) && coursesEntity.getCourseType().equals(courseType)){
                return coursesEntity;
            }
        }
        return null;
    }

    @Override
    public String updateCourses(CoursesEntity coursesEntity) {
        boolean temp = entityManager.update(CoursesEntity.class, coursesEntity);
        if(!temp){
            return "Enter Details Properly";
        }
        return "Successfully Updated the Address Details your Id is "+coursesEntity.getCourseId();
    }

    @Override
    public String deleteCourses(String id) {
        List<Object> objects = entityManager.get(CoursesEntity.class);
        for (Object obj : objects){
            CoursesEntity coursesEntity = (CoursesEntity) obj ;
            if(coursesEntity.getCourseId().equals(id)){
                entityManager.delete(AddressEntity.class ,coursesEntity);
                return "Address with Id "+coursesEntity.getCourseId()+" deleted From the records";
            }
        }
        return  "Id not present";
    }
}
