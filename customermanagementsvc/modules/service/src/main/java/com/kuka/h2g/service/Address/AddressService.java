package com.kuka.h2g.service.Address;

import com.kuka.h2g.dal.dao.AddressDao;
import com.kuka.h2g.domain.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    public Address update (Address address){
       return addressDao.save(address);
    }
}
