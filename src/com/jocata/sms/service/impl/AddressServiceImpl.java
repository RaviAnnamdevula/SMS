package com.jocata.sms.service.impl;

import com.jocata.sms.dao.AddressDao;
import com.jocata.sms.dao.impl.AddressDaoImpl;
import com.jocata.sms.entity.AddressEntity;
import com.jocata.sms.form.AddressForm;
import com.jocata.sms.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    AddressDao addressDao = new AddressDaoImpl();
    @Override
    public String createAddress(AddressForm addressForm) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(addressForm.getId());
        addressEntity.setArea(addressForm.getArea());
        addressEntity.setCity(addressForm.getCity());
        addressEntity.setState(addressForm.getState());
        addressEntity.setPinCode(addressForm.getPinCode());
        return addressDao.createAddress(addressEntity);
    }

    @Override
    public List<AddressEntity> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public AddressEntity getAddress(String id) {
        return addressDao.getAddress(id);
    }

    @Override
    public String updateAddress(AddressForm addressForm) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(addressForm.getId());
        addressEntity.setArea(addressForm.getArea());
        addressEntity.setCity(addressForm.getCity());
        addressEntity.setState(addressForm.getState());
        addressEntity.setPinCode(addressForm.getPinCode());
        return addressDao.updateAddress(addressEntity);
    }

    @Override
    public String deleteAddress(String id) {
        return addressDao.deleteAddress(id);
    }
}
