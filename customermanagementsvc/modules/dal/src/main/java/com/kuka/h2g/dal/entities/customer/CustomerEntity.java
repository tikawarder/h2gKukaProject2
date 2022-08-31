package com.kuka.h2g.dal.entities.customer;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import com.kuka.h2g.domain.address.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue
    private long customerId;
    private String firstName;
    private String secondName;
    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    private String phone;
    private String email;
}
