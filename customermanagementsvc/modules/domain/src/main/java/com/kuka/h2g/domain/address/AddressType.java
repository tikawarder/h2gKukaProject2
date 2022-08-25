package com.kuka.h2g.domain.address;

public enum AddressType {
    STREET("utca"),SQUARE("tér"),ROAD("út"),PUBLIC("köz"),VINEYARD("dűlő");

    private final String value;

    AddressType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
