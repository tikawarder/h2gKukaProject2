package com.kuka.h2g.resourcemanagementsvc.controller.container;

import com.kuka.h2g.resourcemanagementsvc.controller.transformers.container.ContainerDtoTransformer;
import com.kuka.h2g.resourcemanagementsvc.controller.transformers.container.ContainerSizeDtoTransformer;
import com.kuka.h2g.resourcemanagementsvc.domain.container.ContainerSize;
import com.kuka.h2g.resourcemanagementsvc.dto.container.ContainerDto;
import com.kuka.h2g.resourcemanagementsvc.domain.container.Container;
import com.kuka.h2g.resourcemanagementsvc.dto.container.ContainerSizeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kuka.h2g.resourcemanagementsvc.service.container.ContainerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/container")
public class ContainerController {

    @Autowired
    ContainerService service;
    @Autowired
    ContainerDtoTransformer transformer;
    @Autowired
    ContainerSizeDtoTransformer sizeTransformer;

    @GetMapping(value = "/findAll")
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

//    @GetMapping
//    public ResponseEntity<List<ContainerDto>> findBySize(@RequestParam ContainerSizeDto size){
//        log.info("Collecting Container Ids with {}", size);
//        ContainerSize containerSize = sizeTransformer.transform(size);
//        return ResponseEntity.ok(service.findIdsBySize(containerSize).stream()
//                                                              .map(transformer::transform)
//                                                              .toList());
//    }

    @PostMapping
    public ResponseEntity<ContainerDto> create (@RequestBody ContainerDto containerDto){
        Container container = service.save(transformer.transform(containerDto));
        log.info("Creating Container with id {}",container.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(transformer.transform(container));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestBody ContainerDto containerDto) {
        log.info("Deleting container: {}", containerDto);
        return ResponseEntity.ok(service.delete(transformer.transform(containerDto)));
    }

    @DeleteMapping("/{containerId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable long containerId) {
        log.info("Deleting container with id: {}", containerId);
        return ResponseEntity.ok(service.deleteById(containerId));
    }

}
