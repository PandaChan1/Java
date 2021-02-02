package com.pandachen.example.service;

import com.pandachen.example.mapper.AwardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardService {
    @Autowired
    private AwardMapper awardMapper;
}
