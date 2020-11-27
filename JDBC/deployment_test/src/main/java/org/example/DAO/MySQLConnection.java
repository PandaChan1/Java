package org.example.DAO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class MySQLConnection {
Connection connection = null;

public void initConnect() {
    try {
        Class.forName("com.mysql.jdbc.Driver");

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://localhost:3306/usertest?user=root&password=744631199&useSSL=false&userUnicode=true&characterEncoding=UTF-8");
        connection =dataSource.getConnection();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
