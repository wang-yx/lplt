package com.wyx.proj.util;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private static final long serialVersionUID = -6730013640494843797L;

    private int status;
    private String msg;
    private T data;

    private Response(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success(T data){
        return new Response<T>(0, null, data);
    }

    public static <T> Response<T> error(int status, String msg){
        return new Response<T>(status, msg, null);
    }

    public static <T> Response<T> error(String msg){
        return new Response<T>(-1024, msg, null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
