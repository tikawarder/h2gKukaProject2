package com.kuka.h2g.controller;

import com.kuka.h2g.controller.transformers.ContainerDtoTransformer;
import com.kuka.h2g.domain.Container;
import com.kuka.h2g.dto.ContainerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kuka.h2g.service.ContainerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/container")
public class ContainerController {

    @Autowired
    ContainerService service;
    @Autowired
    ContainerDtoTransformer transformer;

    @GetMapping
    public ResponseEntity<List<ContainerDto>> findAll() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(transformer::transform)
                .toList());
    }

    @GetMapping
    public ResponseEntity<ContainerDto> findById(@RequestParam long id){
        log.info("Finding Container with {}", id);
        return ResponseEntity.ok(transformer.transform(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ContainerDto> create (@RequestBody ContainerDto containerDto){
        Container container = service.save(transformer.transform(containerDto));
        log.info("Creating Container with id {}",container.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(transformer.transform(container));
    }
}
