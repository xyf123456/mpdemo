package com.bdqn.mp.dao;

import com.bdqn.mp.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @ClassName: com.bdqn.mp.dao.ARTest
 * @Description: ActiveRecord 测试类（直接使用实体进行CRUD）
 * @Author: Administrator
 * @CreateDate: 2019/8/27 0027 下午 10:02
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ARTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        User user = new User();
        user.setAge(23);
        user.setName("测试12");
        user.setEmail("5653235@qq.com");
        user.setManagerId(1094592041087729666L);
        user.setCreateTime(LocalDateTime.now());
        boolean result = user.insert();
        System.out.println(result);
    }

    @Test
    public void insertOrUpdate() {
       /* User user = new User();
        user.setAge(23);
        user.setName("测试999");
        user.setEmail("999999@qq.com");
        user.setManagerId(1094592041087729666L);
        user.setCreateTime(LocalDateTime.now());*/
//       如果不传ID，则为更新语句
        User user = new User();
        user.setId(1166351711428943874L);
        user.setName("测试999");
        boolean result = user.insertOrUpdate();
        System.out.println(result);
    }

    @Test
    public void select() {
//        User user = new User();
//        User userSelect=user.selectById(1094592041087729666L);
        User user = new User();
        user.setId(1094592041087729666L);
        User userSelect = user.selectById();
        System.out.println(userSelect);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1166343023645462530L);
        user.setName("12新名字");
        boolean result = user.updateById();
        System.out.println(result);
    }

    @Test
    public void delete() {
        User user = new User();
        user.setId(1166343023645462530L);
        boolean result = user.deleteById();
        System.out.println(result);
    }


}
