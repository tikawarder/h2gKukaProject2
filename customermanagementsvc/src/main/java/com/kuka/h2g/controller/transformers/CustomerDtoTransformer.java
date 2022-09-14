package com.kuka.h2g.controller.transformers;


import com.kuka.h2g.domain.customer.Customer;
import com.kuka.h2g.dto.customer.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoTransformer {

    @Autowired
    private AddressDtoTransformer addressDtoTransformer;
    public Customer transform(CustomerDto customerDto){
        return Customer.builder()
                .withCustomerId(customerDto.getCustomerId())
                .withFirstName(customerDto.getFirstName())
                .withSecondName(customerDto.getSecondName())
                .withAddresses(customerDto.getAddresses().stream().map(addressDtoTransformer::transform).toList())
                .withPhone(customerDto.getPhone())
                .withEmail(customerDto.getEmail())
                .build();
    }

    public CustomerDto transform(Customer customer){
        return CustomerDto.builder()
                .withCustomerId(customer.getCustomerId())
                .withFirstName(customer.getFirstName())
                .withSecondName(customer.getSecondName())
                .withAddresses(customer.getAddresses().stream().map(addressDtoTransformer::transform).toList())
                .withPhone(customer.getPhone())
                .withEmail(customer.getEmail())
                .build();
    }
}
