package com.pandachen.example.mapper;

import com.pandachen.example.base.BaseMapper;
import com.pandachen.example.model.Setting;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettingMapper extends BaseMapper<Setting> {
}