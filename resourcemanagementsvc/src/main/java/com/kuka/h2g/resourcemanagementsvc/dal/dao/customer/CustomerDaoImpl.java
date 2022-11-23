package com.kuka.h2g.resourcemanagementsvc.dal.dao.customer;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.customer.CustomerEntity;
import com.kuka.h2g.resourcemanagementsvc.dal.repositories.customer.CustomerRepository;
import com.kuka.h2g.resourcemanagementsvc.dal.transformers.customer.CustomerTransformer;
import com.kuka.h2g.resourcemanagementsvc.dal.exceptions.NoReturnDataException;
import com.kuka.h2g.resourcemanagementsvc.domain.customer.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerTransformer customerTransformer;

    @Override
    public Customer findById(long customerId) {
        return customerTransformer.transform(customerRepository.findById(customerId).orElseThrow(NoReturnDataException::new));
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerRepository.save(customerTransformer.transform(customer));
        log.info("Saved customer with id: {}", customerEntity.getCustomerId());

        return customerTransformer.transform(customerEntity);
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        log.info("Found {} customers", customerEntityList.size());

        return customerEntityList.stream()
                .map(customerEntity -> customerTransformer.transform(customerEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Customer customer) {
        log.info("Deleting customer with id: {}",customer.getCustomerId());
        customerRepository.delete(customerTransformer.transform(customer));

        return customerRepository.findById(customer.getCustomerId()).isEmpty();
    }

    @Override
    public Boolean deleteById(long customerId) {
        log.info("Deleting customer with id: {}",customerId);
        customerRepository.deleteById(customerId);

        return customerRepository.findById(customerId).isEmpty();
    }
}

