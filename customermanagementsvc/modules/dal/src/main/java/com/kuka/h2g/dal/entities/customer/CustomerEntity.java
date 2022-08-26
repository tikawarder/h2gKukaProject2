package com.kuka.h2g.dal.entities.customer;

import com.kuka.h2g.domain.address.Address;
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
    private Address address;
    private String phone;
    private String email;
}
