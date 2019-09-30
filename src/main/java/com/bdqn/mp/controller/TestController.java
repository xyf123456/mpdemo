package com.bdqn.mp.controller;

import com.bdqn.mp.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @ClassName: TestController
 * @Description: 测试控制器
 * @Author: Administrator
 * @CreateDate: 2019/9/1 0001 下午 11:15
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping({"/test", "/test1"})
    @ResponseBody
    public String test() {
//        return "index";
        return limitConfig.getDescription();
    }

    @PostMapping({"/test2", "/test22"})
    @ResponseBody
    public String test2() {
//        return "index";
        return limitConfig.getDescription();
    }

    @GetMapping("/say/{id}")
    @ResponseBody
    public String say(@PathVariable("id") Integer id) {
        return "id:" + id;
    }

    @GetMapping("/say2")
    @ResponseBody
    public String say2(@RequestParam(value = "uId", required = false, defaultValue = "1") Integer uId) {
        return "uId:" + uId;
    }

    @PostMapping("/say3")
    @ResponseBody
    public String say3(@RequestParam(value = "uId", required = false, defaultValue = "1") Integer uId) {
        return "uId:" + uId;
    }

}
