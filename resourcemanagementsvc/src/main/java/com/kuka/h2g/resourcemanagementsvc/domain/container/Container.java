package com.kuka.h2g.resourcemanagementsvc.domain.container;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Container {
    long id;
    ContainerSize size;
}
