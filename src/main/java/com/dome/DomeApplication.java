package com.dome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * CLASSNAME DomeApplication
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/18 18:33
 * @Version 1.0
 */
@MapperScan(basePackages = {"com.dome.dao"})
@SpringBootApplication
//@EnableAsync
public class DomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(DomeApplication.class,args);
    }
}
