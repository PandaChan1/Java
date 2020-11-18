package JDBC.TestExample1;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceTest {
    public static void main(String[] args)  {
        Connection connection = null;
        Statement statement = null;
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

            //第二步，创建了操作命令对象
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select cls.id cls_id,cls.name cls_name,stu.id stu_id,stu.sn stu_sn,stu.name stu_name,stu.qq_mail stu_mail from classes cls join student stu on stu.classes_id = cls.id");
            //处理结果集
            while (resultSet.next()) {
                int cls_id = resultSet.getInt("cls_id");
                String  cls_name = resultSet.getString("cls_name");
                int stu_id = resultSet.getInt("stu_id");
                int stu_sn = resultSet.getInt("stu_sn");
                String stu_name = resultSet.getString("stu_name");
                String stu_mail = resultSet.getString("stu_mail");
                System.out.printf("cls_id = %d cls_name = %s stu_id = %d stu_sn = %d stu_name = %s stu_mail = %s %n",cls_id,cls_name,stu_id,stu_sn,stu_name,stu_mail);
            }


            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
