package com.jocata.sms.service;

import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.form.CoursesForm;

import java.util.List;

public interface CoursesService {
    String createCourses(CoursesForm coursesForm);

    List<CoursesEntity> getAllCourses();

    CoursesEntity getCourses(String id);

    CoursesEntity getCourses(String courseName, String courseType);

    String updateCourses(CoursesForm coursesForm);

    String deleteCourses(String id);
}
