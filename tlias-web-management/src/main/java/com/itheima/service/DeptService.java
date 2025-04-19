package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门数据
     * @return
     */
    List<Dept> findAll();
}
