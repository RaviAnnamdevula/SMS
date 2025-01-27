package com.jocata.sms.controller;

import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.form.CoursesForm;
import com.jocata.sms.service.CoursesService;
import com.jocata.sms.service.impl.CoursesServiceImpl;

import java.util.List;

public class CoursesController {
    CoursesService coursesService = new CoursesServiceImpl();

    //create C
    public String createCourses(CoursesForm coursesForm){
        return coursesService.createCourses(coursesForm);
    }

    //get all courses R
    public List<CoursesEntity> getAllCourses(){
        return coursesService.getAllCourses();
    }

    //get courses by Id
    public CoursesEntity getCourses(String id){
        return coursesService.getCourses(id);
    }

    public CoursesEntity getCourses(String courseName , String courseType){
        return coursesService.getCourses(courseName , courseType);
    }

    //update courses
    public String updateCourses(CoursesForm coursesForm){
        return coursesService.updateCourses(coursesForm);
    }

    //Delete courses
    public String deleteCourses(String id){
        return coursesService.deleteCourses(id);
    }
}
