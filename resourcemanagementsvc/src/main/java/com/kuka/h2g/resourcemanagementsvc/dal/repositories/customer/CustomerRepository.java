package com.kuka.h2g.resourcemanagementsvc.dal.repositories.customer;


import com.kuka.h2g.resourcemanagementsvc.dal.entities.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

}
