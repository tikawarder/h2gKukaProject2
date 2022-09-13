package com.kuka.h2g.controller.transformers;

import com.kuka.h2g.dal.entities.ContainerSizeEntity;
import com.kuka.h2g.domain.ContainerSize;
import com.kuka.h2g.dto.ContainerSizeDto;
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
