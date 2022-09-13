package com.kuka.h2g.dal.transformers;

import com.kuka.h2g.dal.entities.ContainerEntity;
import com.kuka.h2g.domain.Container;
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
