package com.kuka.h2g.entities.address;

public enum AddressTypeEntity {
    UTCA("utca"),TÉR("tér"),ÚT("út"),KÖZ("köz"),DŰLŐ("dűlő");

    private final String value;

    AddressTypeEntity(String value) {
        this.value = value;
    }

    public String getValue() {
       return value;}
}
