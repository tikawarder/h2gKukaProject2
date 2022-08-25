package com.kuka.h2g.domain.address;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Address {
    int id;
    String name;
    String zipCode;
    String state;
    String city;
    String street_name;
    AddressType addressType;
    String number;
}
