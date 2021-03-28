package com.limyel.shutbb.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    private Response(int code) {
        this.code = code;
    }

    private Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Response(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<T>(RETCODE.SUCCESS.getCode(), RETCODE.SUCCESS.getMsg());
    }

    public static <T> Response<T> success(T data) {
        return new Response<T>(RETCODE.SUCCESS.getCode(), RETCODE.SUCCESS.getMsg(), data);
    }

    public static <T> Response<T> success(String msg, T data) {
        return new Response<T>(RETCODE.SUCCESS.getCode(), msg, data);
    }

    public static <T> Response<T> successMsg(String msg) {
        return new Response<T>(RETCODE.SUCCESS.getCode(), msg);
    }

    public static <T> Response<T> unauthorized() {
        return new Response<T>(RETCODE.UNAUTHORIZED.getCode(), RETCODE.UNAUTHORIZED.getMsg());
    }

    public static <T> Response<T> unauthorized(T data) {
        return new Response<T>(RETCODE.UNAUTHORIZED.getCode(), RETCODE.UNAUTHORIZED.getMsg(), data);
    }

    public static <T> Response<T> badRequest() {
        return new Response<T>(RETCODE.BADREQUEST.getCode(), RETCODE.BADREQUEST.getMsg());
    }

    public static <T> Response<T> badRequest(T data) {
        return new Response<T>(RETCODE.BADREQUEST.getCode(), RETCODE.BADREQUEST.getMsg(), data);
    }
}
