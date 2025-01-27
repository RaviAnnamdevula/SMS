package com.jocata.sms.dao;

import com.jocata.sms.entity.AdminEntity;

public interface AdminDao {
    String adminSignUp(AdminEntity adminEntity);

    String adminSignIn(String userName , String password);
}
