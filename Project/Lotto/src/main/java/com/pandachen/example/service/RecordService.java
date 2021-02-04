package com.pandachen.example.service;

import com.pandachen.example.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;

    //批量插入
    public int insert(Integer awardId, List<Integer> memberId) {
        return recordMapper.batchInsert(awardId,memberId);
    }

    public int deleteByMemberId(Integer memberId) {
        return recordMapper.deleteByMemberId(memberId);
    }

    public int deleteByAwardId(Integer awardId) {
        return recordMapper.deleteByAwardId(awardId);
    }

    public int deleteByUserId(Integer id) {
        return recordMapper.deleteByUserId(id);
    }
}
