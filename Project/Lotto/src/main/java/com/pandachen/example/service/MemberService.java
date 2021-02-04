package com.pandachen.example.service;

import com.pandachen.example.mapper.MemberMapper;
import com.pandachen.example.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<Member> selectBySetId(Integer id) {
        return memberMapper.selectBySetId(id);
    }


    public int add(Member member) {
        return memberMapper.insertSelective(member);
    }

    public int update(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    public int delete(Integer id) {
        return memberMapper.deleteByPrimaryKey(id);
    }
}
