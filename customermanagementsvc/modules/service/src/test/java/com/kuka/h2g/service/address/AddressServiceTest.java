package com.kuka.h2g.service.address;

import com.kuka.h2g.dal.dao.address.AddressDao;
import com.kuka.h2g.domain.address.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressServiceTest {

    public static final long ADDRESS_ID = 12L;
    public static final long ADDRESS_ID_2 = 13L;
    public static final String CITY = "Karakószörcsög";

    @Mock
    AddressDao addressDao;

    @InjectMocks
    AddressService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateShouldSaveAddressWithAddressDaoAndReturnsSavedAddress() {
        //given
        Address address = Address.builder().build();
        Address savedAddress = Address.builder().withId(ADDRESS_ID).build();
        when(addressDao.save(address)).thenReturn(savedAddress);
        //when
        verifyNoInteractions(addressDao);
        Address result = underTest.update(address);
        //then
        verify(addressDao).save(address);
        verifyNoMoreInteractions(addressDao);
        assertEquals(savedAddress, result);
    }

    @Test
    void testSaveShouldSaveAddressWithAddressDaoAndReturnsSavedAddress() {
        //given
        Address address = Address.builder().build();
        Address savedAddress = Address.builder().withId(ADDRESS_ID).build();
        when(addressDao.save(address)).thenReturn(savedAddress);
        //when
        verifyNoInteractions(addressDao);
        Address result = underTest.save(address);
        //then
        verify(addressDao).save(address);
        verifyNoMoreInteractions(addressDao);
        assertEquals(savedAddress, result);
    }

    @Test
    void testFindByIdShouldAcceptIdAndReturnsSavedAddress(){
        //given
        long id = ADDRESS_ID;
        Address savedAddress = Address.builder().withId(ADDRESS_ID).build();
        when(addressDao.findById(id)).thenReturn(savedAddress);
        //when
        verifyNoInteractions(addressDao);
        Address result = underTest.findById(id);
        //then
        verify(addressDao).findById(id);
        verifyNoMoreInteractions(addressDao);
        assertEquals(savedAddress, result);
    }

    @Test
    void testFindAllShouldReturnAllSavedAddress(){
        //given
        Address savedAddress1 = Address.builder().withId(ADDRESS_ID).build();
        Address savedAddress2 = Address.builder().withId(ADDRESS_ID_2).build();
        List<Address> savedAddresses = List.of(savedAddress1, savedAddress2);
        when(addressDao.findAll()).thenReturn(savedAddresses);
        //when
        verifyNoInteractions(addressDao);
        List<Address> results = underTest.findAll();
        //then
        verify(addressDao).findAll();
        verifyNoMoreInteractions(addressDao);
        assertEquals(savedAddresses, results);
    }

    @Test
    void testDeleteShouldDeleteAddressAndReturnsTrueWhenSuccess(){
        //given
        Address address = Address.builder().withId(ADDRESS_ID).build();
        when(addressDao.delete(address)).thenReturn(true);
        //when
        verifyNoInteractions(addressDao);
        boolean result = underTest.delete(address);
        //then
        verify(addressDao).delete(address);
        verifyNoMoreInteractions(addressDao);
        assertTrue(result);
    }

    @Test
    void testDeleteByIdShouldAcceptIdAndDeleteAddressByIdAndReturnsTrueWhenSuccess(){
        //given
        when(addressDao.deleteById(ADDRESS_ID)).thenReturn(true);
        //when
        verifyNoInteractions(addressDao);
        boolean result = underTest.deleteById(ADDRESS_ID);
        //then
        verify(addressDao).deleteById(ADDRESS_ID);
        verifyNoMoreInteractions(addressDao);
        assertTrue(result);
    }

    @Test
    void testFindByCityShouldAcceptStringInputAndReturnsAddressesWhichCitiesMatch(){
        //given
        Address savedAddress1 = Address.builder().withId(ADDRESS_ID).build();
        Address savedAddress2 = Address.builder().withId(ADDRESS_ID_2).build();
        List<Address> savedAddresses = List.of(savedAddress1, savedAddress2);
        when(addressDao.findByCity(CITY)).thenReturn(savedAddresses);
        //when
        verifyNoInteractions(addressDao);
        List<Address> results = underTest.findByCity(CITY);
        //then
        verify(addressDao).findByCity(CITY);
        verifyNoMoreInteractions(addressDao);
        assertEquals(savedAddresses, results);
    }
}