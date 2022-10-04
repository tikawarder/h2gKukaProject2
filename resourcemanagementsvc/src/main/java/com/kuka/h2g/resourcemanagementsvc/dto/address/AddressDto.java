package com.kuka.h2g.resourcemanagementsvc.dto.address;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@Builder(setterPrefix = "with")
public class AddressDto {
    long id;
    @Size(min=4)
    String zipCode;
    String state;
    @NotBlank
    String city;
    @NotBlank
    String streetName;
    AddressTypeDto addressTypeDto;
    @NotBlank
    String number;
}

