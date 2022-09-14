package com.kuka.h2g.dal.entities.customer;

import com.kuka.h2g.dal.entities.address.AddressEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue
    private long customerId;
    private String firstName;
    private String secondName;
    @OneToMany
    @JoinColumn(name = "address_id")
    private List<AddressEntity> addresses;
    private String phone;
    private String email;
}
