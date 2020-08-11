package com.wu.swagger;

import com.wu.mvc.SwaggerTestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.readers.operation.SwaggerResponseMessageReader;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

@EnableSwagger2
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.wu.mvc")
public class SwaggerConfig {

    @Bean
    public Docket api(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                //文档标题
                .title("ssm项目接口文档")
                //文档描述
                .description("整合资源")
                //版本
                .version("1.0")
                //联系人
                .contact(new Contact("daiwu","www.baidu.com","daiwu@newfis.com"))
                //供应商扩展
                .extensions(null)
                .license("")
                .licenseUrl("")
                //网址及服务条款
                .termsOfServiceUrl("http://")
                .build();

        return new Docket(DocumentationType.SWAGGER_2).
                select()
                /*.apis(RequestHandlerSelectors.basePackage("com.wu.mvc"))
                .apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))*/
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
                //.globalResponses(RequestMethod.GET,);
    }
}
