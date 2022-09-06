package com.kuka.h2g.dal.transformers.address;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.dal.entities.address.AddressTypeEntity;
import com.kuka.h2g.dal.transformers.address.AddressTransformer;
import com.kuka.h2g.dal.transformers.address.AddressTypeTransformer;
import com.kuka.h2g.domain.address.Address;
import com.kuka.h2g.domain.address.AddressType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressTransformerTest {

    public static final long ID = 12L;
    public static final String CITY_NAME = "Baktalórántháza";
    public static final String ZIP_CODE = "2030";
    public static final String STATE = "Hajdú-Bihar";
    public static final String STREET_NAME = "Homonnai";
    public static final String STREET_NUMBER = "11-12";

    @Mock
    AddressTypeTransformer addressTypeTransformer;

    @InjectMocks
    private AddressTransformer underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransformShouldReturnEntityFromDomain() {
        //given
        Address domain = createDomain();
        AddressEntity entity = createEntity();
        when(addressTypeTransformer.transform(domain.getAddressType())).thenReturn(entity.getAddressType());
        //when
        verifyNoInteractions(addressTypeTransformer);
        AddressEntity result = underTest.transform(domain);
        //then
        verify(addressTypeTransformer).transform(domain.getAddressType());
        verifyNoMoreInteractions(addressTypeTransformer);
        assertEquals(entity, result);
    }

    @Test
    void testTransformShouldReturnDomainFromEntity() {
        //given
        AddressEntity entity = createEntity();
        Address domain = createDomain();
        when(addressTypeTransformer.transform(entity.getAddressType())).thenReturn(domain.getAddressType());
        //when
        verifyNoInteractions(addressTypeTransformer);
        Address result = underTest.transform(entity);
        //then
        verify(addressTypeTransformer).transform(entity.getAddressType());
        verifyNoMoreInteractions(addressTypeTransformer);
        assertEquals(domain, result);
    }

    private AddressEntity createEntity(){
        AddressEntity entity = new AddressEntity();
        entity.setId(ID);
        entity.setZipCode(ZIP_CODE);
        entity.setState(STATE);
        entity.setCity(CITY_NAME);
        entity.setAddressType(AddressTypeEntity.TÉR);
        entity.setStreetName(STREET_NAME);
        entity.setNumber(STREET_NUMBER);
        return entity;
    }

    private Address createDomain(){
        return Address.builder()
                      .withId(ID)
                      .withZipCode(ZIP_CODE)
                      .withState(STATE)
                      .withCity(CITY_NAME)
                      .withAddressType(AddressType.SQUARE)
                      .withStreet_name(STREET_NAME)
                      .withNumber(STREET_NUMBER)
                .build();
    }
}
