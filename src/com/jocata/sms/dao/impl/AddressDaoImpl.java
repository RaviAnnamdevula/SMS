package com.jocata.sms.dao.impl;

import com.jocata.sms.dao.AddressDao;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.persistence.EntityManager;
import com.jocata.sms.persistence.impl.EntityManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    EntityManager entityManager = new EntityManagerImpl();
    @Override
    public String createAddress(AddressEntity addressEntity) {
        boolean isCreated = entityManager.save(AddressEntity.class ,addressEntity);
        if(!isCreated){
            return "Error in saving Entity";
        }
        return "Your Address is saved Successfully with ID: "+addressEntity.getAddressId();
    }

    @Override
    public List<AddressEntity> getAllAddress() {
        List<Object> objects = entityManager.get(AddressEntity.class);
        List<AddressEntity> addressEntities = new ArrayList<>();
        for (Object obj : objects){
            addressEntities.add((AddressEntity) obj);
        }
        return addressEntities;
    }

    @Override
    public AddressEntity getAddress(String id) {
        List<Object> objects = entityManager.get(AddressEntity.class);
        for (Object obj : objects){
            AddressEntity addressEntity = (AddressEntity)obj ;
            if(addressEntity.getAddressId().equals(id)){
                return addressEntity;
            }
        }
        System.out.println("Id not present");
        return null;
    }

    @Override
    public String updateAddress(AddressEntity addressEntity) {
        boolean temp = entityManager.update(AddressEntity.class, addressEntity);
        if(!temp){
            return "Enter Details Properly";
        }
        return "Successfully Updated the Address Details your Id is "+addressEntity.getAddressId();
    }

    @Override
    public String deleteAddress(String id) {
        List<Object> objects = entityManager.get(AddressEntity.class);
        for (Object obj : objects){
            AddressEntity addressEntity = (AddressEntity)obj ;
            if(addressEntity.getAddressId().equals(id)){
                entityManager.delete(AddressEntity.class ,addressEntity);
                return "Address with Id "+addressEntity.getAddressId()+" deleted From the records";
            }
        }
        return  "Id not present";
    }
}
