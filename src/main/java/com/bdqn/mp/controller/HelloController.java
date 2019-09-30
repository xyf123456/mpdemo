package com.bdqn.mp.controller;

import com.bdqn.mp.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @ClassName: com.bdqn.mp.controller.HelloController
 * @Description: 测试控制器
 * @Author:      Administrator
 * @CreateDate: 2019/9/1 0001 下午 10:19
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@RestController
public class HelloController {

//    通过@Value读取配置文件中属性的值
//    @Value("${limit.minMoney}")
//    private BigDecimal minMoney;
//
//    @Value("${limit.maxMoney}")
//    private BigDecimal maxMoney;

//    @Value("${limit.description}")
//    private String description;

//    @Autowired
//    private LimitConfig limitConfig;

   /* @GetMapping("/hello")
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello springBoot";
    }

    @GetMapping("/test")
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
        return "minMoney"+minMoney+"maxMoney"+maxMoney+",说明:"+description;
    }

    @GetMapping("/test1")
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test1(){
        return "minMoney"+limitConfig.getMinMoney()+"maxMoney"+limitConfig.getMaxMoney()+",说明:"+limitConfig.getDescription();
    }*/
}
