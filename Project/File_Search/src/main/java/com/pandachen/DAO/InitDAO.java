package com.pandachen.DAO;

import com.pandachen.Util.DBUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InitDAO {
    private String[] getSQL(){
        InputStream is = getClass().getClassLoader().getResourceAsStream("init.sql");
        Scanner sc = new Scanner(is, "UTF-8");
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }

        return sb.toString().split(";");
    }

    public void init() {
        try {
            Connection connection = DBUtil.getConnection();
            String[] sql = getSQL();
            for (String s :
                    sql) {
                PreparedStatement ps = connection.prepareStatement(s);
                  int i = ps.executeUpdate();  //初始化数据库表
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
