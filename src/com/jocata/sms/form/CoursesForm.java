package com.jocata.sms.form;

import java.io.Serializable;
import java.util.List;

public class CoursesForm extends IdForm implements Serializable{
    private String courseName;
    private String description;
    private String courseType;
    private String courseDuration;
    private List<LecturerForm> lecturers;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public List<LecturerForm> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<LecturerForm> lecturers) {
        this.lecturers = lecturers;
    }
}
