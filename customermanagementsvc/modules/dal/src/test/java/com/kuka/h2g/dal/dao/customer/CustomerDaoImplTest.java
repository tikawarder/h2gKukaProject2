package com.kuka.h2g.dal.dao.customer;

import com.kuka.h2g.dal.CustomerException.CustomerNotFoundException;
import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.dal.entities.customer.CustomerEntity;
import com.kuka.h2g.dal.repositories.customer.CustomerRepository;
import com.kuka.h2g.dal.transformers.CustomerTransformer;
import com.kuka.h2g.domain.address.Address;
import com.kuka.h2g.domain.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CustomerDaoImplTest {

    private static final String FIRST_NAME = "Kecske";
    private static final AddressEntity ADDRESS_ENTITY = new AddressEntity();
    private static final Address ADDRESS = Address.builder().build();
    public static final String SECOND_NAME = "Macska";
    public static final String PHONE = "0758987866";
    public static final String EMAIL = "kecske@macska.com";
    @Mock
    private CustomerTransformer customerTransformer;
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerDaoImpl underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testFindByIdShouldReturnTheInsertedCustomer() {
        //GIVEN
        int customerId = 1;
        CustomerEntity customerEntity = createCustomerEntity(1L);
        Customer customer = createCustomer(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));
        when(customerTransformer.transform(customerEntity)).thenReturn(customer);

        //WHEN
        verifyNoInteractions(customerRepository, customerTransformer);
        Customer result = underTest.findById(customerId);

        //THEN
        verify(customerRepository, times(1)).findById(1L);
        verify(customerTransformer, times(1)).transform(customerEntity);
        verifyNoMoreInteractions(customerRepository, customerTransformer);

        assertEquals(customer, result);
    }

    @Test
    void testFindByIdShouldThrowCustomerNotFoundException(){
        //GIVEN
        when(customerRepository.findById(5L)).thenReturn(Optional.empty());

        //WHEN
        assertThrows(CustomerNotFoundException.class, () -> underTest.findById(5L));

        //THEN
        verify(customerRepository).findById(5L);

    }

    @Test
    void testSaveShouldReturnSavedCustomer(){
        //GIVEN
        Customer customerWithoutId = createCustomer(null);
        CustomerEntity customerEntity= createCustomerEntity(1L);
        Customer customerWithId = createCustomer(1L);

        when(customerTransformer.transform(customerWithoutId)).thenReturn(customerEntity);
        when(customerRepository.save(customerTransformer.transform(customerWithoutId))).thenReturn(customerEntity);
        when(customerTransformer.transform(customerEntity)).thenReturn(customerWithId);

        //WHEN
        verifyNoInteractions(customerRepository);
        Customer result = underTest.save(customerWithoutId);

        //THEN
        verify(customerTransformer).transform(customerEntity);
        verify(customerTransformer,times(2)).transform(customerWithoutId);
        verify(customerRepository).save(customerTransformer.transform(customerWithoutId));


        assertEquals(customerWithId, result);
    }


    @Test
    void testfindAllShouldReturnAllCustomers(){
        //GIVEN
        List<CustomerEntity> customerEntities= new ArrayList<>();
        customerEntities.add(createCustomerEntity(1L));
        customerEntities.add(createCustomerEntity(2L));
        customerEntities.add(createCustomerEntity(3L));
        List<Customer> customers = new ArrayList<>();
        customers.add(createCustomer(1L));
        customers.add(createCustomer(2L));
        customers.add(createCustomer(3L));

        when(customerRepository.findAll()).thenReturn(customerEntities);
        when(customerTransformer.transform(customerEntities.get(0))).thenReturn(customers.get(0));
        when(customerTransformer.transform(customerEntities.get(1))).thenReturn(customers.get(1));
        when(customerTransformer.transform(customerEntities.get(2))).thenReturn(customers.get(2));

        //WHEN
        verifyNoInteractions(customerRepository,customerTransformer);
        List<Customer> results = underTest.findAll();

        //THEN
        verify(customerTransformer).transform(customerEntities.get(0));
        verify(customerTransformer).transform(customerEntities.get(1));
        verify(customerTransformer).transform(customerEntities.get(2));
        verify(customerRepository).findAll();
        verifyNoMoreInteractions(customerRepository,customerTransformer);

        assertEquals(customers, results);
    }

    @Test
    void testDeleteShouldReturnTrue(){
        //GIVEN
        Customer customerWithId = createCustomer(1L);
        CustomerEntity customerEntity = createCustomerEntity(1l);

        when(customerTransformer.transform(customerWithId)).thenReturn(customerEntity);
        //WHEN
        verifyNoInteractions(customerRepository,customerTransformer);
        Boolean result = underTest.delete(customerWithId);

        //THEN
        verify(customerTransformer).transform(customerWithId);
        verify(customerRepository).delete(customerTransformer.transform(customerWithId));

        assertEquals(true, result);
    }

    @Test
    void testDeleteByIdShouldReturnTrue(){
        //GIVEN

        //WHEN
        Boolean result = underTest.deleteById(1L);

        //THEN
        verify(customerRepository).deleteById(1L);
        assertEquals(true, result);
    }


    private Customer createCustomer(Long id) {
        if(id == null){
            return Customer.builder()
                    .withFirstName(FIRST_NAME)
                    .withSecondName(SECOND_NAME)
                    .withPhone(PHONE)
                    .withEmail(EMAIL)
                    .withAddress(ADDRESS)
                    .build();
        }
        return Customer.builder()
                .withCustomerId(id)
                .withFirstName(FIRST_NAME)
                .withSecondName(SECOND_NAME)
                .withPhone(PHONE)
                .withEmail(EMAIL)
                .withAddress(ADDRESS)
                .build();
    }

    private CustomerEntity createCustomerEntity(Long id) {
        CustomerEntity customerEntity = new CustomerEntity();
        if(id != null){
            customerEntity.setCustomerId(id);
        }
        customerEntity.setFirstName(CustomerDaoImplTest.FIRST_NAME);
        customerEntity.setSecondName(SECOND_NAME);
        customerEntity.setPhone(PHONE);
        customerEntity.setEmail(EMAIL);
        customerEntity.setAddress(ADDRESS_ENTITY);
        return customerEntity;
    }

}