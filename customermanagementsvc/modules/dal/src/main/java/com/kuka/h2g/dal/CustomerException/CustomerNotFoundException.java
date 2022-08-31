package com.kuka.h2g.dal.CustomerException;

import org.springframework.stereotype.Component;

@Component
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(){
        super("No customer found");
    }
}
