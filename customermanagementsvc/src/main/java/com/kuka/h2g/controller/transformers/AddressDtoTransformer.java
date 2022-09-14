package com.kuka.h2g.controller.transformers;

import com.kuka.h2g.domain.address.Address;
import com.kuka.h2g.dto.address.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoTransformer {

    @Autowired
    private AddressTypeTransformer addressTypeTransformer;

    public AddressDto transform(Address address){
        return AddressDto.builder()
                .withId(address.getId())
                .withState(address.getState())
                .withZipCode(address.getZipCode())
                .withCity(address.getCity())
                .withStreetName(address.getStreet_name())
                .withAddressTypeDto(addressTypeTransformer.transform(address.getAddressType()))
                .withNumber(address.getNumber())
                .build();

    }

    public Address transform(AddressDto addressDto){
        return Address.builder()
                .withId(addressDto.getId())
                .withState(addressDto.getState())
                .withZipCode(addressDto.getZipCode())
                .withCity(addressDto.getCity())
                .withStreet_name(addressDto.getStreetName())
                .withAddressType(addressTypeTransformer.transform(addressDto.getAddressTypeDto()))
                .withNumber(addressDto.getNumber())
                .build();
    }
}
