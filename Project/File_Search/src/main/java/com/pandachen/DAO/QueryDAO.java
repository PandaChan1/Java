package com.pandachen.DAO;

import com.pandachen.Model.FileMeta;
import com.pandachen.Util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {
    public List<FileMeta> query(String key) {
        try {
            Connection connection = DBUtil.getConnection();
            String sql = "select id,name,path,is_directory,size,last_modified from file_meta where name like ? or pinyin like ? or pinyin_first like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");

            List<FileMeta> result = new ArrayList<>();
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                boolean directory = resultSet.getBoolean("is_directory");
                long length = resultSet.getLong("size");
                long lastModified = resultSet.getLong("last_modified");

                FileMeta fileMeta = new FileMeta(id, name, path, directory, length, lastModified);
                result.add(fileMeta);
            }
            return result;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
