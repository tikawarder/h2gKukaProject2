package com.kuka.h2g.controller.transformers;

import com.kuka.h2g.domain.Container;
import com.kuka.h2g.domain.ContainerSize;
import com.kuka.h2g.dto.ContainerDto;
import com.kuka.h2g.dto.ContainerSizeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ContainerDtoTransformerTest {

    public static final long ID = 12L;
    public static final ContainerSize CONTAINER_SIZE = ContainerSize._10M3;
    public static final ContainerSizeDto CONTAINER_SIZE_DTO = ContainerSizeDto._10M3;

    @Mock
    ContainerSizeDtoTransformer sizeTransformer;

    @InjectMocks
    ContainerDtoTransformer underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransformShouldTransformDomainToDto() {
        //given
        Container domain = createDomain(ID);
        ContainerDto dto = createDto(ID);
        when(sizeTransformer.transform(CONTAINER_SIZE)).thenReturn(CONTAINER_SIZE_DTO);
        //when
        verifyNoInteractions(sizeTransformer);
        ContainerDto result = underTest.transform(domain);
        //then
        verify(sizeTransformer).transform(CONTAINER_SIZE);
        verifyNoMoreInteractions(sizeTransformer);
        assertEquals(dto, result);
    }

    @Test
    void testTransformShouldTransformDToToDomain() {
        //given
        Container domain = createDomain(ID);
        ContainerDto dto = createDto(ID);
        when(sizeTransformer.transform(CONTAINER_SIZE_DTO)).thenReturn(CONTAINER_SIZE);
        //when
        verifyNoInteractions(sizeTransformer);
        Container result = underTest.transform(dto);
        //then
        verify(sizeTransformer).transform(CONTAINER_SIZE_DTO);
        verifyNoMoreInteractions(sizeTransformer);
        assertEquals(domain, result);
    }

    private Container createDomain (long id){
        return Container.builder()
                        .withId(id)
                        .withSize(CONTAINER_SIZE)
                        .build();
    }

    private ContainerDto createDto (long id){
        return ContainerDto.builder()
                        .withId(id)
                        .withSize(CONTAINER_SIZE_DTO)
                        .build();
    }
}