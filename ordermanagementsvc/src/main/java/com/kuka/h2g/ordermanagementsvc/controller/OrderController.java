package com.kuka.h2g.ordermanagementsvc.controller;

import com.kuka.h2g.ordermanagementsvc.entity.Order;
import com.kuka.h2g.ordermanagementsvc.service.OrderService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping
    public ResponseEntity<Order> create (@RequestBody Order order){
        Order savedOrder = service.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
