package com.kuka.h2g.resourcemanagementsvc.dal.entities.address;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String zipCode;

    private String state;

    private String city;

    @Column (name = "street_name")
    private String streetName;

    @Column (name = "address_type")
    @Enumerated
    private AddressTypeEntity addressType;

    private String number;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customerId", nullable = false)
//    private CustomerEntity customerEntity;
}
