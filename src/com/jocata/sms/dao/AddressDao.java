package com.jocata.sms.dao;

import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.form.AddressForm;

import java.util.List;

public interface AddressDao {

    String createAddress(AddressEntity addressEntity);

    List<AddressEntity> getAllAddress();

    AddressEntity getAddress(String id);

    String updateAddress(AddressEntity addressEntity);

    String deleteAddress(String id);
}
