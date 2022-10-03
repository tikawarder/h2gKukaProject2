package com.kuka.h2g.resourcemanagementsvc.service.customer;

import com.kuka.h2g.resourcemanagementsvc.dal.dao.customer.CustomerDao;
import com.kuka.h2g.resourcemanagementsvc.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer saveCustomer(Customer customer){
        return customerDao.save(customer);
    }

    public Customer findCustomerById(long customerId){
        return customerDao.findById(customerId);
    }

    public List<Customer> findAllCustomers(){
        return customerDao.findAll();
    }
    public boolean deleteCustomer(Customer customer){
        return customerDao.delete(customer);
    }
    public boolean deleteCustomerById(long customerId){
        return customerDao.deleteById(customerId);
    }



}

