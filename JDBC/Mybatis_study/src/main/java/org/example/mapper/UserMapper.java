package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component  //可有可无
public interface UserMapper {
    User selectById(Integer id);
    List<User> selectPrefixString(String username);   //查询以a开头的用户的信息,String版
    List<User> selectPrefixUser(User user);   //查询以a开头的用户的信息,User版
    int insertUser(User user);  //新增用户
    int batchDelete(List<Integer> ids);
}
