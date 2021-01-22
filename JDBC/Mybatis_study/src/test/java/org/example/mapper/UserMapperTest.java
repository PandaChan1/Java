package org.example.mapper;

import org.example.Application;
import org.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//指定为Spring环境下的单元测试
@RunWith(SpringRunner.class)
//Application为启动类
@SpringBootTest(classes = Application.class)

@Transactional  //事务操作，加上会回滚，即测试过程中的增删改查不会真正写入数据库，而是执行完就会回滚
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void selectPrefixString() {
        List<User> users = userMapper.selectPrefixString("a%");
        System.out.println(users);
    }

    @Test
    public void selectPrefixUser() {
        User user = new User();
        user.setUsername("a%");
        List<User> users = userMapper.selectPrefixUser(user);
        System.out.println(users);
    }
    @Test
    public void insertUser() throws ParseException {
        User user = new User();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("1998-02-18");
        user.setUsername("d");
        user.setPassword("4");
        user.setNickname("滴滴");
        user.setBirthday(date);
        int i = userMapper.insertUser(user);
        System.out.println(user);
    }
}
