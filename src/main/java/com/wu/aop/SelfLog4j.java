package com.wu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class SelfLog4j {
    public void before(){
        System.out.println("前置通知...");
    }
    public void after(){
        System.out.println("后置通知...");
    }
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知..");

        proceedingJoinPoint.proceed();
        System.out.println("环绕后通知..");
    }
}
