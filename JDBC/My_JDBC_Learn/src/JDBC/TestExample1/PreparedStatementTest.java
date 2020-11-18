package JDBC.TestExample1;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class PreparedStatementTest {
    public static void main(String[] args)  {
        query("%学%");

    }

    public static void query(String s) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //加载驱动程序，反射，这样调用  com.mysql.jdbc.Driver  类，即将类加载
            Class.forName("com.mysql.jdbc.Driver");
            //第一步，创建数据库连接
            //使用DataSource
            DataSource dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://localhost:3306/learn?user=root&password=744631199&useSSL=false" +
                    "&userUnicode=true&characterEncoding=UTF-8");
            connection = dataSource.getConnection();

            System.out.println(connection);
            String sql = "select id ,sn ,name ,qq_mail from  student where name like ?";
            //第二步，创建了操作命令对象
            statement = connection.prepareStatement(sql);

            statement.setString(1,s);

            System.out.println(sql);

            resultSet = statement.executeQuery();

            //处理结果集
            while (resultSet.next()) {
                int stu_id = resultSet.getInt("id");
                int stu_sn = resultSet.getInt("sn");
                String stu_name = resultSet.getString("name");
                String stu_mail = resultSet.getString("qq_mail");
                System.out.printf("stu_id = %d stu_sn = %d stu_name = %s stu_mail = %s %n",stu_id,stu_sn,stu_name,stu_mail);
            }


            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
