package com.wyx.proj.exception;

public class StatusCodeException extends RuntimeException {
    private int status = -1024;
    private String reason;

    public StatusCodeException(int status, String reason){
        this.status = status;
        this.reason = reason;
    }

    public StatusCodeException(String reason){
        this.reason = reason;
    }

    public StatusCodeException(StatusCode statusCode){
        if(statusCode != null){
            this.status = statusCode.getStatus();
            this.reason = statusCode.getReason();
        }
    }
}
