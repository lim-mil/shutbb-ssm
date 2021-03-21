package com.limyel.shutbb.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public Response() {

    }


}
