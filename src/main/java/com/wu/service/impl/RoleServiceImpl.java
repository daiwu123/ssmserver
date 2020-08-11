package com.wu.service.impl;

import com.wu.po.Pop;
import com.wu.service.RoleService;
import com.wu.sql.mapper.PopMapper;
import com.wu.sql.mapper.UserMapper;
import com.wu.sql.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    PopMapper popMapper;
    @Autowired
    Executor ThreadPoolTask;
    @Override
    public List<Role> queryInfo() {
        return userMapper.queryInfoAll();
    }

    @Override
    public Pop login(String account, String password) {
        return popMapper.queryAllPop(account,password);
    }

    @Override
    @Cacheable(value = "cacheTest",key = "new String(#id).concat('queryInfoById')")
    public Role queryInfoById(Integer id) {
        return userMapper.queryInfoById(id);
    }


    @Override
    @Cacheable(value = "cacheTest",key = "new String(#id).concat('queryById')")
    /*@CacheEvict(value="cacheTest",allEntries = true)*/
    public Pop queryById(Integer id){
        System.out.println("正在执行缓存方法");
        return popMapper.queryById(id);
    }




}
