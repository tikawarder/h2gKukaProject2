package com.kuka.h2g.controller.transformers;

import com.kuka.h2g.domain.address.AddressType;
import com.kuka.h2g.dto.address.AddressTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddressTypeTransformer {

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
