package com.kuka.h2g.dal.transformers;

import com.kuka.h2g.dal.entities.ContainerSizeEntity;
import com.kuka.h2g.domain.ContainerSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ContainerSizeTransformer {

    @Autowired
    private Map<ContainerSize, ContainerSizeEntity> containerSizeToEntityMap;

    @Autowired
    private Map<ContainerSizeEntity, ContainerSize> containerSizeEntityToDomainMap;

    public ContainerSize transform (ContainerSizeEntity entity){
        return containerSizeEntityToDomainMap.get(entity);
    }

    public ContainerSizeEntity transform (ContainerSize domain){
        return containerSizeToEntityMap.get(domain);
    }
}
