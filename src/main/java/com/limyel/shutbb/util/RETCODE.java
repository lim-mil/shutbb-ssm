package com.limyel.shutbb.util;

public enum RETCODE {
    SUCCESS(200),
    NOT_FOUND(404),
    ;

    private int code;
    RETCODE(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
