package com.kuka.h2g.controller.customer;

import com.kuka.h2g.controller.transformers.CustomerDtoTransformer;
import com.kuka.h2g.dto.customer.CustomerDto;
import com.kuka.h2g.service.customer.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDtoTransformer customerDtoTransformer;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto newCustomer) {
        log.info("Create customer");
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDtoTransformer.transform(customerService.saveCustomer(customerDtoTransformer.transform(newCustomer))));
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto updateCustomer) {
        log.info("Update customer: ");
        return ResponseEntity.ok(customerDtoTransformer.transform(customerService.saveCustomer(customerDtoTransformer.transform(updateCustomer))));
    }

    @GetMapping
    public ResponseEntity<CustomerDto> findCustomerById(@RequestParam long customerId) {
        log.info("Searching for customer with ID:{}", customerId);
        return ResponseEntity.ok(customerDtoTransformer.transform(customerService.findCustomerById(customerId)));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable long customerId) {
        log.info("Delete customer with id: {}", customerId);
        return ResponseEntity.ok(customerService.deleteCustomerById(customerId));
    }

}
