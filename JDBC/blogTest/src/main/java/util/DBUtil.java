package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import exception.myexception;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static final DataSource DS = new MysqlDataSource();

    //多线程学习后会优化为双重校验锁的单例模式
    static {
        ((MysqlDataSource)DS).setUrl("jdbc:mysql://localhost:3306/blog?user=root&password=744631199&useSSL=false&userUnicode=true&characterEncoding=UTF-8");
    }


    //获取数据库连接
    public static Connection getConnection(){
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            throw new myexception("获取数据库连接失败",e,"DB0001");
        }
    }

    //释放资源
    public static void close(Connection c, Statement s){
        close(c,s,null);
    }

    public static void close(Connection c, Statement s, ResultSet r) {
        try {
        if (r != null) {
            r.close();
        }
        if (s != null) {
            s.close();
        }
        if (c != null) {
            c.close();
        }
            } catch (SQLException e) {
                throw new myexception("数据库关闭失败",e,"DB0002");
            }

    }
}
