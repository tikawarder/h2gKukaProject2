package com.kuka.h2g.dto.customer;


import com.kuka.h2g.dto.address.AddressDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;


@Value
@Builder(setterPrefix = "with")
public class CustomerDto {
     long customerId;
     String firstName;
     String secondName;
     List<AddressDto> addresses;
     String phone;
     String email;
}
