package com.pandachen.example.service;

import com.pandachen.example.mapper.AwardMapper;
import com.pandachen.example.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {
    @Autowired
    private AwardMapper awardMapper;

    public List<Award> selectBySetId(Integer id) {
        return awardMapper.selectBySetId(id);
    }

    public int addAward(Award award) {
        return awardMapper.insertSelective(award);
    }

    public int update(Award award) {
        return awardMapper.updateByPrimaryKeySelective(award);
    }

    public int delete(Integer id) {
        return awardMapper.deleteByPrimaryKey(id);
    }
}
