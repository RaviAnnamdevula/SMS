package com.jocata.sms.service;

import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.entity.AdminEntity;
import com.jocata.sms.form.AddressForm;

import java.util.List;

public interface AddressService {
    String createAddress(AddressForm addressForm);

    List<AddressEntity> getAllAddress();

    AddressEntity getAddress(String id);

    String updateAddress(AddressForm addressForm);

    String deleteAddress(String id);
}
