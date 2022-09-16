package com.kuka.h2g.repositories.address;

import com.kuka.h2g.entities.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {

    List<AddressEntity> findAllByCity(String city);
}
