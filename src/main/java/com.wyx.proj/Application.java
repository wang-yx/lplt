package com.wyx.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动程序
 */
@SpringBootApplication
@EnableScheduling
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);

    }

    protected SpringApplicationBuilder configer(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(Application.class);
    }

}
