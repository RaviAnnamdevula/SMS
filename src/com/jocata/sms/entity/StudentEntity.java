package com.jocata.sms.entity;

import java.io.Serializable;
import java.util.List;

public class StudentEntity implements Serializable {
    private String StudentId;
    private String name;
    private String email;
    private String sPhoneNo;
    private String dob;
    private String gender;
    private AddressEntity addressEntity;
    private List<CoursesEntity> courses;

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getsPhoneNo() {
        return sPhoneNo;
    }

    public void setsPhoneNo(String sPhoneNo) {
        this.sPhoneNo = sPhoneNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AddressEntity getAddress() {
        return addressEntity;
    }

    public void setAddress(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public List<CoursesEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesEntity> cours) {
        this.courses = cours;
    }
}
