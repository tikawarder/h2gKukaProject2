package com.kuka.h2g.resourcemanagementsvc.controller.address;

import com.kuka.h2g.resourcemanagementsvc.controller.transformers.address.AddressDtoTransformer;
import com.kuka.h2g.resourcemanagementsvc.domain.address.Address;
import com.kuka.h2g.resourcemanagementsvc.dto.address.AddressDto;
import com.kuka.h2g.resourcemanagementsvc.service.address.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;
    @Autowired
    private AddressDtoTransformer transformer;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<AddressDto>> findAll() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(transformer::transform)
                .toList());
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<AddressDto> findById (@RequestParam long id) {
        log.info("Searching address with ID: {}", id);
        return ResponseEntity.ok(transformer.transform(service.findById(id)));
    }

    @GetMapping(value = "/findByCity/{city}")
    public ResponseEntity<List<AddressDto>> findByCity (@RequestParam String city){
        return ResponseEntity.ok(service.findByCity(city).stream()
                .map(transformer::transform)
                .toList());
    }

    @PutMapping
    public ResponseEntity<AddressDto> update (@RequestBody AddressDto addressDto){
        Address address = service.update(transformer.transform(addressDto));
        return ResponseEntity.ok(transformer.transform(address));
    }

    @PostMapping
    public ResponseEntity<AddressDto> create (@RequestBody AddressDto addressDto){
        Address address = service.save(transformer.transform(addressDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(transformer.transform(address));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Boolean> deleteById (@PathVariable long id){
        log.info("Deleting address with ID: {}", id);
        return ResponseEntity.ok(service.deleteById(id));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete (@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(service.delete(transformer.transform(addressDto)));
    }
}
