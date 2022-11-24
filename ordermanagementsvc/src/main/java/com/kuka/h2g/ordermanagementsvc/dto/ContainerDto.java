package com.kuka.h2g.ordermanagementsvc.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class ContainerDto {
        long id;
        ContainerSizeDto size;
}
