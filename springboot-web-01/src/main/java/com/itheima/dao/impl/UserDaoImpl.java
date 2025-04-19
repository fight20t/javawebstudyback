package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        //1.加载并读取文件
        //InputStream的getClass().getClassLoader()方法可以获取当前类的类加载器，类加载器可以用来加载类和资源文件
        //getResourceAsStream()方法可以获取指定路径的资源文件的输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        //IoUtil是Hutool工具类库中的一个工具类，提供了很多常用的IO操作方法
        //readLines()方法可以读取输入流中的所有行，并将每一行作为一个字符串存储在List中
        //readLines中的第一个参数是输入流，第二个参数是字符集，第三个参数是存储读取到的字符串的List
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
