package com.kuka.h2g.ordermanagementsvc.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long containerId;

    LocalDate startDate;

    LocalDate endDate;

    long customerId;

    long wasteTypeId;

    int totalPrice;
}
