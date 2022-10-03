package com.kuka.h2g.resourcemanagementsvc.dal.entities.container;

public enum ContainerSizeEntity {
    _5M3("5m3"),_8M3("8m3"),_10M3("10m3");

    private final String size;

    ContainerSizeEntity(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
