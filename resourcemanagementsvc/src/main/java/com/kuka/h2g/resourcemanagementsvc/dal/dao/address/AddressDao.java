package com.kuka.h2g.resourcemanagementsvc.dal.dao.address;

import com.kuka.h2g.resourcemanagementsvc.domain.address.Address;

import java.util.List;

public interface AddressDao {

    Address save(Address address);

    List<Address> findAll();

    Address findById (long id);

    List<Address> findByCity(String city);

    boolean delete(Address address);

    boolean deleteById (long id);
}

