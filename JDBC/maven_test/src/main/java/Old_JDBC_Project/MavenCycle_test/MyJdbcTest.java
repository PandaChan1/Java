package Old_JDBC_Project.MavenCycle_test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJdbcTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement presta = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DataSource dataSource = new MysqlDataSource();
            ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/learn?user=root&password=744631199&useSSL=false&userUnicode=true&characterEncoding=UTF-8");
            connection = dataSource.getConnection();
            String sql = "select id ,sn ,name ,qq_mail from student where name like ?";
            presta = connection.prepareStatement(sql);
            presta.setString(1, "%学%");
            resultSet = presta.executeQuery();
            while (resultSet.next()) {
                int stu_id = resultSet.getInt("id");
                int stu_sn = resultSet.getInt("sn");
                String stu_name = resultSet.getString("name");
                String stu_mail = resultSet.getString("qq_mail");
                System.out.printf("stu_id = %d stu_sn = %d stu_name = %s stu_mail = %s %n", stu_id, stu_sn, stu_name, stu_mail);
            }
            resultSet.close();
            presta.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
