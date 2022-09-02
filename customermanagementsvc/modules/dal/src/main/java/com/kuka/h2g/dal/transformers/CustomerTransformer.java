package com.kuka.h2g.dal.transformers;

import com.kuka.h2g.dal.entities.customer.CustomerEntity;
import com.kuka.h2g.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer {

    @Autowired
    private AddressTransformer addressTransformer;

    public CustomerEntity transform(Customer customer){

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerId(customer.getCustomerId());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setSecondName(customer.getSecondName());
        customerEntity.setAddresses(customer.getAddresses().stream().map(addressTransformer::transform).toList());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setEmail(customer.getEmail());

        return customerEntity;
    }

    public Customer transform(CustomerEntity customerEntity){
            return Customer.builder()
                    .withCustomerId(customerEntity.getCustomerId())
                    .withFirstName(customerEntity.getFirstName())
                    .withSecondName(customerEntity.getSecondName())
                    .withAddresses(customerEntity.getAddresses().stream().map(addressTransformer::transform).toList())
                    .withPhone(customerEntity.getPhone())
                    .withEmail(customerEntity.getEmail())
                    .build();
    }

}
