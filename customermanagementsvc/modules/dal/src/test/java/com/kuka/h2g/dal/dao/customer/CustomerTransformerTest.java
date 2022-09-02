package com.kuka.h2g.dal.dao.customer;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.dal.entities.customer.CustomerEntity;
import com.kuka.h2g.dal.transformers.AddressTransformer;
import com.kuka.h2g.dal.transformers.CustomerTransformer;
import com.kuka.h2g.domain.address.Address;
import com.kuka.h2g.domain.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerTransformerTest {

    private static final String FIRST_NAME = "Kecske";
    private static final List<AddressEntity> ADDRESS_ENTITIES =List.of(new AddressEntity());
    private static final List<Address> ADDRESSES = List.of( Address.builder().build());
    public static final String SECOND_NAME = "Macska";
    public static final String PHONE = "0758987866";
    public static final String EMAIL = "kecske@macska.com";

    @Mock
    private AddressTransformer addressTransformer;

    @InjectMocks
    private CustomerTransformer underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransfromShouldReturnCustomerEntity(){
        //GIVEN
        Customer customer = createCustomer(1L);

        when(addressTransformer.transform(Address.builder().build())).thenReturn(new AddressEntity());

        //WHEN
        verifyNoInteractions(addressTransformer);

        CustomerEntity result = underTest.transform(customer);

        //THEN
        verify(addressTransformer).transform(Address.builder().build());
        verifyNoMoreInteractions(addressTransformer);

        assertEquals(createCustomerEntity(1L), result);
    }

    @Test
    void testTransfromShouldReturnCustomer(){
        //GIVEN
        CustomerEntity customerEntity = createCustomerEntity(1L);

        when(addressTransformer.transform(new AddressEntity())).thenReturn(Address.builder().build());

        //WHEN
        verifyNoInteractions(addressTransformer);

        Customer result = underTest.transform(customerEntity);

        //THEN
        verify(addressTransformer).transform(new AddressEntity());
        verifyNoMoreInteractions(addressTransformer);

        assertEquals(createCustomer(1L), result);
    }

    private Customer createCustomer(Long id) {
        return Customer.builder()
                .withCustomerId(id)
                .withFirstName(FIRST_NAME)
                .withSecondName(SECOND_NAME)
                .withPhone(PHONE)
                .withEmail(EMAIL)
                .withAddresses(ADDRESSES)
                .build();
    }

    private CustomerEntity createCustomerEntity(Long id) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerId(id);
        customerEntity.setFirstName(FIRST_NAME);
        customerEntity.setSecondName(SECOND_NAME);
        customerEntity.setPhone(PHONE);
        customerEntity.setEmail(EMAIL);
        customerEntity.setAddresses(ADDRESS_ENTITIES);
        return customerEntity;
    }

}