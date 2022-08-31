package com.kuka.h2g.dal.entities.address;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Address_type")
@Data
public class AddressTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;

    @OneToOne (mappedBy = "address_type")
    private AddressEntity address;
}
