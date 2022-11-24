package com.kuka.h2g.ordermanagementsvc.controller;

import com.kuka.h2g.ordermanagementsvc.entity.Order;
import com.kuka.h2g.ordermanagementsvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/orders")
public class DateController {

    @Autowired
    OrderService service;

    @PostMapping
    public ResponseEntity<String> postDates (@RequestBody LocalDate startDate, LocalDate endDate){
//        service.createOrderDates(startDate, endDate);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("accepted");
    }

}
