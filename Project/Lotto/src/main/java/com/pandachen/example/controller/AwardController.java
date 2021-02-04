package com.pandachen.example.controller;

import com.pandachen.example.model.Award;
import com.pandachen.example.model.Setting;
import com.pandachen.example.model.User;
import com.pandachen.example.service.AwardService;
import com.pandachen.example.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/award")
public class AwardController {
    @Autowired
    private AwardService awardService;
    @Autowired
    private SettingService settingService;

    @PostMapping("/add")
    public Object add(@RequestBody Award award, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Setting setting = settingService.selectByUserId(user.getId());
        Integer setId = setting.getId();
        award.setSettingId(setId);
        int n = awardService.addAward(award);
        return award.getId();   //插入成功后，返回自增主键的id
    }

    @PostMapping("/update")
    public Object update(@RequestBody Award award) {
        int n = awardService.update(award);
        return null;
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable Integer id) {
        int n = awardService.delete(id);
        return null;
    }
}
