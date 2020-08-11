package com.wu.mvc;

import com.wu.asy.EmailTaskHandler;
import com.wu.po.User;
import com.wu.service.RoleService;
import com.wu.sql.model.Role;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
public class TestController {
   /* private Log Logger = LogFactory.getLog(TestController.class);*/
    private  static Logger logger =  LogManager.getLogger(TestController.class);
    @Autowired
    private User useri;
    @Autowired
    EmailTaskHandler emailTaskHandler;
    @Autowired
    private RoleService roleService;
    @RequestMapping("/home")
    public String testController(HttpServletRequest request){
        System.out.println(useri.getName());
        logger.error("error");
        return "home.html";
    }
    @RequestMapping("/login")
    public String loginController(){
        return "login.html";
    }

    @RequestMapping("/asy")
    public String asyController(){
        System.out.println("A");
        try {
            emailTaskHandler.sendEmail();
            emailTaskHandler.restustring();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B");
        return "home.html";
    }

    @RequestMapping("/asy1")
    public String asy1Controller() throws ExecutionException, InterruptedException {
        System.out.println("进入");
        Future<String> callback = null;
        try {
            emailTaskHandler.sendEmail();
            callback  = emailTaskHandler.callback();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Role> roles = roleService.queryInfo();
        System.out.println(roles.size());
        System.out.println("B") ;
        if(callback.isDone()){ //判断是否执行完毕
            System.out.println(callback.get());
        }
        return "home.html";
    }
}
