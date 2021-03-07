package com.pandachen.DAO;

import com.pandachen.Model.FileMeta;
import com.pandachen.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaveDAO {
    public synchronized void save(List<FileMeta> fileList)  {
        Connection connection;
        PreparedStatement ps;
        try {
            String sql = "insert into file_meta " +
                    "(name,path,is_directory,pinyin,pinyin_first,size,last_modified)" +
                    " values (?,?,?,?,?,?,?)";
            connection = DBUtil.getConnection();

            ps = connection.prepareStatement(sql);
            for (FileMeta f :
                    fileList) {
                ps.setString(1, f.getName());
                ps.setString(2,f.getPath());
                ps.setBoolean(3,f.isDirectory());
                ps.setString(4,f.getPinYin());
                ps.setString(5,f.getPinYinFirst());
                ps.setLong(6,f.getSize());
                ps.setLong(7,f.getLastModified());
                ps.executeUpdate();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
