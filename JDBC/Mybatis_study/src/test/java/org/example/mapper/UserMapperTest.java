package org.example.mapper;

import org.example.Application;
import org.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
}
