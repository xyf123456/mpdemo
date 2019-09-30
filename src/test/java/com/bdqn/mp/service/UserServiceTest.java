package com.bdqn.mp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bdqn.mp.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    /**
     * @ Description: 通过业务获取一条数据
     * @params:  * @param
     * @return:void
     **/
    @Test
    public  void getOne(){

        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery();
        queryWrapper.gt(User::getAge,39);
        User user=userService.getOne(queryWrapper,false);
        System.out.println(user.toString());
    }

    /**
     * @ Description:  批量插入 INSERT INTO tt_user ( id, name, age ) VALUES ( ?, ?, ? )
     * @params:  * @param
     * @return:void
     **/
    @Test
    public  void batch(){

        User user1 = new User();
        user1.setName("测试16");
        user1.setAge(23);
        User user2 = new User();
        user2.setName("测试17");
        user2.setAge(34);
        List<User> userList=Arrays.asList(user1,user2);
        boolean result=userService.saveBatch(userList);
        System.out.println(userService);
    }

    /**
     * @ Description: saveOrUpdateBatch 如果设置了id,进行批量插入的话，则直接更新对应的数据
     * @params:  * @param
     * @return:void
     **/
    @Test
    public  void batch1(){

        User user1 = new User();
        user1.setName("测试18");
        user1.setAge(23);
        User user2 = new User();
        user2.setId(1166370280069959681L);
        user2.setName("测试171717");
        user2.setAge(26);
        List<User> userList=Arrays.asList(user1,user2);
        boolean result=userService.saveOrUpdateBatch(userList);
        System.out.println(userService);
    }
    /**
     * @ Description: 支持链式操作
     * @params:  * @param
     * @return:void
     **/
    @Test
    public  void chain1(){
        List<User> userList=userService.lambdaQuery().gt(User::getAge,25).like(User::getName,"雨").list();
      userList.forEach(System.out::println);
    }

    @Test
    public  void chain2(){
        boolean result=userService.lambdaUpdate().eq(User::getAge,25).set(User::getAge,26).update();
        System.out.println(result);
    }

    @Test
    public  void chain3(){
        boolean result=userService.lambdaUpdate().eq(User::getAge,23).remove();
        System.out.println(result);
    }
}