package com.limyel.shutbb.common;

public enum USERSTATUS {
    NORMAL(0, "正常"),
    INACTIVED(1, "未激活"),
    ;

    private int code;
    private String msg;

    USERSTATUS(int code, String msg) {
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
