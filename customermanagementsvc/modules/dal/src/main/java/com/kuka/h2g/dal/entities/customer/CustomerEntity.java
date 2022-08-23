package com.kuka.h2g.dal.entities.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue
    private int customerId;
    private String firstName;
    private String secondName;
    @OneToOne
    @JoinColumn(name = "address_id")
    //Todo: change String to Address type when KUKA-0004 is merged
    private String address;
    private String phone;
    private String email;
}
