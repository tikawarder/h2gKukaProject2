package com.kuka.h2g.domain.customer;

import com.kuka.h2g.domain.address.Address;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Customer {

    long customerId;
    String firstName;
    String secondName;
    Address address;
    String phone;
    String email;
}
