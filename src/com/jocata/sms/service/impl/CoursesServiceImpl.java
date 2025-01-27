package com.jocata.sms.service.impl;

import com.jocata.sms.controller.CoursesController;
import com.jocata.sms.dao.CoursesDao;
import com.jocata.sms.dao.impl.CoursesDaoImpl;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.form.CoursesForm;
import com.jocata.sms.form.LecturerForm;
import com.jocata.sms.service.CoursesService;

import java.util.ArrayList;
import java.util.List;

public class CoursesServiceImpl implements CoursesService {

    CoursesDao coursesDao = new CoursesDaoImpl();
    @Override
    public String createCourses(CoursesForm coursesForm) {
        CoursesEntity coursesEntity = new CoursesEntity();
        coursesEntity.setCourseId(coursesForm.getId());
        coursesEntity.setCourseDuration(coursesForm.getCourseDuration());
        coursesEntity.setCourseType(coursesForm.getCourseType());
        coursesEntity.setDescription(coursesForm.getDescription());
        coursesEntity.setCourseName(coursesForm.getCourseName());

        List<LecturerForm> list = coursesForm.getLecturers();
        List<LecturerEntity> entities = new ArrayList<>();

        for(LecturerForm l : list){
            LecturerEntity en = new LecturerEntity();
            en.setLectureId(l.getId());
            en.setEmail(l.getEmail());
            en.setPhoneNo(l.getlPhoneNo());
            en.setLectureName(l.getLectureName());
            entities.add(en);
        }
        coursesEntity.setLectures(entities);
        return coursesDao.createCourses(coursesEntity);
    }

    @Override
    public List<CoursesEntity> getAllCourses() {
        return coursesDao.getAllCourses();
    }

    @Override
    public CoursesEntity getCourses(String id) {
        return coursesDao.getCourses(id);
    }

    @Override
    public CoursesEntity getCourses(String courseName, String courseType) {
        return coursesDao.getCourses(courseName , courseType);
    }

    @Override
    public String updateCourses(CoursesForm coursesForm) {
        CoursesEntity coursesEntity = new CoursesEntity();
        coursesEntity.setCourseId(coursesForm.getId());
        coursesEntity.setCourseDuration(coursesForm.getCourseDuration());
        coursesEntity.setCourseType(coursesForm.getCourseType());
        coursesEntity.setDescription(coursesForm.getDescription());
        coursesEntity.setCourseName(coursesForm.getCourseName());
        coursesEntity.setCourseDuration(coursesForm.getCourseDuration());

        List<LecturerForm> list = coursesForm.getLecturers();
        List<LecturerEntity> entities = new ArrayList<>();

        for(LecturerForm l : list){
            LecturerEntity en = new LecturerEntity();
            en.setLectureId(l.getId());
            en.setEmail(l.getEmail());
            en.setPhoneNo(l.getlPhoneNo());
            en.setLectureName(l.getLectureName());
            entities.add(en);
        }
        coursesEntity.setLectures(entities);
        return coursesDao.updateCourses(coursesEntity);
    }

    @Override
    public String deleteCourses(String id) {
        return coursesDao.deleteCourses(id);
    }
}
