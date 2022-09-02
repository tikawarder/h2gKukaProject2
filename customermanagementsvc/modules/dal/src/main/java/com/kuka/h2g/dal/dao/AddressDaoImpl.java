package com.kuka.h2g.dal.dao;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.dal.exceptions.NoReturnDataException;
import com.kuka.h2g.dal.repositories.address.AddressRepository;
import com.kuka.h2g.dal.transformers.AddressTransformer;
import com.kuka.h2g.domain.address.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AddressDaoImpl implements AddressDao {

    @Autowired
    AddressRepository repository;

    @Autowired
    AddressTransformer transformer;

    @Override
    public Address save(Address address) {
        AddressEntity addressEntity = transformer.transform(address);
        repository.save(addressEntity);
        log.info("Address saved to database with id: {}", addressEntity.getId());
        return transformer.transform(addressEntity);
    }

    @Override
    public List<Address> findAll() {
        List<AddressEntity> addressEntities = repository.findAll();
        return addressEntities
                .stream()
                .map(entity -> transformer.transform(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Address findById(long id) {
        return transformer.transform(repository.findById(id).orElseThrow(NoReturnDataException::new));
    }

    @Override
    public List<Address> findByCity(String city) {
        List<AddressEntity> addressEntities = repository.findAllByCity(city);
        return addressEntities
                .stream()
                .map(entity -> transformer.transform(entity))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Address address) {
        AddressEntity addressEntity = transformer.transform(address);
        repository.delete(addressEntity);
        log.info("Address deleted from database with id: {}", addressEntity.getId());
        return repository.findById(addressEntity.getId()).isEmpty();
    }
}
