package com.kuka.h2g.resourcemanagementsvc.dal.entities.customer;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.address.AddressEntity;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "customers")
@NoArgsConstructor
public class CustomerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String firstName;
    private String secondName;

//    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    @OneToMany(targetEntity = AddressEntity.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private List<AddressEntity> addresses = new ArrayList<>();
    private String phoneNumber;
    private String email;
}

////@JoinTable(name = "address",joinColumns =
//@OneToMany(targetEntity = AddressEntity.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
//@JoinColumn(name = "customerIdd",referencedColumnName = "customerId")