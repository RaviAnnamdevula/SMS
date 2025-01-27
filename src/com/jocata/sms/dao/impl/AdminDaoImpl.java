package com.jocata.sms.dao.impl;

import com.jocata.sms.dao.AdminDao;
import com.jocata.sms.database.FileSystem;
import com.jocata.sms.entity.AdminEntity;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.impl.EntityManagerImpl;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    EntityManager entityManager = new EntityManagerImpl();
    @Override
    public String adminSignUp(AdminEntity adminEntity) {
       boolean isCreated =  entityManager.save(AdminEntity.class , adminEntity);
       if(!isCreated){
           return "Failed to create the Admin Account";
       }
        return "Admin Account Created, your User name is: "+ adminEntity.getUserName();
    }

    @Override
    public String adminSignIn(String userName , String password) {
        List<Object> loginDetails = entityManager.get(AdminEntity.class);
        for(Object object : loginDetails) {
            AdminEntity data = (AdminEntity) object;
            if(userName.equalsIgnoreCase(data.getUserName())
                    && password.equalsIgnoreCase(data.getPassword())) {
                return "successfully loggedIn for " + data.getUserName();
            }
        }
        return "Invalid Credentials";
    }
}
