package com.pandachen.example.controller;

import com.pandachen.example.model.Award;
import com.pandachen.example.model.Member;
import com.pandachen.example.model.Setting;
import com.pandachen.example.model.User;
import com.pandachen.example.service.AwardService;
import com.pandachen.example.service.MemberService;
import com.pandachen.example.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private SettingService settingService;
    @Autowired
    private AwardService awardService;
    @Autowired
    private MemberService memberService;

    /**
     * 返回的数据 ：
     * setting对象中的属性
     * setting对象中没有的属性：
     *    （1）user 用户信息
     *    （2）award 奖品列表，根据setting_id查
     *    （3）member 抽奖人员列表，根据setting_id查
     */
    @GetMapping("/query")
    public Object query(HttpSession session) {
        //获取session
        User user = (User) session.getAttribute("user");
        //根据id查setting
        Setting  setting = settingService.selectByUserId(user.getId());
        setting.setUser(user);
        //查询awards
        List<Award> awards = awardService.selectBySetId(setting.getId());
        setting.setAwards(awards);
        //查询members
        List<Member> members = memberService.selectBySetId(setting.getId());
        setting.setMembers(members);

        return setting;
    }
}
