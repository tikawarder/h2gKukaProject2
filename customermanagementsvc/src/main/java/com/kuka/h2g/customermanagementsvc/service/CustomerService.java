package com.kuka.h2g.customermanagementsvc.service;

import com.kuka.h2g.customermanagementsvc.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private final String RESOURCE_SVC_URL = "http://localhost:8082/customer";
    @Autowired
    RestTemplate restTemplate;

    public CustomerDto saveCustomer(CustomerDto customer){
        HttpEntity<CustomerDto> request = new HttpEntity<>(customer);
        return restTemplate.postForObject(RESOURCE_SVC_URL,customer,CustomerDto.class);
    }

    public CustomerDto findCustomerById(long customerId){
        return restTemplate.getForObject(RESOURCE_SVC_URL+"?customerId="+customerId,CustomerDto.class);
    }

    public boolean deleteCustomerById(long customerId){
        try{
            restTemplate.delete(RESOURCE_SVC_URL+"/"+customerId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
