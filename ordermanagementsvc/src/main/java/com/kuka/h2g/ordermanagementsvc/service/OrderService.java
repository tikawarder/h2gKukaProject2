package com.kuka.h2g.ordermanagementsvc.service;

import com.kuka.h2g.ordermanagementsvc.dto.ContainerDto;
import com.kuka.h2g.ordermanagementsvc.entity.Order;
import com.kuka.h2g.ordermanagementsvc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository repository;

    public Order save(Order order){
        return repository.save(order);
    }
}
