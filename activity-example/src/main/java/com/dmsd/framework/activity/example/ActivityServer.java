package com.dmsd.framework.activity.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 流程管理服务端启动类
 * @author cao xueliang
 * @date 2020/9/29 9:32
*/
@SpringBootApplication
@ComponentScan(basePackages={"com.dmsd"})
//@ImportResource(locations = {"classpath:application2.xml"})
public class ActivityServer {
    public static void main(String[] args) {
        SpringApplication.run(ActivityServer.class, args);
    }
}
