package com.wu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class Config {

    /*@Bean
    public  ThreadPoolTaskExecutor createExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //线程池里面最小执行线程数量
        taskExecutor.setCorePoolSize(2);
        //线程池最大线程数量
        taskExecutor.setMaxPoolSize(4);
        //对列容量大小
        taskExecutor.setQueueCapacity(10);
        //超过corePoolsize的线程数，任务完成之后；当超过这个时间之后会被close掉
        taskExecutor.setKeepAliveSeconds(60);
        //当超过50之后，再来个任务，那这个任务的处理方式
        //taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }*/
}
