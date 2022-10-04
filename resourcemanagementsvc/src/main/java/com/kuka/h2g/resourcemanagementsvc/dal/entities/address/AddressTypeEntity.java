package com.kuka.h2g.resourcemanagementsvc.dal.entities.address;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

public enum AddressTypeEntity {
    UTCA("utca"),TÉR("tér"),ÚT("út"),KÖZ("köz"),DŰLŐ("dűlő");

    private final String value;

    AddressTypeEntity(String value) {
        this.value = value;
    }

    public String getValue() {
       return value;}
}
