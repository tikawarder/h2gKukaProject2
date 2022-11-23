package com.kuka.h2g.resourcemanagementsvc.controller.transformers.address;

import com.kuka.h2g.resourcemanagementsvc.dto.address.AddressTypeDto;
import com.kuka.h2g.resourcemanagementsvc.domain.address.AddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddressTypeDtoTransformer {

    @Autowired
    private Map<AddressType, AddressTypeDto> addressTypeToDtoMap;
    @Autowired
    private Map<AddressTypeDto, AddressType> dtoToAddressTypeMap;

    public AddressType transform(AddressTypeDto addressTypeDto){
        return dtoToAddressTypeMap.get(addressTypeDto);
    }

    public AddressTypeDto transform(AddressType addressType){
        return addressTypeToDtoMap.get(addressType);
    }
}
