package com.jocata.sms.dao.impl;

import com.jocata.sms.dao.LecturerDao;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.form.LecturerForm;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.impl.EntityManagerImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LecturerDaoImpl implements LecturerDao {
    EntityManager entityManager = new EntityManagerImpl();
    @Override
    public String createLecturer(LecturerEntity lecturerEntity) {

        LecturerEntity lecturerEntity1 = getLecturerById(lecturerEntity.getLectureName() ,lecturerEntity.getEmail());

        if(lecturerEntity1 != null){
            return lecturerEntity.getLectureName()+ " is already registered with ID: "+lecturerEntity1.getLectureId();
        }

        boolean isCreated  = entityManager.save(LecturerEntity.class , lecturerEntity);
        if (!isCreated){
            return "Enter Valid Details";
        }
        return lecturerEntity.getLectureName()+" Lecturer details updated with id: "+lecturerEntity.getLectureId();
    }

    @Override
    public List<LecturerEntity> getAllLecturers() {
         List<Object> list =  entityManager.get(LecturerEntity.class);
         List<LecturerEntity> lecturerEntities = new ArrayList<>();
         for (Object o : list){
             lecturerEntities.add((LecturerEntity) o);
         }
        return lecturerEntities;
    }

    @Override
    public LecturerEntity getLecturerById(String id) {
        List<Object> list =  entityManager.get(LecturerEntity.class);
        for (Object o : list){
            LecturerEntity lecturerEntity = (LecturerEntity)o;
            if(lecturerEntity.getLectureId().equals(id)){
                System.out.println(lecturerEntity.getLectureName()+" Details");
                return lecturerEntity;
            }
        }
        System.out.println("Lecture is not present with Id: "+id);
        return null;
    }

    public LecturerEntity getLecturerById(String name , String email) {
        List<Object> list =  entityManager.get(LecturerEntity.class);
        for (Object o : list){
            LecturerEntity lecturerEntity = (LecturerEntity)o;
            if(lecturerEntity.getLectureName().equals(name) && lecturerEntity.getEmail().equals(email)){
                //System.out.println(lecturerEntity.getLectureName()+" Details");
                return lecturerEntity;
            }
        }
        // System.out.println("Lecture is not present with name: "+name +" and email: "+ email);
        return null;
    }

    @Override
    public String updateLecturer(LecturerEntity lecturerEntity) {
        entityManager.update(LecturerEntity.class ,lecturerEntity);
        return "Account Updated";
    }

    @Override
    public String deleteLecturer(String id) {
        List<Object> list =  entityManager.get(LecturerEntity.class);
        for (Object o : list){
            LecturerEntity lecturerEntity = (LecturerEntity) o;
            if(lecturerEntity.getLectureId().equals(id)){
                entityManager.delete(LecturerEntity.class ,lecturerEntity);
                return lecturerEntity.getLectureName()+" deleted From the records";
            }
        }
        return "No Lecture is present with Id: "+id;
    }
}
