package com.pandachen.example.controller;

import com.pandachen.example.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private SettingService settingService;
}
