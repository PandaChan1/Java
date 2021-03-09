package DAO;

import exception.myexception;
import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class loginDAO {

    public static User query(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBUtil.getConnection();
            String sql = "select id, username, password, nickname, birthday, phone_number, email, head from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            //设置占位符
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            //处理结果集
            User user = null;
            while(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(username);
                user.setPassword(resultSet.getString("password"));
                //日期需要注意
                java.util.Date birthday = resultSet.getDate("birthday");
                if (birthday != null)
                    user.setBirthday(new Date(birthday.getTime()));
                user.setNickname(resultSet.getString("nickname"));
                user.setPhoneName(resultSet.getString("phone_number"));
                user.setEmail(resultSet.getString("email"));
                user.setHead(resultSet.getString("head"));
            }

            //校验
            return user;
        }catch (Exception e) {
            throw new myexception("登陆操作数据库执行错误",e,"LOG001");
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }
}
