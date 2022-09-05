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

import static org.junit.jupiter.api.Assertions.*;
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
    void testSaveCustomerShouldReturnCustomerCreated(){
        //GIVEN
        Customer customerWithId = createCustomer(1L);
        Customer customerWithoutId = createCustomer(null);

        when(customerDao.save(customerWithoutId)).thenReturn(customerWithId);

        //WHEN
        verifyNoInteractions(customerDao);

        Customer result = underTest.saveCustomer(customerWithoutId);

        //THEN
        verify(customerDao).save(customerWithoutId);
        verifyNoMoreInteractions(customerDao);

        assertEquals(customerWithId,result);
    }

    @Test
    void testSaveCustomerShouldReturnCustomerUpdated(){
        //GIVEN
        Customer updateCustomer = createCustomer(1L);

        when(customerDao.save(updateCustomer)).thenReturn(updateCustomer);

        //WHEN
        verifyNoInteractions(customerDao);

        Customer result = underTest.saveCustomer(updateCustomer);

        //THEN
        verify(customerDao).save(updateCustomer);
        verifyNoMoreInteractions(customerDao);

        assertEquals(updateCustomer,result);
    }

    @Test
    void testDeleteCustomerShouldReturnTrueForSuccessfulOperation(){
        //GIVEN
        Customer customer = createCustomer(1L);

        when(customerDao.delete(customer)).thenReturn(true);

        //WHEN
        verifyNoInteractions(customerDao);

        boolean result = underTest.deleteCustomer(customer);

        //THEN
        verify(customerDao).delete(customer);
        verifyNoMoreInteractions(customerDao);

        assertTrue(result);
    }
    @Test
    void testDeleteCustomerShouldReturnFalseForUnsuccessfulOperation(){
        //GIVEN
        Customer customer = createCustomer(1L);

        when(customerDao.delete(customer)).thenReturn(false);

        //WHEN
        verifyNoInteractions(customerDao);

        boolean result = underTest.deleteCustomer(customer);

        //THEN
        verify(customerDao).delete(customer);
        verifyNoMoreInteractions(customerDao);

        assertFalse(result);
    }

    @Test
    void testDeleteCustomerByIdShouldReturnTrueForSuccessfulOperation(){
        //GIVEN
        when(customerDao.deleteById(1L)).thenReturn(true);

        //WHEN
        verifyNoInteractions(customerDao);

        boolean result = underTest.deleteCustomerById(1L);

        //THEN
        verify(customerDao).deleteById(1L);
        verifyNoMoreInteractions(customerDao);

        assertTrue(result);
    }

    @Test
    void testDeleteCustomerByIdShouldReturnFalseForUnsuccessfulOperation(){
        //GIVEN
        when(customerDao.deleteById(1L)).thenReturn(false);

        //WHEN
        verifyNoInteractions(customerDao);

        boolean result = underTest.deleteCustomerById(1L);

        //THEN
        verify(customerDao).deleteById(1L);
        verifyNoMoreInteractions(customerDao);

        assertFalse(result);
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
