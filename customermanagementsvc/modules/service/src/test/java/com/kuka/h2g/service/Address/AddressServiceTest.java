package com.kuka.h2g.service.Address;

import com.kuka.h2g.dal.dao.AddressDao;
import com.kuka.h2g.domain.address.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTest {

    public static final long ADDRESS_ID = 12L;
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
}