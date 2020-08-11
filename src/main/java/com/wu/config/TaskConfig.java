package com.wu.config;

import com.wu.asy.EmailTaskHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.DefaultManagedTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class TaskConfig implements AsyncConfigurer {
    @Autowired
    private Executor executor;
    @Override
    public Executor getAsyncExecutor() {

        return executor;
       // return new DefaultManagedTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    @Bean
    public  Executor createExecutor(){
        ThreadPoolTaskExecutor taskExecutor= new ThreadPoolTaskExecutor();
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
    }

}
