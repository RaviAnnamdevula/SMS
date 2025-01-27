package com.jocata.sms.initializer;

import com.jocata.sms.controller.*;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.CoursesEntity;
import com.jocata.sms.entity.LecturerEntity;
import com.jocata.sms.entity.StudentEntity;
import com.jocata.sms.form.*;

import java.util.Arrays;
import java.util.List;

public class ApplicationInitializer {
    public static void main(String[] args) {
        AdminForm adminForm1 = new AdminForm();
        adminForm1.setUserName("Ravi");
        adminForm1.setPassword("123");

        AdminForm adminForm2 = new AdminForm();
        adminForm2.setUserName("Ramana");
        adminForm2.setPassword("abc");
        System.out.println();
        AdminController adminController = new AdminController();
        System.out.println(adminController.adminSignUp(adminForm1));
        System.out.println(adminController.adminSignUp(adminForm2));
        System.out.println();
        System.out.println("Admin SignIn for Ravi");
        System.out.println(adminController.adminSignIn("Ravi" , "123"));
        System.out.println();
        System.out.println("Giving wrong password for User Name Ravi");
        System.out.println("Output:");
        System.out.println(adminController.adminSignIn("Ravi" , "abc"));
        System.out.println();
        LecturerForm lecturerForm1 = new LecturerForm();
        lecturerForm1.setLectureName("Suresh");
        lecturerForm1.setEmail("suresh@email.com");
        lecturerForm1.setlPhoneNo("99832392323");

        LecturerForm lecturerForm2 = new LecturerForm();
        lecturerForm2.setLectureName("John");
        lecturerForm2.setlPhoneNo("987654ds321");
        lecturerForm2.setEmail("john@example.com");

        LecturerForm lecturerForm3 = new LecturerForm();
        lecturerForm3.setLectureName("Negi");
        lecturerForm3.setEmail("Negi@email.com");
        lecturerForm3.setlPhoneNo("98745237452");

        LecturerForm lecturerForm4 = new LecturerForm();
        lecturerForm4.setLectureName("luffy");
        lecturerForm4.setlPhoneNo("82435234514");
        lecturerForm4.setEmail("luffy@example.com");

        LecturerController lecturerController = new LecturerController();
        System.out.println(lecturerController.createLecturer(lecturerForm1));
        System.out.println(lecturerController.createLecturer(lecturerForm2));
        System.out.println(lecturerController.createLecturer(lecturerForm3));
        System.out.println(lecturerController.createLecturer(lecturerForm4));
        System.out.println();
        LecturerEntity lecturerEntity = lecturerController.getLecturerById("ID88405");
        if(lecturerEntity != null){
            System.out.println("ID: "+lecturerEntity.getLectureId());
            System.out.println("Name: "+lecturerEntity.getLectureName());
            System.out.println("Phone No: "+lecturerEntity.getPhoneNo());
            System.out.println("Email: "+lecturerEntity.getEmail());
        }


        System.out.println();
        System.out.println();

        System.out.println("All Lecture Details");
        System.out.println("**********************************************************************************************************");
        List<LecturerEntity> list = lecturerController.getAllLecturers();
        System.out.printf("%-10s | %-20s | %-15s | %-30s%n",
                "Lecture ID", "Lecture Name", "Phone No", "Email");
        System.out.println("--------------------------------------------------------------------------------------------------");

        // Print each lecturer's details in a table format
        for (LecturerEntity l : list) {
            System.out.printf("%-10s | %-20s | %-15s | %-30s%n",
                    l.getLectureId(), l.getLectureName(), l.getPhoneNo(), l.getEmail());
            System.out.println("```````````````````````````````````````````````````````````````````````````````````````````````````");
        }
        System.out.println("**********************************************************************************************************");


        System.out.println();
        System.out.println();
        AddressForm address1 = new AddressForm();
        AddressForm address2 = new AddressForm();
        AddressForm address3 = new AddressForm();
        AddressForm address4 = new AddressForm();

        // Set data for each address
        address1.setArea("MG Road");
        address1.setState("Karnataka");
        address1.setCity("Bangalore");
        address1.setPinCode("560001L");

        address2.setArea("Marine Drive");
        address2.setState("Maharashtra");
        address2.setCity("Mumbai");
        address2.setPinCode("400001L");
        
        address4.setArea("Banjara Hills");
        address4.setState("Telangana");
        address4.setCity("Hyderabad");
        address4.setPinCode("500034L");



        AddressController addressController = new AddressController();
        /*
        System.out.println(addressController.createAddress(address1));
        System.out.println(addressController.createAddress(address2));
        System.out.println(addressController.createAddress(address3));
        System.out.println(addressController.createAddress(address4));
        */
        System.out.println();

        addressController.deleteAddress("ID88630");
        addressController.deleteAddress("ID88631");
        addressController.deleteAddress("ID88632");
        System.out.println();

        System.out.println("All Address Details");
        System.out.println("**********************************************************************************************************");
        List<AddressEntity> addressEntityList = addressController.getAllAddress();
        System.out.printf("%-10s | %-20s | %-15s | %-15s | %-10s%n", "AddressID","Area", "State", "City", "Pin Code");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (AddressEntity l : addressEntityList){
            System.out.printf("%-10s | %-20s | %-15s | %-15s | %-10s%n",
                    l.getAddressId(),
                    l.getArea(),
                    l.getState(),
                    l.getCity(),
                    l.getPinCode());
            System.out.println("```````````````````````````````````````````````````````````````````````````````````````````````````");
        }
        System.out.println("**********************************************************************************************************");

        CoursesForm coursesForm1 = new CoursesForm();
        coursesForm1.setCourseName("Java");
        coursesForm1.setCourseType("Coding");
        coursesForm1.setDescription("learn Java Backend");
        coursesForm1.setCourseDuration("72 hours");
        coursesForm1.setLecturers(List.of(lecturerForm1 ,lecturerForm2,lecturerForm4));

        CoursesForm coursesForm2 = new CoursesForm();
        coursesForm2.setCourseName("Python");
        coursesForm2.setCourseType("Coding");
        coursesForm2.setDescription("learn complete Python");
        coursesForm2.setCourseDuration("34 hours");
        coursesForm2.setLecturers(List.of(lecturerForm3 ,lecturerForm4,lecturerForm1));

        CoursesForm coursesForm3 = new CoursesForm();
        coursesForm3.setCourseName("C++");
        coursesForm3.setCourseType("Coding");
        coursesForm3.setDescription("learn Cpp A-Z");
        coursesForm3.setCourseDuration("41 hours");
        coursesForm3.setLecturers(List.of(lecturerForm4));

        CoursesForm coursesForm4 = new CoursesForm();
        coursesForm4.setCourseName("Golang");
        coursesForm4.setCourseType("Coding");
        coursesForm4.setDescription("Learn Golang");
        coursesForm4.setCourseDuration("63 hours");
        coursesForm4.setLecturers(List.of(lecturerForm1));
        System.out.println();
        CoursesController coursesController = new CoursesController();
        System.out.println(coursesController.createCourses(coursesForm1));
        System.out.println(coursesController.createCourses(coursesForm2));
        System.out.println(coursesController.createCourses(coursesForm3));
        System.out.println(coursesController.createCourses(coursesForm4));
        System.out.println();
        System.out.println();

        System.out.println("All Courses  Details");
        System.out.println("**********************************************************************************************************");
        List<CoursesEntity> courseEntityList = coursesController.getAllCourses();
        System.out.printf("%-10s | %-15s | %-10s | %-30s | %-15s | Lecturers%n",
                "CourseId","Course Name", "Type", "Description", "Duration");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (CoursesEntity course : courseEntityList) {
            System.out.printf("%-10s | %-15s | %-10s | %-30s | %-15s | ",
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getCourseType(),
                    course.getDescription(),
                    course.getCourseDuration());
            List<LecturerEntity> lecturers = course.getLectures();
            if (lecturers != null && !lecturers.isEmpty()) {
                lecturers.forEach(lecturer -> System.out.print(lecturer.getLectureName() + ", "));
            } else {
                System.out.print("No Lecturers");
            }
            System.out.println();
            System.out.println("```````````````````````````````````````````````````````````````````````````````````````````````````");
        }
        System.out.println("**********************************************************************************************************");

        StudentForm studentForm = new StudentForm();
        studentForm.setAddress(address1);
        studentForm.setCourses(List.of(coursesForm1,coursesForm2));
        studentForm.setDob("21-04-2002");
        studentForm.setName("Levi");
        studentForm.setGender("Male");
        studentForm.setsPhoneNo("72837432874");
        studentForm.setEmail("levi@gmail.com");

        StudentForm studentForm2 = new StudentForm();
        studentForm2.setAddress(address2);
        studentForm2.setCourses(List.of(coursesForm3,coursesForm4));
        studentForm2.setDob("01-05-2004");
        studentForm2.setName("Mikasa");
        studentForm2.setGender("Female");
        studentForm2.setsPhoneNo("68769769372");
        studentForm2.setEmail("mikasa@gmail.com");

        StudentForm studentForm3 = new StudentForm();
        studentForm3.setAddress(address3);
        studentForm3.setCourses(List.of(coursesForm1));
        studentForm3.setDob("12-07-2000");
        studentForm3.setName("Zoro");
        studentForm3.setGender("Male");
        studentForm3.setsPhoneNo("875923874223");
        studentForm3.setEmail("zoro@gmail.com");

        StudentForm studentForm4 = new StudentForm();
        studentForm4.setAddress(address4);
        studentForm4.setCourses(List.of(coursesForm2,coursesForm4));
        studentForm4.setDob("31-05-2003");
        studentForm4.setName("Eren");
        studentForm4.setGender("Male");
        studentForm4.setsPhoneNo("93283928323");
        studentForm4.setEmail("eren@gmail.com");
        System.out.println();
        StudentController studentController = new StudentController();
        System.out.println(studentController.createStudent(studentForm));
        System.out.println(studentController.createStudent(studentForm2));
        System.out.println(studentController.createStudent(studentForm3));
        System.out.println(studentController.createStudent(studentForm4));
        System.out.println();
        System.out.println();

        System.out.println("All Student Details");
        System.out.println("*******************************************************************************************************************************************************************************");
        List<StudentEntity> studentEntityList = studentController.getAllStudents();
        System.out.printf("%-10s | %-15s | %-25s | %-15s | %-10s | %-10s | Address                                               | Courses%n",
                "StudentId", "Name", "Email", "Phone No", "DOB", "Gender");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (StudentEntity student : studentEntityList) {
            System.out.printf("%-10s | %-15s | %-25s | %-15s | %-10s | %-10s | ",
                    student.getStudentId(),
                    student.getName(),
                    student.getEmail(),
                    student.getsPhoneNo(),
                    student.getDob(),
                    student.getGender());
            AddressEntity address = student.getAddress();
            if (address != null) {
                System.out.printf("%-15s, %-15s, %-10s, %-6s | ",
                        address.getArea(),
                        address.getCity(),
                        address.getState(),
                        address.getPinCode());
            } else {
                System.out.print("No Address            | ");
            }
            List<CoursesEntity> courses = student.getCourses();
            if (courses != null && !courses.isEmpty()) {
                courses.forEach(course -> System.out.print(course.getCourseName() + ", "));
            } else {
                System.out.print("No Courses");
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println("*************************************************************************************************************************************************************************************");
    }
}
