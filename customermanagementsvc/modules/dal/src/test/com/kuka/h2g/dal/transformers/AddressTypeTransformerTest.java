package com.kuka.h2g.dal.transformers;

import com.kuka.h2g.dal.entities.address.AddressTypeEntity;
import com.kuka.h2g.domain.address.AddressType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressTypeTransformerTest {

    public static final AddressTypeEntity ENTITY = AddressTypeEntity.DŰLŐ;
    public static final AddressType DOMAIN = AddressType.VINEYARD;

    @Mock
    private Map<AddressTypeEntity, AddressType> addressTypeEntityToDomainMap;

    @Mock
    private Map<AddressType, AddressTypeEntity> addressTypeDomainToEntityMap;

    @InjectMocks
    private AddressTypeTransformer underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testTransformShouldTransformEntityAndReturnDomainObject(){
        //Given
        when(addressTypeEntityToDomainMap.get(ENTITY)).thenReturn(DOMAIN);
        //When
        verifyNoInteractions(addressTypeDomainToEntityMap, addressTypeEntityToDomainMap);
        AddressType result = underTest.transform(ENTITY);
        //Then
        verify(addressTypeEntityToDomainMap, times(1)).get(ENTITY);
        verifyNoMoreInteractions(addressTypeDomainToEntityMap, addressTypeEntityToDomainMap);
        assertEquals(DOMAIN, result);
    }

    @Test
    public void testTransformShouldTransformDomainObjectAndReturnEntity(){
        //Given
        when(addressTypeDomainToEntityMap.get(DOMAIN)).thenReturn(ENTITY);
        //When
        verifyNoInteractions(addressTypeDomainToEntityMap, addressTypeEntityToDomainMap);
        AddressTypeEntity result = underTest.transform(DOMAIN);
        //Then
        verify(addressTypeDomainToEntityMap, times(1)).get(DOMAIN);
        verifyNoMoreInteractions(addressTypeDomainToEntityMap, addressTypeEntityToDomainMap);
        assertEquals(ENTITY, result);
    }
}
