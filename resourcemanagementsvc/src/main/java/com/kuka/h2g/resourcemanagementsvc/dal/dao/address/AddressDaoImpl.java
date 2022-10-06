package com.kuka.h2g.resourcemanagementsvc.dal.dao.address;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.address.AddressEntity;
import com.kuka.h2g.resourcemanagementsvc.dal.repositories.address.AddressRepository;
import com.kuka.h2g.resourcemanagementsvc.dal.transformers.address.AddressTransformer;
import com.kuka.h2g.resourcemanagementsvc.dal.exceptions.NoReturnDataException;
import com.kuka.h2g.resourcemanagementsvc.domain.address.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AddressDaoImpl implements AddressDao {

    @Autowired
    AddressRepository repository;

    @Autowired
    AddressTransformer transformer;

    @Override
    public Address save(Address address) {
        AddressEntity savedEntity = repository.save(transformer.transform(address));
        log.info("Address saved to database with id: {}", savedEntity.getId());
        return transformer.transform(savedEntity);
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
        log.info("Deleting address from database with id: {}", addressEntity.getId());
        return repository.findById(addressEntity.getId()).isEmpty();
    }

    @Override
    public boolean deleteById(long id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }
}
