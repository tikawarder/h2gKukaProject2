package com.kuka.h2g.resourcemanagementsvc.controller.transformers.container;

import com.kuka.h2g.resourcemanagementsvc.domain.container.Container;
import com.kuka.h2g.resourcemanagementsvc.dto.container.ContainerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainerDtoTransformer {

    @Autowired
    private ContainerSizeDtoTransformer transformer;

    public ContainerDto transform (Container domain){
        return ContainerDto.builder()
                           .withId(domain.getId())
                           .withSize(transformer.transform(domain.getSize()))
                           .build();
    }

    public Container transform (ContainerDto dto){
        return Container.builder()
                .withId(dto.getId())
                .withSize(transformer.transform(dto.getSize()))
                .build();
    }
}
