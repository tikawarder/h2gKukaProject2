package com.kuka.h2g.resourcemanagementsvc.dto.container;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class ContainerDto {
        long id;
        ContainerSizeDto size;
}
