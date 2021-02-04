package com.pandachen.example.mapper;

import com.pandachen.example.base.BaseMapper;
import com.pandachen.example.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    int batchInsert(@Param("awardId") Integer awardId, @Param("memberId") List<Integer> memberId);

    int deleteByMemberId(Integer memberId);

    int deleteByAwardId(Integer awardId);

    int deleteByUserId(Integer id);
}