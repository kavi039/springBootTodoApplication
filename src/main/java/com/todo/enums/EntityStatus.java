package com.todo.enums;

public enum EntityStatus {
    ENABLE("Enable"),
    DISABLE("Disable");

    EntityStatus(String status){
        this.status=status;
    }

    String status;



}
