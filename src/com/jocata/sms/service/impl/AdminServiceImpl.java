package com.jocata.sms.service.impl;

import com.jocata.sms.dao.AdminDao;
import com.jocata.sms.dao.impl.AdminDaoImpl;
import com.jocata.sms.entity.AdminEntity;
import com.jocata.sms.form.AdminForm;
import com.jocata.sms.service.AdminService;

public class AdminServiceImpl implements AdminService {

    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public String adminSignUp(AdminForm adminForm) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setUserName(adminForm.getUserName());
        adminEntity.setPassword(adminForm.getPassword());
        return adminDao.adminSignUp(adminEntity);
    }

    @Override
    public String adminSignIn(String userName , String password) {
        return adminDao.adminSignIn(userName , password);
    }
}
