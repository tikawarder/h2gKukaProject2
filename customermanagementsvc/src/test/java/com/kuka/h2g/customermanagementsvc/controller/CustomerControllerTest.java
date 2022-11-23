package com.kuka.h2g.customermanagementsvc.controller;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class CustomerControllerTest {
//    private static final String FIRST_NAME = "Kecske";
//    private static final List<AddressDto> ADDRESSES_DTO = List.of( AddressDto.builder().build());
//    private static final List<Address> ADDRESSES = List.of( Address.builder().build());
//    public static final String SECOND_NAME = "Macska";
//    public static final String PHONE = "0758987866";
//    public static final String EMAIL = "kecske@macska.com";
//
//    @Mock
//    CustomerService customerService;

    @InjectMocks
    CustomerController underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
//
//    private CustomerDto createCustomerDto(long id){
//        return CustomerDto.builder()
//                .withFirstName(FIRST_NAME)
//                .withSecondName(SECOND_NAME)
//                .withPhone(PHONE)
//                .withEmail(EMAIL)
//                .withAddresses(ADDRESSES_DTO)
//                .build();
//    }
//
//    private Customer createCustomerWithId(Long id) {
//        return Customer.builder()
//                .withCustomerId(id)
//                .withFirstName(FIRST_NAME)
//                .withSecondName(SECOND_NAME)
//                .withPhone(PHONE)
//                .withEmail(EMAIL)
//                .withAddresses(ADDRESSES)
//                .build();
//    }
//    private Customer createCustomerWithoutId() {
//        return Customer.builder()
//                .withFirstName(FIRST_NAME)
//                .withSecondName(SECOND_NAME)
//                .withPhone(PHONE)
//                .withEmail(EMAIL)
//                .withAddresses(ADDRESSES)
//                .build();
//    }
}