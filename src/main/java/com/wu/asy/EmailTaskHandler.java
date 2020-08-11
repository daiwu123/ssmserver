package com.wu.asy;

import com.wu.service.RoleService;
import com.wu.sql.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class EmailTaskHandler  {
    @Async()
    public void sendEmail() throws InterruptedException {

        System.out.println("开始发送邮件"+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("邮件发送完毕啦"+Thread.currentThread().getName());
    }
    @Async()
    public String restustring(){
        System.out.println("开始远程调用"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("远程调用结束"+Thread.currentThread().getName());
            return "远程调用成功啦";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @Async
    public Future<String> callback() throws InterruptedException {
        System.out.println("异步方法开始调用...");
        Thread.sleep(2000);
        return new AsyncResult<String>("回调得到的数据...");
    }

    public String s(){
        return "ad";
    }
}
