package com.levon.cms.configuration;

/**
 * 配置上下文，线程安全
 */
public class DataSourceContextHolder {

    public static final String DEFAULT_DS = "db1";
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDB(String db) {
        contextHolder.set(db);
    }

    public static String getDB() {
        return (contextHolder.get());
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}
