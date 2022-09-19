package com.kuka.h2g.service.address;

import com.kuka.h2g.domain.address.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    public Address save (Address address){
        return Address.builder().build(); //ToDo: create connection to Resource svc
    }

    public Address findById (long id) {
        return Address.builder().build(); //ToDo: create connection to Resource svc
    }

    public boolean deleteById (long id){
        return false; //ToDo: create connection to Resource svc
    }
}
