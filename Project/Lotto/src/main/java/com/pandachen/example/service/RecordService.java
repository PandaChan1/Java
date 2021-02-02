package com.pandachen.example.service;

import com.pandachen.example.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;
}
