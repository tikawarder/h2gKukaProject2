package com.kuka.h2g.dal.transformers;

import com.kuka.h2g.dal.entities.ContainerEntity;
import com.kuka.h2g.dal.entities.ContainerSizeEntity;
import com.kuka.h2g.domain.Container;
import com.kuka.h2g.domain.ContainerSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class ContainerTransformerTest {

    public static final long ID = 12L;
    public static final ContainerSize CONTAINER_SIZE = ContainerSize._10M3;
    public static final ContainerSizeEntity CONTAINER_ENTITY_SIZE = ContainerSizeEntity._10M3;

    @Mock
    ContainerSizeTransformer sizeTransformer;

    @InjectMocks
    ContainerTransformer underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransformShouldTransformDomainToEntity() {
        //given
        Container domain = createDomain(ID);
        ContainerEntity entity = createDto(ID);
        when(sizeTransformer.transform(CONTAINER_SIZE)).thenReturn(CONTAINER_ENTITY_SIZE);
        //when
        verifyNoInteractions(sizeTransformer);
        ContainerEntity result = underTest.transform(domain);
        //then
        verify(sizeTransformer).transform(CONTAINER_SIZE);
        verifyNoMoreInteractions(sizeTransformer);
        assertEquals(entity, result);
    }

    @Test
    void testTransformShouldTransformEntityToDomain() {
        //given
        Container domain = createDomain(ID);
        ContainerEntity entity = createDto(ID);
        when(sizeTransformer.transform(CONTAINER_ENTITY_SIZE)).thenReturn(CONTAINER_SIZE);
        //when
        verifyNoInteractions(sizeTransformer);
        Container result = underTest.transform(entity);
        //then
        verify(sizeTransformer).transform(CONTAINER_ENTITY_SIZE);
        verifyNoMoreInteractions(sizeTransformer);
        assertEquals(domain, result);
    }

    private Container createDomain (long id){
        return Container.builder()
                        .withId(id)
                        .withSize(CONTAINER_SIZE)
                        .build();
    }

    private ContainerEntity createDto (long id){
        ContainerEntity entity = new ContainerEntity();
        entity.setId(id);
        entity.setSize(ContainerSizeEntity._10M3);
        return entity;
    }
}