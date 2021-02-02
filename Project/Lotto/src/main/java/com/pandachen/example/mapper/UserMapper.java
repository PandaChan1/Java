package com.pandachen.example.mapper;

import com.pandachen.example.base.BaseMapper;
import com.pandachen.example.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}