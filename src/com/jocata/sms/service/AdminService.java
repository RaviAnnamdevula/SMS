package com.jocata.sms.service;

import com.jocata.sms.form.AdminForm;

public interface AdminService {
    String adminSignUp(AdminForm adminForm);

    String adminSignIn(String userName , String password);
}


