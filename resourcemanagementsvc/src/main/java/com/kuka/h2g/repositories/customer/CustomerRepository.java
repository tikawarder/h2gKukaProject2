package com.kuka.h2g.repositories.customer;


import com.kuka.h2g.entities.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

}
