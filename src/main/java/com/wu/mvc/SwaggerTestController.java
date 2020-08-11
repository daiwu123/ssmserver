package com.wu.mvc;

import com.wu.response.ResultTo;
import com.wu.service.RoleService;
import com.wu.sql.model.Role;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SwaggerTestController {
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "getFunctionByFixVersion",method ={RequestMethod.GET})
    @ApiOperation(value="getFunctionByFixVersion",
            tags = "NPDN Xray",
            notes = "根据fixversion的值自动获取对应的VFI接口",
            responseContainer = "application/json",
            responseReference = "application/json111111",
            responseHeaders = @ResponseHeader(name = "aaa",description = "json数据",responseContainer ="application/json",response = Object.class))
    public  ResultTo<List> queryInfo(@RequestParam(required = true) String s,String b){
        ResultTo<List> result1= new ResultTo();
        List<Role> result = roleService.queryInfo();
        result1.setSuccess(true);
        result1.setData(result);
        result1.setCode(200);
        result1.setDesc("sadaaada");
        return result1;
    }


    @RequestMapping(value = "test1",method ={RequestMethod.POST})
    @ApiOperation(value="测试1", tags = "NPDN Xray")
    @ApiImplicitParam(name = "role",value="入参",required = true,dataTypeClass = Role.class)
    public  void test1(@RequestBody Role role){
        System.out.println("test");
    }
}
