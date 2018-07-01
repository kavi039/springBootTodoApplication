package com.todo.dto;

public class ResponseDTO {
    private boolean status;
    private String statusMessage;

    public ResponseDTO(boolean status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }

    public ResponseDTO() {
    }
}
