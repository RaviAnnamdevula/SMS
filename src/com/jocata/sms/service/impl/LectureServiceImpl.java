package com.jocata.sms.service.impl;

import com.jocata.sms.dao.LecturerDao;
import com.jocata.sms.dao.impl.LecturerDaoImpl;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.form.LecturerForm;
import com.jocata.sms.service.LectureService;

import java.util.List;

public class LectureServiceImpl implements LectureService {
    LecturerDao lecturerDao  = new LecturerDaoImpl();
    @Override
    public String createLecturer(LecturerForm lecturerForm) {

        LecturerEntity lecturerEntity = new LecturerEntity();
        lecturerEntity.setLectureName(lecturerForm.getLectureName());
        lecturerEntity.setEmail(lecturerForm.getEmail());
        lecturerEntity.setPhoneNo(lecturerForm.getlPhoneNo());
        lecturerEntity.setLectureId(lecturerForm.getId());

        return lecturerDao.createLecturer(lecturerEntity);
    }

    @Override
    public List<LecturerEntity> getAllLecturers() {
        return lecturerDao.getAllLecturers();
    }

    @Override
    public LecturerEntity getLecturerById(String id) {
        return lecturerDao.getLecturerById(id);
    }

    @Override
    public LecturerEntity getLecturerById(String name , String email) {
        return lecturerDao.getLecturerById(name , email);
    }

    @Override
    public String updateLecturer(LecturerForm lecturerForm) {
        LecturerEntity lecturerEntity = new LecturerEntity();
        lecturerEntity.setLectureName(lecturerForm.getLectureName());
        lecturerEntity.setEmail(lecturerForm.getEmail());
        lecturerEntity.setPhoneNo(lecturerForm.getlPhoneNo());
        lecturerEntity.setLectureId(lecturerForm.getId());
        return lecturerDao.updateLecturer(lecturerEntity);
    }

    @Override
    public String deleteLecturer(String id) {
        return lecturerDao.deleteLecturer(id);
    }
}
