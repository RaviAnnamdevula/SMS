package com.jocata.sms.service;

import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.form.LecturerForm;

import java.util.List;

public interface LectureService {
    String createLecturer(LecturerForm lecturerForm);

    List<LecturerEntity> getAllLecturers();

    LecturerEntity getLecturerById(String id);

    LecturerEntity getLecturerById(String name , String email);

    String updateLecturer(LecturerForm lecturerForm);

    String deleteLecturer(String id);
}
