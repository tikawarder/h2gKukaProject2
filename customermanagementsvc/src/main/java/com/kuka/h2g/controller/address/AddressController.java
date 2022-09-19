package com.kuka.h2g.controller.address;

import com.kuka.h2g.controller.transformers.AddressDtoTransformer;
import com.kuka.h2g.domain.address.Address;
import com.kuka.h2g.dto.address.AddressDto;
import com.kuka.h2g.service.address.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;
    @Autowired
    private AddressDtoTransformer transformer;

    @GetMapping
    public ResponseEntity<AddressDto> findById (@RequestParam long id) {
        log.info("Searching address with ID: {}", id);
        return ResponseEntity.ok(transformer.transform(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<AddressDto> create (@RequestBody AddressDto addressDto){
        Address address = service.save(transformer.transform(addressDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(transformer.transform(address));
    }

    @PutMapping
    public ResponseEntity<AddressDto> update(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(transformer.transform(service.save(transformer.transform(addressDto))));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Boolean> deleteById (@PathVariable long id){
        log.info("Deleting address with ID: {}", id);
        return ResponseEntity.ok(service.deleteById(id));
    }
}