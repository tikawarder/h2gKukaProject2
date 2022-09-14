package com.kuka.h2g.dal.dao.customer;

import com.kuka.h2g.domain.customer.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findById(long customerId);
    Customer save(Customer customer);
    List<Customer> findAll();
    Boolean delete(Customer customer);
    Boolean deleteById(long customerId);
}

