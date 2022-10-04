package com.kuka.h2g.resourcemanagementsvc.dal.entities.address;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
