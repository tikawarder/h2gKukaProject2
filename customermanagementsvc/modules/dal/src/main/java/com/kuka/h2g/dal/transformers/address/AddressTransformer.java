package com.kuka.h2g.dal.transformers.address;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.domain.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressTransformer {

    @Autowired
    private AddressTypeTransformer addressTypeTransformer;

    public Address transform (AddressEntity entity){
        return Address.builder()
                .withId(entity.getId())
                .withZipCode(entity.getZipCode())
                .withState(entity.getState())
                .withCity(entity.getCity())
                .withStreet_name(entity.getStreetName())
                .withAddressType(addressTypeTransformer.transform(entity.getAddressType()))
                .withNumber(entity.getNumber())
                .build();
    }

    public AddressEntity transform (Address domain){
        AddressEntity entity = new AddressEntity();
        entity.setId(domain.getId());
        entity.setZipCode(domain.getZipCode());
        entity.setState(domain.getState());
        entity.setCity(domain.getCity());
        entity.setStreetName(domain.getStreet_name());
        entity.setAddressType(addressTypeTransformer.transform(domain.getAddressType()));
        entity.setNumber(domain.getNumber());
        return entity;
    }
}
