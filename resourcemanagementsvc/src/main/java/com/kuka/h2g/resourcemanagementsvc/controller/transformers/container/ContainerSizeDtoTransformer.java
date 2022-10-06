package com.kuka.h2g.resourcemanagementsvc.controller.transformers.container;


import com.kuka.h2g.resourcemanagementsvc.dto.container.ContainerSizeDto;
import com.kuka.h2g.resourcemanagementsvc.domain.container.ContainerSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ContainerSizeDtoTransformer {

    @Autowired
    private Map<ContainerSize, ContainerSizeDto> containerSizeToDtoMap;

    @Autowired
    private Map<ContainerSizeDto, ContainerSize> containerSizeDtoToDomainMap;

    public ContainerSize transform (ContainerSizeDto dto){
        return containerSizeDtoToDomainMap.get(dto);
    }

    public ContainerSizeDto transform (ContainerSize domain){
        return containerSizeToDtoMap.get(domain);
    }
}
