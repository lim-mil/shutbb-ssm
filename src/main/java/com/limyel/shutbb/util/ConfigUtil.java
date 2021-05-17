package com.limyel.shutbb.util;

import java.util.Properties;

public class ConfigUtil {
    private String jwtSecret;
    private String md5Salt;

    public ConfigUtil() {

    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public String getMd5Salt() {
        return md5Salt;
    }

    public void setMd5Salt(String md5Salt) {
        this.md5Salt = md5Salt;
    }
}
