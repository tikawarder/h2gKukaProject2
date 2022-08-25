package com.kuka.h2g.dal.entities.address;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String zipCode;

    private String state;

    private String city;

    @Column (name = "street_name")
    private String streetName;

    @Column (name = "address_type")
    private AddressTypeEntity addressType;

    private String number;
}
