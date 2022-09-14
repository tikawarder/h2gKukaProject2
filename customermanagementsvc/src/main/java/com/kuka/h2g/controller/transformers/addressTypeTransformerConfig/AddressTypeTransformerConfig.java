package com.kuka.h2g.controller.transformers.addressTypeTransformerConfig;


import com.kuka.h2g.domain.address.AddressType;
import com.kuka.h2g.dto.address.AddressTypeDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AddressTypeTransformerConfig {

    @Bean
    public Map<AddressType, AddressTypeDto> domainToDtoMap() {
        return Map.ofEntries(
                Map.entry(AddressType.SQUARE, AddressTypeDto.SQUARE),
                Map.entry(AddressType.ROAD, AddressTypeDto.ROAD),
                Map.entry(AddressType.VINEYARD, AddressTypeDto.VINEYARD),
                Map.entry(AddressType.PUBLIC, AddressTypeDto.PUBLIC),
                Map.entry(AddressType.STREET, AddressTypeDto.STREET)
        );
    }

    @Bean
    public Map<AddressTypeDto, AddressType> dtoToDomainMap() {
        return Map.ofEntries(
                Map.entry(AddressTypeDto.SQUARE, AddressType.SQUARE),
                Map.entry(AddressTypeDto.ROAD, AddressType.ROAD),
                Map.entry(AddressTypeDto.VINEYARD, AddressType.VINEYARD),
                Map.entry(AddressTypeDto.PUBLIC, AddressType.PUBLIC),
                Map.entry(AddressTypeDto.STREET, AddressType.STREET)
        );
    }
}
