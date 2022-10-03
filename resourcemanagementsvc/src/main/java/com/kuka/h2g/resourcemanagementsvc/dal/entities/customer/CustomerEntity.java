package com.kuka.h2g.resourcemanagementsvc.dal.entities.customer;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.address.AddressEntity;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CustomerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    private String firstName;
    private String secondName;
    @OneToMany
    @JoinColumn(name = "address_id")
    private List<AddressEntity> addresses;
    private String phone;
    private String email;
}
