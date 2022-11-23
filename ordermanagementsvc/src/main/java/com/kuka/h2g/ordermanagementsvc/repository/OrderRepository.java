package com.kuka.h2g.ordermanagementsvc.repository;

import com.kuka.h2g.ordermanagementsvc.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {
}
