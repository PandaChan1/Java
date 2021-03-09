package com.pandachen.Mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DBInitMapper {
    void init();
}
