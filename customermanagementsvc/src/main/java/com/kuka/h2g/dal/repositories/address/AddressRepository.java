package com.kuka.h2g.dal.repositories.address;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {

    List<AddressEntity> findAllByCity(String city);
}
