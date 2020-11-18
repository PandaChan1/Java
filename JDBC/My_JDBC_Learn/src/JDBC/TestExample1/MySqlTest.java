package JDBC.TestExample1;

import java.sql.*;

public class MySqlTest {
    public static void main(String[] args)  {
        try {
            //加载驱动程序，反射，这样调用  com.mysql.jdbc.Driver  类，即将类加载
            Class.forName("com.mysql.jdbc.Driver");
            //第一步，创建数据库连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn?user=root&password=744631199&useSSL=false" +
                    "&userUnicode=true&characterEncoding=UTF-8");
            System.out.println(connection);

            //第二步，创建了操作命令对象
            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select id i,sn ,name,qq_mail,classes_id from student");
            ResultSet resultSet = statement.executeQuery("select cls.id cls_id,cls.name cls_name,stu.id stu_id,stu.sn stu_sn,stu.name stu_name,stu.qq_mail stu_mail from classes cls join student stu on stu.classes_id = cls.id");
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
