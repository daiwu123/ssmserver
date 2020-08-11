package com.wu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //切面
@Order(7)
public class TransactionAop1 {

    @Pointcut("execution(public * com.wu.aop.TranserviceImpl1.*(..)) &&  args(username,password)")
    public void aop(String username,String password){};

    @Before("aop(username,password)")
    public String startTransaction(String username,String password){
        System.out.println("开启事务"+username+";;"+password+"1111111111111");
        return "start";
    }
    @After("aop(username,pass)")
    public String endTransaction(String username,String pass){
        System.out.println("提交最终事务.事务"+username+";;"+pass+"1111111111111");
        return "end";
    }
    @AfterReturning(value = "aop(username,pass)",returning = "result")
    public String afterReturnTransaction(String username,String pass,Object result){
        System.out.println("返回执行."+username+";;"+pass +";;;;;;;"+result+"1111111111111");
        return "end23";
    }
    @AfterThrowing("aop(username,pass)")
    public String afterReturnThrowing(String username,String pass){
        System.out.println("异常执行."+username+";;"+pass+"1111111111111");
        return "end";
    }

    @Around("aop(username,pass)")
    public String aroundTrancation(ProceedingJoinPoint proceedingJoinPoint,String username, String pass) throws Throwable {
        System.out.println("环绕开启事务."+username+";;pass"+pass+"1111111111111");
        proceedingJoinPoint.proceed();
        System.out.println("环绕结束事务."+username+";;pass"+pass+"1111111111111");
        return "end";
    }

}
