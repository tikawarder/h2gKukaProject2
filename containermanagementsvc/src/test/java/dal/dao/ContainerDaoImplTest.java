package dal.dao;

import com.kuka.h2g.dal.dao.ContainerDaoImpl;
import com.kuka.h2g.dal.entities.ContainerEntity;
import com.kuka.h2g.dal.entities.ContainerSizeEntity;
import com.kuka.h2g.dal.repositories.ContainerRepository;
import com.kuka.h2g.dal.transformers.ContainerTransformer;
import com.kuka.h2g.domain.Container;
import com.kuka.h2g.domain.ContainerSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ContainerDaoImplTest {

    private static final long CONTAINER_ID = 14L;
    private static final long CONTAINER_ID_2 = 15L;

    @Mock
    ContainerRepository repository;
    @Mock
    ContainerTransformer transformer;
    @InjectMocks
    ContainerDaoImpl underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateShouldSaveDomainAndReturnsSavedDomain(){
        //given
        Container domain = createContainer(CONTAINER_ID);
        ContainerEntity entity = createContainerEntity(CONTAINER_ID);
        ContainerEntity savedEntity = createContainerEntity(CONTAINER_ID);
        when(repository.save(entity)).thenReturn(savedEntity);
        when(transformer.transform(domain)).thenReturn(entity);
        when(transformer.transform(savedEntity)).thenReturn(domain);
        //when
        verifyNoInteractions(repository, transformer);
        Container result = underTest.create(domain);
        //then
        verify(transformer).transform(savedEntity);
        verify(transformer).transform(domain);
        verify(repository).save(entity);
        verifyNoMoreInteractions(transformer, repository);
        assertEquals(domain, result);
    }

    @Test
    void testFindAllShouldReturnsAllDomain(){
        //given
        List<Container> domains = List.of(createContainer(CONTAINER_ID), createContainer(CONTAINER_ID_2));
        List<ContainerEntity> entities = List.of(createContainerEntity(CONTAINER_ID), createContainerEntity(CONTAINER_ID_2));
        when(repository.findAll()).thenReturn(entities);
        when(transformer.transform(entities.get(0))).thenReturn(domains.get(0));
        when(transformer.transform(entities.get(1))).thenReturn(domains.get(1));
        //when
        verifyNoInteractions(repository, transformer);
        List<Container> results = underTest.findAll();
        //then
        verify(transformer).transform(entities.get(0));
        verify(transformer).transform(entities.get(1));
        verify(repository).findAll();
        verifyNoMoreInteractions(transformer, repository);
        assertEquals(domains, results);
    }

    @Test
    void testFindByIdShouldAcceptIdAndReturnsDomainWithId(){
        //given
        ContainerEntity entity = createContainerEntity(CONTAINER_ID);
        Container domain = createContainer(CONTAINER_ID);
        Optional<ContainerEntity> optionalEntity = Optional.ofNullable(entity);
        when(repository.findById(CONTAINER_ID)).thenReturn(optionalEntity);
        when(transformer.transform(entity)).thenReturn(domain);
        //when
        verifyNoInteractions(repository, transformer);
        Container result = underTest.findById(CONTAINER_ID);
        //then
        verify(repository).findById(CONTAINER_ID);
        verify(transformer).transform(entity);
        verifyNoMoreInteractions(repository, transformer);
        assertEquals(domain, result);
    }

    private ContainerEntity createContainerEntity(long id){
        ContainerEntity entity = new ContainerEntity();
        entity.setId(id);
        entity.setSize(ContainerSizeEntity._5M3);
        return entity;
    }

    private Container createContainer(long id){
        return Container.builder()
                .withId(id)
                .withSize(ContainerSize._5M3)
                .build();
    }
}