package com.lgt.clubmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.lgt.clubmanagement.dao")
public class ClubmanagementApplication {

    public static void main(String[] args) {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","{}");
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","[]");
        SpringApplication.run(ClubmanagementApplication.class, args);
    }

}
