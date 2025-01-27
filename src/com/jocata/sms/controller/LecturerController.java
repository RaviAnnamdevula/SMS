package com.jocata.sms.controller;

import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.form.LecturerForm;
import com.jocata.sms.service.LectureService;
import com.jocata.sms.service.impl.LectureServiceImpl;

import java.util.List;

public class LecturerController {
    LectureService lectureService = new LectureServiceImpl();

    // Create Lecturer
    public String createLecturer(LecturerForm lecturerForm) {
        return lectureService.createLecturer(lecturerForm);

    }

    // Get All Lecturers
    public List<LecturerEntity> getAllLecturers() {
        return lectureService.getAllLecturers();
    }

    // Get Lecturer by ID
    public LecturerEntity getLecturerById(String id) {
        return lectureService.getLecturerById(id);
    }

    public LecturerEntity getLecturerById(String name ,String email) {
        return lectureService.getLecturerById(name , email);
    }

    // Update Lecturer
    public String updateLecturer(LecturerForm lecturerForm) {
        return lectureService.updateLecturer(lecturerForm);

    }

    // Delete Lecturer
    public String deleteLecturer(String id) {
        return lectureService.deleteLecturer(id);

    }
}
