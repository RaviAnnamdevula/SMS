package com.jocata.sms.dao;

import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.form.CoursesForm;

import java.util.List;

public interface CoursesDao {
    String createCourses(CoursesEntity coursesEntity);

    List<CoursesEntity> getAllCourses();

    CoursesEntity getCourses(String id);

    CoursesEntity getCourses(String courseName , String courseType);

    String updateCourses(CoursesEntity coursesEntity);

    String deleteCourses(String id);
}
