package com.kuka.h2g.ordermanagementsvc.controller;

import com.kuka.h2g.ordermanagementsvc.dto.ContainerSizeDto;
import com.kuka.h2g.ordermanagementsvc.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/container_size")
public class ContainerSizeController {

    @Autowired
    ContainerService service;

    public ResponseEntity<List<Long>> getContainerIdsBySize(ContainerSizeDto size){
        return ResponseEntity.ok(service.getContainerIdsBySize(size));
    }
}
