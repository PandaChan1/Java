package com.pandachen.Util;

import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static volatile DataSource dataSource = null;

    private static String getPath() {
        //使用这个的原因：如果直接执行.class文件那么会得到当前class的绝对路径；
        // 而如果是封装到jar包中再执行，那么会获取到当前jar包的绝对路径
        //由于项目最终需要封装，因此使用getProtectionDomain()
        try {
            String classPath = DBUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            File classDir = new File(URLDecoder.decode(classPath, "UTF-8"));
            return classDir.getParent() + File.separator + "file_searcher.db";
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initDataSource() {
        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
        String url = "jdbc:sqlite://" + getPath();
        sqLiteDataSource.setUrl(url);

        dataSource = sqLiteDataSource;
    }

    //单例模式二次判断
    private static Connection initConnection() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    initDataSource();
                }
            }
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //ThreadLocal为每一个线程创建一个connection
    private static final ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(() -> initConnection());

    public static Connection getConnection() {
        return connectionThreadLocal.get();

    }
}
