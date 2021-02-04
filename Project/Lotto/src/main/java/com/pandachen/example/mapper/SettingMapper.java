package com.pandachen.example.mapper;

import com.pandachen.example.base.BaseMapper;
import com.pandachen.example.model.Setting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SettingMapper extends BaseMapper<Setting> {
    Setting selectByUserId(Integer id);

    int updateByUserId(@Param("id") Integer id, @Param("batchNumber") Integer batchNumber);
}