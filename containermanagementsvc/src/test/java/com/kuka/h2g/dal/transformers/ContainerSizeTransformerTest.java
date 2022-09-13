package com.kuka.h2g.dal.transformers;

import com.kuka.h2g.dal.entities.ContainerSizeEntity;
import com.kuka.h2g.domain.ContainerSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ContainerSizeTransformerTest {

    public static final ContainerSizeEntity ENTITY = ContainerSizeEntity._10M3;
    public static final ContainerSize DOMAIN = ContainerSize._10M3;

    @Mock
    private Map<ContainerSize, ContainerSizeEntity> containerSizeToEntityMap;
    @Mock
    private Map<ContainerSizeEntity, ContainerSize> containerSizeEntityToDomainMap;
    @InjectMocks
    private ContainerSizeTransformer underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransformShouldTransformEntityToDomain(){
        //given
        when(containerSizeEntityToDomainMap.get(ENTITY)).thenReturn(DOMAIN);
        //when
        verifyNoInteractions(containerSizeEntityToDomainMap);
        ContainerSize result = underTest.transform(ENTITY);
        //then
        verify(containerSizeEntityToDomainMap).get(ENTITY);
        verifyNoMoreInteractions(containerSizeEntityToDomainMap);
        assertEquals(DOMAIN, result);
    }

    @Test
    void testTransformShouldTransformDomainToEntity(){
        //given
        when(containerSizeToEntityMap.get(DOMAIN)).thenReturn(ENTITY);
        //when
        verifyNoInteractions(containerSizeToEntityMap);
        ContainerSizeEntity result = underTest.transform(DOMAIN);
        //then
        verify(containerSizeToEntityMap).get(DOMAIN);
        verifyNoMoreInteractions(containerSizeToEntityMap);
        assertEquals(ENTITY, result);
    }
}