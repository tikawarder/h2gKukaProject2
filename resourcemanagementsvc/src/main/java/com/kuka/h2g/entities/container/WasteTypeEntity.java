package com.kuka.h2g.entities.container;

public enum WasteTypeEntity {
    CONSTRUCTION_DERBIS("építési_törmelék"),HAZARDOUS_WASTE("veszélyes_hulladék"),HOUESEHOLD_WASTE("lom"),MIXED_WASTE("kevert_hulladék");

    private final String description;

    WasteTypeEntity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
