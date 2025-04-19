package com.itheima.dao;

import java.util.List;

public interface UserDao {
    public List<String> findAll();
    //这句话的意思是：定义一个名为findAll的方法，返回值类型为List<String>，方法名为findAll，方法没有参数，且是public访问权限
}
