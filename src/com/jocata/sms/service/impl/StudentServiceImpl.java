package com.jocata.sms.service.impl;

import com.jocata.sms.dao.StudentDao;
import com.jocata.sms.dao.impl.StudentDaoImpl;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.entity.StudentEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.form.CoursesForm;
import com.jocata.sms.form.LecturerForm;
import com.jocata.sms.form.StudentForm;
import com.jocata.sms.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao =  new StudentDaoImpl();

    public String createStudent(StudentForm studentForm) {
        StudentEntity studentEntity =  new StudentEntity();
        studentEntity.setStudentId(studentForm.getId());
        studentEntity.setEmail(studentForm.getEmail());
        studentEntity.setDob(studentForm.getDob());
        studentEntity.setName(studentForm.getName());
        studentEntity.setsPhoneNo(studentForm.getsPhoneNo());
        studentEntity.setGender(studentForm.getGender());

        //copying the Address
        AddressForm addressForm = studentForm.getAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(addressForm.getId());
        addressEntity.setArea(addressForm.getArea());
        addressEntity.setCity(addressForm.getCity());
        addressEntity.setState(addressForm.getState());
        addressEntity.setPinCode(addressForm.getPinCode());

        studentEntity.setAddress(addressEntity);

        //Copy the List<Courses>
        List<CoursesForm> list = studentForm.getCourses();
        List<CoursesEntity> entities = new ArrayList<>();
        for(CoursesForm l : list){
            CoursesEntity coursesEntity = new CoursesEntity();

            coursesEntity.setCourseId(l.getId());
            coursesEntity.setCourseDuration(l.getCourseDuration());
            coursesEntity.setCourseType(l.getCourseType());
            coursesEntity.setDescription(l.getDescription());
            coursesEntity.setCourseName(l.getCourseName());

            List<LecturerForm> list2 = l.getLecturers();
            List<LecturerEntity> entities2 = new ArrayList<>();

            for(LecturerForm l2 : list2){
                LecturerEntity en = new LecturerEntity();
                en.setLectureId(l2.getId());
                en.setEmail(l2.getEmail());
                en.setPhoneNo(l2.getlPhoneNo());
                en.setLectureName(l2.getLectureName());
                entities2.add(en);
            }
            coursesEntity.setLectures(entities2);
            entities.add(coursesEntity);
        }
        //copy of whole courses obj and passing it to studentEntity
        studentEntity.setCourses(entities);

        return  studentDao.createStudent(studentEntity);
    }

    public List<StudentEntity> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public StudentEntity getStudentById(String id) {
        return studentDao.getStudentById(id);
    }

    public StudentEntity getStudentById(String name , String email) {
        return studentDao.getStudentById(name , email);
    }

    public String updateStudent(StudentForm studentForm) {
        StudentEntity studentEntity =  new StudentEntity();
        studentEntity.setStudentId(studentForm.getId());
        studentEntity.setEmail(studentForm.getEmail());
        studentEntity.setDob(studentForm.getDob());
        studentEntity.setName(studentForm.getName());
        studentEntity.setsPhoneNo(studentForm.getsPhoneNo());
        studentEntity.setGender(studentForm.getGender());

        //copying the Address
        AddressForm addressForm = studentForm.getAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(addressForm.getId());
        addressEntity.setArea(addressForm.getArea());
        addressEntity.setCity(addressForm.getCity());
        addressEntity.setState(addressForm.getState());
        addressEntity.setPinCode(addressForm.getPinCode());

        studentEntity.setAddress(addressEntity);

        //Copy the List<Courses>
        List<CoursesForm> list = studentForm.getCourses();
        List<CoursesEntity> entities = new ArrayList<>();
        for(CoursesForm l : list){
            CoursesEntity coursesEntity = new CoursesEntity();

            coursesEntity.setCourseId(l.getId());
            coursesEntity.setCourseDuration(l.getCourseDuration());
            coursesEntity.setCourseType(l.getCourseType());
            coursesEntity.setDescription(l.getDescription());
            coursesEntity.setCourseName(l.getCourseName());

            List<LecturerForm> list2 = l.getLecturers();
            List<LecturerEntity> entities2 = new ArrayList<>();

            for(LecturerForm l2 : list2){
                LecturerEntity en = new LecturerEntity();
                en.setLectureId(l2.getId());
                en.setEmail(l2.getEmail());
                en.setPhoneNo(l2.getlPhoneNo());
                en.setLectureName(l2.getLectureName());
                entities2.add(en);
            }
            coursesEntity.setLectures(entities2);
            entities.add(coursesEntity);
        }
        //copy of whole courses obj and passing it to studentEntity
        studentEntity.setCourses(entities);

        return studentDao.updateStudent(studentEntity);
    }

    public String deleteStudent(String id) {
        return studentDao.deleteStudent(id);
    }
}

