package com.todo.dto;

public class ResponseDTO<T> {
    private boolean status;
    private T statusMessage;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(T statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ResponseDTO(boolean status, T statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }

    public ResponseDTO() {
    }
}
