package com.wu.config;


import com.wu.test.ObjectTest2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(2)
public class Test1Config {

    public Test1Config(){
        System.out.println("Test1conifg 创建了11111111111111");
    }

    @Bean
    public ObjectTest2 createBuild(){
        System.out.println("BaseExcelUtil注入了.111111111111111");
        return new ObjectTest2();
    }
}
