package com.kuka.h2g.resourcemanagementsvc.controller.transformers.container.config;

import com.kuka.h2g.resourcemanagementsvc.dto.container.ContainerSizeDto;
import com.kuka.h2g.resourcemanagementsvc.domain.container.ContainerSize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ContainerSizeDtoTransformerMap {

    @Bean
    public Map<ContainerSizeDto, ContainerSize> containerSizeDtoToDomainMap(){
        return Map.ofEntries(
                Map.entry(ContainerSizeDto._5M3, ContainerSize._5M3),
                Map.entry(ContainerSizeDto._8M3, ContainerSize._8M3),
                Map.entry(ContainerSizeDto._10M3, ContainerSize._10M3)
        );
    }

    @Bean
    public Map<ContainerSize, ContainerSizeDto> containerSizeDomainToDtoMap(){
        return Map.ofEntries(
                Map.entry(ContainerSize._5M3, ContainerSizeDto._5M3),
                Map.entry(ContainerSize._8M3, ContainerSizeDto._8M3),
                Map.entry(ContainerSize._10M3, ContainerSizeDto._10M3)
        );
    }
}
