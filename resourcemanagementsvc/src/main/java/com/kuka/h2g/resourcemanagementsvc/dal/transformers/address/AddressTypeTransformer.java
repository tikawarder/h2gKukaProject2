package com.kuka.h2g.resourcemanagementsvc.dal.transformers.address;



import com.kuka.h2g.resourcemanagementsvc.dal.entities.address.AddressTypeEntity;
import com.kuka.h2g.resourcemanagementsvc.domain.address.AddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddressTypeTransformer {

    @Autowired
    private Map<AddressTypeEntity, AddressType> addressTypeEntityToDomainMap;
    @Autowired
    private Map<AddressType, AddressTypeEntity> addressTypeDomainToEntityMap;

    public AddressType transform (AddressTypeEntity entity){
        return addressTypeEntityToDomainMap.get(entity);
    }

    public AddressTypeEntity transform (AddressType addressType){
        return addressTypeDomainToEntityMap.get(addressType);
    }
}
