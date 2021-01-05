package com.example.threadTest;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

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
                        MysqlDataSource mysqlDataSource = new MysqlDataSource();
                        mysqlDataSource.setServerName("127.0.0.1");
                        mysqlDataSource.setPort(3306);
                        dataSource = mysqlDataSource;
                    }
                }
        }
        return dataSource.getConnection();
    }
}
