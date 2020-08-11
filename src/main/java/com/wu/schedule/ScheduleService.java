package com.wu.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    //1s执行一次
   /* @Scheduled(fixedRate=1000)*/
    public void scheduleA() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"-->A开始");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+"-->A结束");
    }

    /*@Scheduled(fixedRate=1000)*/
    public void scheduleB() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"-->B开始");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"-->B结束");
    }

}
