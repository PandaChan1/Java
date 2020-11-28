package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
public boolean query(String name,String password) {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    MySQLConnection mySQLConnection = new MySQLConnection();
    mySQLConnection.initConnect();
    connection= mySQLConnection.connection;
String sql  = "select username,password from userinfo where username = ? and password = ?";
    try {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        System.out.println(sql);
        resultSet = preparedStatement.executeQuery();
        //不能使用 resultSet ！= null来判断，因为只要resultSet接收到结果就不为空
        //应该判断resultSet.next，即结果集中是否有结果

        if (resultSet.next()) {
        return true;
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return false;

}
}
