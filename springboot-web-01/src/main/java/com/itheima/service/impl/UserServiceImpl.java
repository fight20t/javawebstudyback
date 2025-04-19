package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Primary
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao UserDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //1.调用dao层，读取文件
        List<String> lines = UserDao.findAll();


        //2.解析数据，封装成对象-->对象
        //stream()方法可以将List转换为Stream流，map()方法可以对每个元素进行处理，最后使用toList()方法将结果转换为List
        //map()方法中的lambda表达式可以将每一行字符串转换为User对象
        List<User> userList = lines.stream().map(line -> {

            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            return new User(id, username, password, name, age, updateTime);
        }).toList();

        return userList;
    }
}

