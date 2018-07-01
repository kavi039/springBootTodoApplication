package com.todo.dto;

public class ResponseDTO {
    private boolean status;
    private String statusMessage;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ResponseDTO(boolean status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }

    public ResponseDTO() {
    }
}
