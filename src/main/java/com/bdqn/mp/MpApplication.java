package com.bdqn.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * ClassName: {@link MpApplication}
 * Description: SpringBoot：化繁为简，简化配置；备受关注，下一代框架；微服务的入门级微框架；
 * SpringBoot——>SpringCloud——>微服务
 * Author: xyf
 * Date 2019/8/22 8:22
 */
@SpringBootApplication
@MapperScan(basePackages = "com.bdqn.mp.dao")
@ServletComponentScan(basePackages = "com.bdqn.mp.servlet")
public class MpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpApplication.class, args);
    }
}
