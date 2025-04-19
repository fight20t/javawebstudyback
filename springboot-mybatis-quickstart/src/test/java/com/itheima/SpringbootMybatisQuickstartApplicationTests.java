package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> userList=userMapper.findAll();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(1);

    }

    @Test
    public void testInsert(){
        User user=new User(null,"zhangsan","123456","张三",18);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate(){
        User user=new User(2,"lisi","123456","李四",20);
        userMapper.update(user);
    }

    @Test
    public void testFindByUsernameAndPassword(){
        User user=userMapper.findByUsernameAndPassword("zhangsan","123456");
        System.out.println(user);
    }

}
