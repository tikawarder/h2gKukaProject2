package com.kuka.h2g.dal.dao;

import com.kuka.h2g.domain.address.Address;

import java.util.List;

public interface AddressDao {

    Address save(Address address);

    List<Address> findAll();

    Address findById (long id);

    List<Address> findByCity(String city);

    boolean delete(Address address);
}
