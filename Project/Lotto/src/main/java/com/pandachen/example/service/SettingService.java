package com.pandachen.example.service;

import com.pandachen.example.mapper.SettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService {
    @Autowired
    private SettingMapper settingMapper;
}
