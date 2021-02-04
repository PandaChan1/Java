package com.pandachen.example.controller;

import com.pandachen.example.model.User;
import com.pandachen.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    //id表示某个奖项，请求数据为抽奖人员组成的数组
    @PostMapping("/add/{awardId}")
    public Object add(@PathVariable Integer awardId, @RequestBody List<Integer> memberId) {
       int n =  recordService.insert(awardId,memberId);
       return null;
    }

    @GetMapping("/delete/member")
    public Object deleteMember(Integer id){
        int n = recordService.deleteByMemberId(id);
        return null;
    }
    @GetMapping("/delete/award")
    public Object deleteAward(Integer id){
        int n = recordService.deleteByAwardId(id);
        return null;
    }
    @GetMapping("/delete/setting")
    public Object deleteBySetting(HttpSession session) {
        User user = (User)session.getAttribute("user");
        //获取userid---》关联settingId---》关联的member_id,award_id
        //然后删除record表中中将记录
        int n = recordService.deleteByUserId(user.getId());
        return null;
    }
}
