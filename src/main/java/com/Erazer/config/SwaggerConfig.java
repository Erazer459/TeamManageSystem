package com.Erazer.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;


@Configuration//声明此类是一个swagger的核心配置类
@EnableSwagger2//启用Swagger
@EnableWebMvc//启用SpringMVC
@ComponentScan(basePackages = {"com.Erazer.controller"})
public class SwaggerConfig {
    //配置Swagger的bean实例
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/awards/**"))
                .build()
                .groupName("奖项信息")
                .pathMapping("/");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/projects/**"))
                .build()
                .groupName("项目信息")
                .pathMapping("/");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/roles/**"))
                .build()
                .groupName("角色与许可信息")
                .pathMapping("/");
    }

    @Bean
    public Docket docket4() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/members/**"))
                .build()
                .groupName("成员信息")
                .pathMapping("/");
    }

    @Bean
    public Docket docket5() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/lives/**"))
                .build()
                .groupName("日常信息")
                .pathMapping("/");
    }

    @Bean
    public Docket docket6() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/else/**"))
                .build()
                .groupName("其他信息")
                .pathMapping("/");
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描指定包中的swagger注解
                .apis(RequestHandlerSelectors.basePackage("com.Erazer.controller"))
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    //配置Swagger信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Documentation")
                .description("API文档")
                .termsOfServiceUrl("http://192.168.0.8:8080/")
                .license("Apache2.0")
                .version("1.0.0")
                .contact(new Contact("Erazer817", "-.-", "c1311190630@hotmail.com"))
                .build();
    }

}

