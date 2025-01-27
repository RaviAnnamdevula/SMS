package com.jocata.sms.controller;

import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.AdminEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.form.AdminForm;
import com.jocata.sms.service.AddressService;
import com.jocata.sms.service.impl.AddressServiceImpl;

import java.util.List;

public class AddressController {
    AddressService addressService = new AddressServiceImpl();

    //create C
    public String createAddress(AddressForm addressForm){

        return addressService.createAddress(addressForm);
    }

    //get all address R
    public List<AddressEntity> getAllAddress(){
        return addressService.getAllAddress();
    }

    //get Address by Id
    public AddressEntity getAddress(String id){
        return addressService.getAddress(id);
    }



    //update Address
    public String updateAddress(AddressForm addressForm){
        return addressService.updateAddress(addressForm);
    }

    //Delete Address
    public String deleteAddress(String id){
        return addressService.deleteAddress(id);
    }
}
