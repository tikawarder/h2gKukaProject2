package com.kuka.h2g.dal.dao;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.dal.entities.address.AddressTypeEntity;
import com.kuka.h2g.dal.exceptions.NoReturnDataException;
import com.kuka.h2g.dal.repositories.address.AddressRepository;
import com.kuka.h2g.dal.transformers.AddressTransformer;
import com.kuka.h2g.domain.address.Address;
import com.kuka.h2g.domain.address.AddressType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressDaoImplTest {

    public static final long ADDRESS_ID = 12L;
    public static final long ID_FOR_1ST_ADDRESS_IN_LIST = 1L;
    public static final long ID_FOR_2ND_ADDRESS_IN_LIST = 2L;
    public static final String CITY_NAME = "Baktalórántháza";
    public static final String ZIP_CODE = "2030";
    public static final String STATE = "Hajdú-Bihar";
    public static final String STREET_NAME = "Homonnai";
    public static final String STREET_NUMBER = "11-12";

    @Mock
    AddressRepository repository;
    @Mock
    AddressTransformer transformer;

    @InjectMocks
    AddressDaoImpl underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveShouldSaveDomainAsEntity(){
        //given
        Address domain = createDomain(ADDRESS_ID);
        AddressEntity entity = createEntity(ADDRESS_ID);
        when(transformer.transform(domain)).thenReturn(entity);
        when(transformer.transform(entity)).thenReturn(domain);
        //when
        verifyNoInteractions(transformer, repository);
        Address result = underTest.save(domain);
        //then
        verify(transformer).transform(domain);
        verify(repository).save(entity);
        verify(transformer).transform(entity);
        verifyNoMoreInteractions(transformer, repository);
        assertEquals(domain, result);
    }

    @Test
    void testFindAllShouldReturnsAllDomain(){
        //given
        List<Address> domains = createDomainList();
        List<AddressEntity> entities = createEntityList();
        when(repository.findAll()).thenReturn(entities);
        when(transformer.transform(entities.get(0))).thenReturn(domains.get(0));
        when(transformer.transform(entities.get(1))).thenReturn(domains.get(1));
        //when
        verifyNoInteractions(repository, transformer);
        List<Address> results = underTest.findAll();
        //then
        verify(repository).findAll();
        verify(transformer).transform(entities.get(0));
        verify(transformer).transform(entities.get(1));
        verifyNoMoreInteractions(repository, transformer);
        assertEquals(domains, results);
    }

    @Test
    void testFindAllByCityShouldReturnListOfDomainsWhichHasThisCity(){
        //given
        List<Address> domains = createDomainList();
        List<AddressEntity> entities = createEntityList();
        when(repository.findAllByCity(CITY_NAME)).thenReturn(entities);
        when(transformer.transform(entities.get(0))).thenReturn(domains.get(0));
        when(transformer.transform(entities.get(1))).thenReturn(domains.get(1));
        //when
        verifyNoInteractions(repository, transformer);
        List<Address> results = underTest.findByCity(CITY_NAME);
        //then
        verify(repository).findAllByCity(CITY_NAME);
        verify(transformer).transform(entities.get(0));
        verify(transformer).transform(entities.get(1));
        verifyNoMoreInteractions(repository, transformer);
        assertEquals(domains, results);
    }

    @Test
    void testDeleteShouldDeleteDomainAsEntityAndReturnsTrueWhenFindByIdFoundOptionalNull(){
        //given
        Address domain = createDomain(ADDRESS_ID);
        AddressEntity entity = createEntity(ADDRESS_ID);
        Optional<AddressEntity> optionalEmpty = Optional.empty();
        when(transformer.transform(domain)).thenReturn(entity);
        when(repository.findById(domain.getId())).thenReturn(optionalEmpty);
        //when
        verifyNoInteractions(transformer, repository);
        boolean result = underTest.delete(domain);
        //then
        verify(transformer).transform(domain);
        verify(repository).delete(entity);
        verify(repository).findById(entity.getId());
        assertTrue(result);
    }

    @Test
    void testDeleteShouldDeleteDomainAsEntityAndReturnsFalseWhenFindByIdFoundThis(){
        //given
        Address domain = createDomain(ADDRESS_ID);
        AddressEntity entity = createEntity(ADDRESS_ID);
        Optional<AddressEntity> optionalEntity = Optional.ofNullable(entity);
        when(transformer.transform(domain)).thenReturn(entity);
        when(repository.findById(domain.getId())).thenReturn(optionalEntity);
        //when
        verifyNoInteractions(transformer, repository);
        boolean result = underTest.delete(domain);
        //then
        verify(transformer).transform(domain);
        verify(repository).delete(entity);
        verify(repository).findById(entity.getId());
        assertFalse(result);
    }

    @Test
    void testFindByIdShouldReturnsDomainById(){
        //given
        Address domain = createDomain(ADDRESS_ID);
        AddressEntity entity = createEntity(ADDRESS_ID);
        Optional<AddressEntity> optionalEntity = Optional.ofNullable(entity);
        when(repository.findById(ADDRESS_ID)).thenReturn(optionalEntity);
        when(transformer.transform(entity)).thenReturn(domain);
        //when
        verifyNoInteractions(repository, transformer);
        Address result = underTest.findById(ADDRESS_ID);
        //then
        verify(repository).findById(ADDRESS_ID);
        verify(transformer).transform(entity);
        verifyNoMoreInteractions(repository, transformer);
        assertEquals(domain, result);
    }

    @Test
    void testFindByIdShouldRaisedExceptionWhenNullFoundById() {
        //given
        Optional<AddressEntity> optionalEmpty = Optional.empty();
        when(repository.findById(ADDRESS_ID)).thenReturn(optionalEmpty);
        //when
        verifyNoInteractions(repository, transformer);
        //then
        assertThrows(NoReturnDataException.class, () ->
            underTest.findById(ADDRESS_ID));
        verify(repository).findById(ADDRESS_ID);
        verifyNoMoreInteractions(repository, transformer);
    }

    private AddressEntity createEntity(long id){
        AddressEntity entity = new AddressEntity();
        entity.setId(id);
        entity.setZipCode(ZIP_CODE);
        entity.setState(STATE);
        entity.setCity(CITY_NAME);
        entity.setAddressType(AddressTypeEntity.TÉR);
        entity.setStreetName(STREET_NAME);
        entity.setNumber(STREET_NUMBER);
        return entity;
    }

    private Address createDomain(long id){
        return Address.builder()
                      .withId(id)
                      .withZipCode(ZIP_CODE)
                      .withState(STATE)
                      .withCity(CITY_NAME)
                      .withAddressType(AddressType.SQUARE)
                      .withStreet_name(STREET_NAME)
                      .withNumber(STREET_NUMBER)
                      .build();
    }

    private List<Address> createDomainList(){
        return List.of(createDomain(ID_FOR_1ST_ADDRESS_IN_LIST), createDomain(ID_FOR_2ND_ADDRESS_IN_LIST));
    }

    private List<AddressEntity> createEntityList(){
        return List.of(createEntity(ID_FOR_1ST_ADDRESS_IN_LIST), createEntity(ID_FOR_2ND_ADDRESS_IN_LIST));
    }
}
