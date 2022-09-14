package com.kuka.h2g.dal.transformers.address.config;

import com.kuka.h2g.dal.entities.address.AddressTypeEntity;
import com.kuka.h2g.domain.address.AddressType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AddressTypeTransformerConfig {

    @Bean
    public Map<AddressTypeEntity, AddressType> addressTypeEntityToDomainMap() {
        return Map.ofEntries(
                Map.entry(AddressTypeEntity.TÉR, AddressType.SQUARE),
                Map.entry(AddressTypeEntity.ÚT, AddressType.ROAD),
                Map.entry(AddressTypeEntity.DŰLŐ, AddressType.VINEYARD),
                Map.entry(AddressTypeEntity.KÖZ, AddressType.PUBLIC),
                Map.entry(AddressTypeEntity.UTCA, AddressType.STREET)
                );
    }

    @Bean
    public Map<AddressType, AddressTypeEntity> addressTypeDomainToEntityMap() {
        return Map.ofEntries(
                Map.entry(AddressType.SQUARE, AddressTypeEntity.TÉR),
                Map.entry(AddressType.ROAD, AddressTypeEntity.ÚT),
                Map.entry(AddressType.VINEYARD, AddressTypeEntity.DŰLŐ),
                Map.entry(AddressType.PUBLIC, AddressTypeEntity.KÖZ),
                Map.entry(AddressType.STREET, AddressTypeEntity.UTCA)
                );
    }
}
