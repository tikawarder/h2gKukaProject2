package com.kuka.h2g.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Container {
    long id;
    ContainerSize size;
}
