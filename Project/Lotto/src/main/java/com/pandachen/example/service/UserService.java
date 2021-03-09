package com.pandachen.example.service;

import com.pandachen.example.exception.APPexception;
import com.pandachen.example.mapper.SettingMapper;
import com.pandachen.example.mapper.UserMapper;
import com.pandachen.example.model.Setting;
import com.pandachen.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SettingMapper settingMapper;

    @Value("${user.head.local-path}")
    private String localHeadPath;   //本地存储路径

    @Value("${user.head.remote-path}")
    private String remoteHeadPath;   //http访问路径

    private static final DateFormat DF = new SimpleDateFormat("yyyyMMdd");

    public String saveHead(MultipartFile headFile) {
        Date now = new Date();
        String dirUri = DF.format(now);
        //存储文件夹，由当前时间戳生成
        String uri="/" + dirUri;
        File dir = new File(localHeadPath + uri);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        //保证文件唯一性，随机字符串作为文件名，但后缀还是原来的后缀
        String suffix = headFile.getOriginalFilename().substring(headFile.getOriginalFilename().lastIndexOf('.'));

        String localFileName = UUID.randomUUID().toString() + suffix;

        String relativePath = uri + "/" + localFileName;

        try {
            headFile.transferTo(new File(localHeadPath + relativePath));
        } catch (IOException e) {
           throw new APPexception("REG001","上传用户头像出错");
        }


        return remoteHeadPath + relativePath;

    }

    //事务操作:多个更新操作，或部分查询+更新时，都需要开启事务
    //内部实现:aop,方法前开启事务，方法执行后，抛异常rollback，没有异常commit

    //这种地方禁止try/catch吞异常 !!!!!!!!!
   @Transactional
    public void register(User user) {
        //插入user数据
        int i = userMapper.insertSelective(user);
        //插入setting数据，登陆后进入设置页面，添加抽奖人员和奖项需要setting_id
        Setting setting = new Setting();
        //使用user.getId()，可以获得数据库中的id
        //因为在UserMapper.xml中，insertSelective()的属性 useGeneratedKeys="true" :每次插入之后自增的id，都会设置会user对象中
        setting.setUserId(user.getId());
        setting.setBatchNumber(5);  //默认值
        int n = settingMapper.insertSelective(setting);
    }

    public User queryByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
