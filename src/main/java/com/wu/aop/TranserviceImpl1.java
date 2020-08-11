package com.wu.aop;

import org.springframework.stereotype.Component;

@Component
public class TranserviceImpl1  {

    public String addData(String username,String password){
        System.out.println("添加到数据库.username:"+username+";;;password:::"+password);
       // int i = 1/0;
        return "新增成功";
    }
}
