package com.kuka.h2g.service.customer;

import com.kuka.h2g.dal.dao.customer.CustomerDao;
import com.kuka.h2g.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer createCustomer(Customer customer){
        return customerDao.save(customer);
    }

    public boolean deleteCustomer(Customer customer){
        return customerDao.delete(customer);
    }
    public boolean deleteCustomerById(long customerId){
        return customerDao.deleteById(customerId);
    }



}
