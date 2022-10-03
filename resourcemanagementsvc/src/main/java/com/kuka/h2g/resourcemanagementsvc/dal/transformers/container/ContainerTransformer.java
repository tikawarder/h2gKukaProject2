package com.kuka.h2g.resourcemanagementsvc.dal.transformers.container;

import com.kuka.h2g.resourcemanagementsvc.domain.container.Container;
import com.kuka.h2g.resourcemanagementsvc.dal.entities.container.ContainerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainerTransformer {

    @Autowired
    private ContainerSizeTransformer transformer;

    public ContainerEntity transform (Container domain){
        ContainerEntity entity = new ContainerEntity();
        entity.setId(domain.getId());
        entity.setSize(transformer.transform(domain.getSize()));
        return entity;
    }

    public Container transform (ContainerEntity entity){
        return Container.builder()
                .withId(entity.getId())
                .withSize(transformer.transform(entity.getSize()))
                .build();
    }
}
