package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.User;
import org.springframework.stereotype.Component;

@Mapper
@Component  //可有可无
public interface UserMapper {
    User selectById(Integer id);
}
