package com.cnfwsy.spider.core.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author zhangjh
 */
public class DruidUtil {
    private static DruidDataSource dataSource = null;


    /**
     *
     */
    static {

        InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("conf/props/jdbc_master.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            String name = prop.getProperty("name");
            String driverClassName = prop.getProperty("jdbc.master.driver");
            String url = prop.getProperty("jdbc.master.url");
            String username = prop.getProperty("jdbc.master.username");
            String password = prop.getProperty("jdbc.master.password");
//            int initialSize = Integer.parseInt(prop.getProperty("initialSize"));
//            int maxActive = Integer.parseInt(prop.getProperty("maxActive"));
//            int minIdle = Integer.parseInt(prop.getProperty("minIdle"));
//            long maxWait = Long.parseLong(prop.getProperty("maxWait"));
//            Long timeBetweenEvictionRunsMillis = Long.parseLong(prop.getProperty("timeBetweenEvictionRunsMillis"));
//            Long minEvictableIdleTimeMillis = Long.parseLong(prop.getProperty("minEvictableIdleTimeMillis"));

            dataSource = new DruidDataSource();
            dataSource.setName(name);
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
//            dataSource.setInitialSize(initialSize);
//            dataSource.setMinIdle(minIdle);
//            dataSource.setMaxActive(maxActive);
//            dataSource.setPoolPreparedStatements(false);
//            dataSource.setMaxWait(maxWait);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    /**
     * @param conn
     * @param statement
     */
    public static void release(Connection conn, Statement statement) {
        release(conn, statement, null);
    }

    /**
     * @param conn
     * @param statement
     */
    public static void release(Connection conn, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("release ResultSet err:" + e.getMessage());
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                System.out.println("release Statement err:" + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("release Connection err:" + e.getMessage());
            }
        }
    }
}
