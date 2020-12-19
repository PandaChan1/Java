package org.example.DAO;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static final DataSource datasource;

    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("744631199");
        mysqlDataSource.setDatabaseName("blog");
        mysqlDataSource.setCharacterEncoding("utf8");
        datasource = mysqlDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }
}
