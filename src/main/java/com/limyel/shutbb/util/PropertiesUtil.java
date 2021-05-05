package com.limyel.shutbb.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties properties;

    // 静态块的优先级高于普通块、构造方法，且只在类被加载时执行一次
    static {
        String fileName = "shutbb.properties";
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key.trim());          // 去除空格
        return value.trim();
    }

    public static String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        if ("".equals(value)) {
            return defaultValue;
        }
        return value;
    }
}
