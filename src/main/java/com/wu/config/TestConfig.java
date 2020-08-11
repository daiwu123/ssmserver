package com.wu.config;


import com.wu.test.ObjectTest;
import com.wu.util.BaseExcelUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class TestConfig {

    public TestConfig(){
        System.out.println("Testconifg 创建了");
    }

    @Bean
    public ObjectTest createBuild1(){
        System.out.println("ObjectTest注入了");
        return new ObjectTest();
    }
}
