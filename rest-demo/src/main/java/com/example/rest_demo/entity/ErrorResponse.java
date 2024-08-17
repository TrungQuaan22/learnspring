package com.example.rest_demo.entity;

public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
    public ErrorResponse() {};
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

}
