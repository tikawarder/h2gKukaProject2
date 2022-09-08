package com.kuka.h2g.dto.address;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class AddressDto {
    private long id;
    private String zipCode;
    private String state;
    private String city;
    private String streetName;
    private AddressTypeDto addressTypeDto;
    private String number;
}
