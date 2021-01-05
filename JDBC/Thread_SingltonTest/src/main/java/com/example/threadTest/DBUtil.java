package com.example.threadTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    //单例模式
    private static  DataSource dataSource;
    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
                synchronized (DBUtil.class) {
                    if (dataSource == null) {
                        //初始化
                    }
                }
        }
        return dataSource.getConnection();
    }
}
