package com.wu.service;

import com.wu.po.Pop;
import com.wu.sql.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> queryInfo();
    Pop login(String account,String password);
    Role queryInfoById(Integer id);
    Pop queryById(Integer id);

}
