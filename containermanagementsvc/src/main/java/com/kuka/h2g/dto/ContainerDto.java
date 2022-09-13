package com.kuka.h2g.dto;

import com.kuka.h2g.domain.ContainerSize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class ContainerDto {
        long id;
        ContainerSizeDto size;
}
