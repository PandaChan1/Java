package com.pandachen.DAO;

import com.pandachen.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteDAO {
   public void delete(List<Integer> idList) {
       try {
           Connection connection = DBUtil.getConnection();
           List<String> quadQuesionMark = idList.stream()
                   .map(id -> "?")
                   .collect(Collectors.toList());
           String mark = String.join(",", quadQuesionMark);
           String sql = String.format("delete from file_meta where id in (%s)", mark);
           PreparedStatement ps = connection.prepareStatement(sql);
           for (int i = 0; i < idList.size(); i++) {
               int id = idList.get(i);
               ps.setInt(i + 1, id);
           }
           ps.executeUpdate();
       }catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }
}
