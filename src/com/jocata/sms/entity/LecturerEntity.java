package com.jocata.sms.entity;

import java.io.Serializable;

public class LecturerEntity implements Serializable {
    private String lectureId;
    private String lectureName;
    private String lPhoneNo;
    private String email;

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getPhoneNo() {
        return lPhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.lPhoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
