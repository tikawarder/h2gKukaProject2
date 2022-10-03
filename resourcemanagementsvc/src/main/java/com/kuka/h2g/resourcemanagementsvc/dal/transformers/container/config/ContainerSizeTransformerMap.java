package com.kuka.h2g.resourcemanagementsvc.dal.transformers.container.config;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.container.ContainerSizeEntity;
import com.kuka.h2g.resourcemanagementsvc.domain.container.ContainerSize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ContainerSizeTransformerMap {

    @Bean
    public Map<ContainerSizeEntity, ContainerSize> containerSizeEntityToDomainMap(){
        return Map.ofEntries(
                Map.entry(ContainerSizeEntity._5M3, ContainerSize._5M3),
                Map.entry(ContainerSizeEntity._8M3, ContainerSize._8M3),
                Map.entry(ContainerSizeEntity._10M3, ContainerSize._10M3)
        );
    }

    @Bean
    public Map<ContainerSize, ContainerSizeEntity> containerSizeDomainToEntityMap(){
        return Map.ofEntries(
                Map.entry(ContainerSize._5M3, ContainerSizeEntity._5M3),
                Map.entry(ContainerSize._8M3, ContainerSizeEntity._8M3),
                Map.entry(ContainerSize._10M3, ContainerSizeEntity._10M3)
        );
    }
}
