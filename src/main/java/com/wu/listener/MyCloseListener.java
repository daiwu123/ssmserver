package com.wu.listener;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyCloseListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private DruidDataSource dataSource;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("event:::"+event+"  "+dataSource.isClosed());
        if(event instanceof ContextClosedEvent){
            synchronized (Object.class) {
                if (!dataSource.isClosed()) {
                    dataSource.close();
                    System.out.println("ContextClosedEvent数据库连接池关闭");
                }
            }
        }
        if(event instanceof ContextStoppedEvent){
            if(!dataSource.isClosed()){
                dataSource.close();
                System.out.println("ContextStoppedEvent数据库连接池关闭");
            }
        }
    }
}
