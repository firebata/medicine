package com.cnfwsy.core.api;

/**
 * 说明:定义动态数据源，实现通过集成Spring提供的AbstractRoutingDataSource，只需要实现determineCurrentLookupKey方法即可
 * 由于DynamicDataSource是单例的，线程不安全的，所以采用ThreadLocal保证线程安全，由DynamicDataSourceHolder完成。
 * Created by zhangjh on 2016-09-30.
 */
public class DynamicDataSourceHolder {

    //写库对应的数据源key
    public static final String MASTER = "master";

    //读库对应的数据源key
    public static final String SLAVE = "slave";

    //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 设置数据源key
     *
     * @param key
     */
    public static void putDataSourceKey(String key) {
        holder.set(key);
    }

    /**
     * 获取数据源key
     *
     * @return
     */
    public static String getDataSourceKey() {
        return holder.get();
    }

    /**
     * 标记写库
     */
    public static void markMaster() {
        putDataSourceKey(MASTER);
    }

    /**
     * 标记读库
     */
    public static void markSlave() {
        putDataSourceKey(SLAVE);
    }

    public static boolean isMaster() {
        return MASTER.equals(getDataSourceKey());
    }
}
