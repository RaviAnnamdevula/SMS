package com.jocata.sms.form;

import java.io.Serializable;
import java.util.List;

public class StudentForm  extends IdForm implements Serializable{
    private String name;
    private String email;
    private String sPhoneNo;
    private String dob;
    private String gender;
    private AddressForm address;
    private List<CoursesForm> courses;

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

    public AddressForm getAddress() {
        return address;
    }

    public void setAddress(AddressForm address) {
        this.address = address;
    }

    public List<CoursesForm> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesForm> courses) {
        this.courses = courses;
    }
}
