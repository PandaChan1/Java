package com.pandachen.example.controller;

import com.pandachen.example.model.Member;
import com.pandachen.example.model.Setting;
import com.pandachen.example.model.User;
import com.pandachen.example.service.MemberService;
import com.pandachen.example.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private SettingService settingService;

    @PostMapping("/add")
    public Object add(@RequestBody Member member, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Integer id = user.getId();
        Setting setting = settingService.selectByUserId(id);
        member.setSettingId(setting.getId());
        int n = memberService.add(member);
        return member.getId();
    }

    @PostMapping("/update")
    public Object update(@RequestBody Member member) {
        int n = memberService.update(member);
        return null;
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable Integer id) {
        int n = memberService.delete(id);
        return null;
    }
}
