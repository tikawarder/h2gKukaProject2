package com.kuka.h2g.dal.transformers;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.domain.address.Address;

public class AddressTransformer {

    public Address transform(AddressEntity addressEntity){
        return Address.builder().build();
    }

    public AddressEntity transform(Address address){
        return new AddressEntity();
    }
    
}
