package com.jocata.sms.form;

import java.io.Serializable;

public class LecturerForm extends IdForm implements Serializable{
    private String lectureName;
    private String lPhoneNo;
    private String email;

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getlPhoneNo() {
        return lPhoneNo;
    }

    public void setlPhoneNo(String lPhoneNo) {
        this.lPhoneNo = lPhoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
