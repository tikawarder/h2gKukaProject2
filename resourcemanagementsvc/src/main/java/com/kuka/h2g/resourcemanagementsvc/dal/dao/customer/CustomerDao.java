package com.kuka.h2g.resourcemanagementsvc.dal.dao.customer;

import com.kuka.h2g.resourcemanagementsvc.domain.customer.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findById(long customerId);
    Customer save(Customer customer);
    List<Customer> findAll();
    Boolean delete(Customer customer);
    Boolean deleteById(long customerId);
}
