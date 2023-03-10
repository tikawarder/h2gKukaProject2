package com.kuka.h2g.resourcemanagementsvc.domain.address;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Address {

    long id;
    String name;
    String zipCode;
    String state;
    String city;
    String street_name;
    AddressType addressType;
    String number;
}