package com.jocata.sms.dao;

import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.form.LecturerForm;

import java.util.List;

public interface LecturerDao {
    String createLecturer(LecturerEntity lecturerEntity);

    List<LecturerEntity> getAllLecturers();

    LecturerEntity getLecturerById(String id);

    LecturerEntity getLecturerById(String name , String email);

    String updateLecturer(LecturerEntity lecturerEntity);

    String deleteLecturer(String id);
}
