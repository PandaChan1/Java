package com.pandachen.example.mapper;

import com.pandachen.example.base.BaseMapper;
import com.pandachen.example.model.Record;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}