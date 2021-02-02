package com.pandachen.example.mapper;

import com.pandachen.example.base.BaseMapper;
import com.pandachen.example.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}