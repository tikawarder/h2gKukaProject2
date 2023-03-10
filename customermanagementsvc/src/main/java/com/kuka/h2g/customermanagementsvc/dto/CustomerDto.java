package com.kuka.h2g.customermanagementsvc.dto;



import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;


@Value
@Builder(setterPrefix = "with")
public class CustomerDto {
     long customerId;
     @NotBlank
     String firstName;
     @NotBlank
     String secondName;
     @Size(min=1)
     List<AddressDto> addresses;
     @NotBlank
     String phone;
     @Email
     String email;
}
