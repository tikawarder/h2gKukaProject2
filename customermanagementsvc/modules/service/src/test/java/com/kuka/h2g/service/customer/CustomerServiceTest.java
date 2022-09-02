package com.kuka.h2g.service.customer;

import com.kuka.h2g.dal.dao.customer.CustomerDao;
import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.dal.entities.customer.CustomerEntity;
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

public class CustomerServiceTest {

    private static final String FIRST_NAME = "Kecske";
    private static final List<AddressEntity> ADDRESS_ENTITIES =List.of(new AddressEntity());
    private static final List<Address> ADDRESSES = List.of( Address.builder().build());
    public static final String SECOND_NAME = "Macska";
    public static final String PHONE = "0758987866";
    public static final String EMAIL = "kecske@macska.com";

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomerShouldReturnCustomerWithId(){
        //GIVEN
        Customer customerWithId = createCustomer(1L);
        Customer customerWithoutId = createCustomer(null);

        when(customerDao.save(customerWithoutId)).thenReturn(customerWithId);

        //WHEN
        verifyNoInteractions(customerDao);

        Customer result = underTest.createCustomer(customerWithoutId);

        //THEN
        verify(customerDao).save(customerWithoutId);
        verifyNoMoreInteractions(customerDao);

        assertEquals(customerWithId,result);
    }

    private Customer createCustomer(Long id) {
        if(id == null){
            return Customer.builder()
                    .withFirstName(FIRST_NAME)
                    .withSecondName(SECOND_NAME)
                    .withPhone(PHONE)
                    .withEmail(EMAIL)
                    .withAddresses(ADDRESSES)
                    .build();
        }
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
        if(id != null){
            customerEntity.setCustomerId(id);
        }
        customerEntity.setFirstName(FIRST_NAME);
        customerEntity.setSecondName(SECOND_NAME);
        customerEntity.setPhone(PHONE);
        customerEntity.setEmail(EMAIL);
        customerEntity.setAddresses(ADDRESS_ENTITIES);
        return customerEntity;
    }


}
