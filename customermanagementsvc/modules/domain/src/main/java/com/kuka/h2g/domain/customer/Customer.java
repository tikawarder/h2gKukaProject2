package com.kuka.h2g.domain.customer;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Customer {

    int customerId;
    String firstName;
    String secondName;
    String address;
    String phone;
    String email;
}
