package com.kuka.h2g.domain.customer;

import com.kuka.h2g.domain.address.Address;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(setterPrefix = "with")
public class Customer {

    long customerId;
    String firstName;
    String secondName;
    List<Address> addresses;
    String phone;
    String email;
}
