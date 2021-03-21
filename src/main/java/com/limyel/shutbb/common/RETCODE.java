package com.limyel.shutbb.common;

public enum RETCODE {
    SUCCESS(200, "OK"),
    UNAUTHORIZED(401, "Unauthorized"),
    BADREQUEST(400, "Bad Request"),
    ;

    private int code;
    private String msg;

    RETCODE(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
