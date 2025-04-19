package com.itheima.service;

import com.itheima.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    //这句的意思是：定义一个名为findAll的方法，返回值类型为List<User>，方法名为findAll，方法没有参数，且是public访问权限
    //public访问权限：可以被任何类访问
}
