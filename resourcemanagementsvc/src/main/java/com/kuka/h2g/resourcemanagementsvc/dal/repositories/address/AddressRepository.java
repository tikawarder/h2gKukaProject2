package com.kuka.h2g.resourcemanagementsvc.dal.repositories.address;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
    List<AddressEntity> findAllByCity(@Param("city") String city);
}
