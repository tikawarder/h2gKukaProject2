package com.kuka.h2g.service.customer;

import com.kuka.h2g.domain.customer.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer saveCustomer(Customer customer){
        return Customer.builder()
                       .build(); //ToDo: create connection to Resource svc
    }

    public Customer findCustomerById(long customerId){
        return Customer.builder()
                       .build(); //ToDo: create connection to Resource svc
    }

    public boolean deleteCustomerById(long customerId){
        return false;  //ToDo: create connection to Resource svc
    }
}
