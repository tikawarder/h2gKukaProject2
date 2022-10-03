package com.kuka.h2g.resourcemanagementsvc.controller.transformers.address;

import com.kuka.h2g.resourcemanagementsvc.domain.address.Address;
import com.kuka.h2g.resourcemanagementsvc.dto.address.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoTransformer {

    @Autowired
    private AddressTypeDtoTransformer addressTypeDtoTransformer;

    public AddressDto transform(Address address){
        return AddressDto.builder()
                .withId(address.getId())
                .withState(address.getState())
                .withZipCode(address.getZipCode())
                .withCity(address.getCity())
                .withStreetName(address.getStreet_name())
                .withAddressTypeDto(addressTypeDtoTransformer.transform(address.getAddressType()))
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
                .withAddressType(addressTypeDtoTransformer.transform(addressDto.getAddressTypeDto()))
                .withNumber(addressDto.getNumber())
                .build();
    }
}
