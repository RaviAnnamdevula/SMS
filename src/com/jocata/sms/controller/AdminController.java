package com.jocata.sms.controller;

import com.jocata.sms.form.AdminForm;
import com.jocata.sms.service.AdminService;
import com.jocata.sms.service.impl.AdminServiceImpl;

public class AdminController {
    AdminService adminService =  new AdminServiceImpl();

    public String adminSignUp(AdminForm adminForm){
        return adminService.adminSignUp(adminForm);
    }

    public String adminSignIn(String userName , String password){
        return adminService.adminSignIn(userName  , password);
    }

}
