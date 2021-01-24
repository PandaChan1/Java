package org.example;

import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqliteDemo {
    public static void main(String[] args) throws SQLException {
        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl("jdbc:sqlite://E:/博客/test.db");   //只需要填入正确路径即可
        DataSource dataSource = sqLiteDataSource;
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement("create table testdb(id int)");   //执行sql
        ps.executeUpdate();
        connection.close();
    }
}
