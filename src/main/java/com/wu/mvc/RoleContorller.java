package com.wu.mvc;

import com.wu.po.Pop;
import com.wu.service.RoleService;
import com.wu.sql.model.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleContorller {

    private   Logger logger = LogManager.getLogger(RoleContorller.class);
    @Autowired
    private RoleService roleService;

    @GetMapping("dbCache")
    public Object oneLevelCache(Integer id){
        Logger logger = LogManager.getLogger(RoleContorller.class);
        Role role1 = roleService.queryInfoById(id);
        logger.info("==================第一次查询-===============");
        Role role2 = roleService.queryInfoById(id);
        return role1;
    }

    @GetMapping("dbCache1")
    public Object twoLevelCache(Integer id){
        Logger logger = LogManager.getLogger(RoleContorller.class);
        Pop pop = roleService.queryById(id);
        logger.info("==================第一次查询-===============");
        Role pop2 = roleService.queryInfoById(id);
        return pop;
    }


    @RequestMapping("quertInfo")
    public Object queryInfo(){
      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        List<Role> roles = roleService.queryInfo();
        return roles;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Object login(@RequestBody Map<String,Object> params, HttpSession session, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        String account = (String) params.get("account");
        String password = (String) params.get("password");
        Pop pop = roleService.login(account,password);
        if(pop==null){
            map.put("result",false);

        }else{
            session.setAttribute("token",session.getId());
            /*Cookie cookie = new Cookie("token",session.getId());
            response.addCookie(cookie);*/
            map.put("result",true);
        }
        return map;
    }

    @RequestMapping(value = "meeting",method = RequestMethod.GET)
    public Object startMeeting(HttpSession session){
        //设置无限期
        session.setMaxInactiveInterval(-1);
        return true;
    }

    @RequestMapping(value = "exitMeeting",method = RequestMethod.GET)
    public Object exitMeeting(HttpSession session){
        //设置一份中
        session.setMaxInactiveInterval(60);
        return true;
    }

}
