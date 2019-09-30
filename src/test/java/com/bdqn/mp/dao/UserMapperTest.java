package com.bdqn.mp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.bdqn.mp.pojo.Student;
import com.bdqn.mp.pojo.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void select() throws Exception {
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(11, userList.size());
        userList.forEach(System.out::println);
       /* for (User user:
             userList) {
            System.out.println(user.toString());
        }*/
    }

    /**
     * @ Description: 主键策略测试
     * @params:  * @param
     * @return:void
     **/
    @Test
    public void idStrategy() {
        User user = new User();
//        默认是不设置值的时候，不会出现相应的字段名
        user.setName("测试14");
        user.setManagerId(1094592041087729666L);
        user.setEmail("dfsdff@qq.com");
        user.setAge(14);
        user.setCreateTime(LocalDateTime.now());
        int result = userMapper.insert(user);
        System.out.println(result);
        //这里可以插入后的id
        System.out.println(user.getId());
    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setName("测试10");
//        user.setRealName("测试7");
        user.setAge(18);
        user.setEmail("1010101@qq.com");
        user.setManagerId(1087982257332887553L);
        user.setCreateTime(LocalDateTime.now());
        user.setRemark("备注信息");
        int rows = userMapper.insert(user);
        System.out.println("影响行数:" + rows);
    }

    @Test
    public void selectById() throws Exception {
        User user = userMapper.selectById(1165077518678773762L);
        System.out.println(user.toString());
    }

    @Test
    public void selectByIds() throws Exception {
        List<Long> idsList = Arrays.asList(1165077518678773762L, 1088248166370832385L, 1094592041087729666L);
        List<User> userList = userMapper.selectBatchIds(idsList);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByMap() throws Exception {
        Map<String, Object> columnMap = new HashMap<>();
      /*  columnMap.put("name","张雨琪");
        columnMap.put("age",31);*/
      /*  columnMap.put("age",43);*/
//        columnMap.put("managerId",1087982257332887553L);
//        columnMap.put(key 值为数据中的列值)
        columnMap.put("manager_id", 1087982257332887553L);
        List<User> userList = userMapper.selectByMap(columnMap);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description:名字中包含 “测试”同时 年龄小于40岁的用户
     * name LIKE ? AND age < ?
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.like("name", "测试").lt("age", 40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description:名字中包含 “测试”同时 年龄大于20岁的用户并且邮箱不为空
     * WHERE name LIKE ? AND age > ? AND email IS NOT NULL
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper1() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.like("name", "测试").gt("age", 20).isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }


    /**
     * @ Description:名字中包含 “雨”同时 年龄大于20岁小于40的用户并且邮箱不为空
     * WHERE name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper2() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.like("name", "雨").between("age", 20, "40").isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description: 名字为“测”姓或者年龄大于25岁用户并且年龄降序，id升序排列
     * WHERE name LIKE ? OR age >= ? ORDER BY id ASC , age DESC
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper3() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.likeLeft("name", "测").or().ge("age", 25).orderByAsc("id").orderByDesc("age");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description: 创建日期为2019-08-24并且直属上级为 “大”姓的用户
     * WHERE date_format(create_time,'%Y-%m-%d') = ? AND manager_id IN (select manager_id from user where name like '测%')
     * WHERE date_format(create_time,'%Y-%m-%d %H:%i:%s') = ? AND manager_id IN (select manager_id from user where name like '测%')
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper4() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
//        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}","2019-08-24")
//        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = '2019-08-24' or true or true",)
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}", "2019-08-24")
                .inSql("manager_id", "select id from user where name like '大%'");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description:名字中包含 “测” 姓 并且 （年龄小于40岁的用户或者邮箱不为空）
     * WHERE name LIKE ? AND ( age < ? OR email IS NOT NULL )
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper5() throws Exception {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        QueryWrapper<User> query= Wrappers.<User>query();
        QueryWrapper<Student> query1= Wrappers.<Student>query();
//        queryWrapper.likeRight("name", "测").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        query.likeRight("name", "测").and(wq -> wq.gt("age", 30).or().isNotNull("email"));
//        List<User> userList = userMapper.selectList(queryWrapper);
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description:名字中包含 “测” 姓 或者 （年龄在20—40岁并且邮箱不为空）
     * WHERE name LIKE ? or ( age <40 and age >20  and email IS NOT NULL )
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper6() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.likeRight("name", "测").or(wq -> wq.between("age", 20, 40).isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }


    /**
     * @ Description:（年龄小于40或 邮箱不为空）并且 名字中包含 “测” 姓
     * WHERE ( age < ? OR email IS NOT NULL ) AND name LIKE ?
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper7() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.nested(wq -> wq.lt("age", 40).or().isNotNull("email")).likeRight("name", "测");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description:年龄为32,35,40,42的用户 并且只返回1条数据
     * WHERE age IN (?,?,?,?)
     * WHERE age IN (?,?,?,?) limit 1,1
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapper8() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
//        queryWrapper.in("age",Arrays.asList(32,35,40,42));
        queryWrapper.in("age", Arrays.asList(32, 35, 40, 42)).last("limit 1,1");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*******************条件构造器中加强需求（查个别字段）**************************/
    /**
     * @ Description:名字中包含 “测试”同时 年龄小于40岁的用户(select中字段不全部出现)
     * name LIKE ? AND age < ?
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapperSuper() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.select("id", "name").like("name", "测试").lt("age", 40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*******************条件构造器中加强需求（查个别字段，但是字段多的情况）**************************/
    /**
     * @ Description:名字中包含 “测试”同时 年龄小于40岁的用户(select中字段不全部出现)
     * name LIKE ? AND age < ?
     * @params: * @param
     * @return:void
     **/
    @Test
    public void selectByWrapperSuper1() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
        queryWrapper.like("name", "测试").lt("age", 40)
                .select(User.class, tableFieldInfo -> !tableFieldInfo.getColumn().equals("create_time") &&
                        !tableFieldInfo.getColumn().equals("manager_id"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*******************条件构造器中的condition作用**************************/
    /**
     * @param email
     * @ Description: 查询时 条件构造器中的condition作用，如果名称不为空则名称模糊查询.如果邮箱不为空则名称邮箱查询
     * @params: * @param name
     * @return:void
     **/
    public void condition(String name, String email) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        QueryWrapper<User> query= Wrappers.<User>query();
     /*   if (StringUtils.isNotEmpty(name)){
            queryWrapper.like("name",name);
        }
        if (StringUtils.isNotEmpty(email)){
            queryWrapper.like("email",email);
        }*/
//       优化Condition
        queryWrapper.like(StringUtils.isNotEmpty("name"), "name", name)
                .like(StringUtils.isNotEmpty("email"), "email", email);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * @ Description: 测试
     * 如果名称不为空则名称模糊查询.如果邮箱不为空则名称邮箱查询
     * @params: * @param
     * @return:void
     **/
    @Test
    public void testCondition() throws Exception {
        String name = "测";
//        String email = "888888";
        String email = "";
        condition(name, email);
    }

    /*******************实体（有的公司允许前台为实体传过来的数据）作为条件构造器构造方法的参数**************************/
    /*******************实体配合实体中的注解使用**************************/
    /**
     * @ Description:名字为“测试8”同时年龄等于33岁的用户(实体作为条件的参数)
     * WHERE name=? AND age=?
     * @return:void
     **/
    @Test
    public void selectByWrapperEntity() throws Exception {
        User whereUser = new User();
        whereUser.setName("测");
        whereUser.setAge(33);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(whereUser);
//        queryWrapper.like("name","测试").lt("age",40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
    /*******************条件构造器中allEq的用法**************************/
    /*******************条件构造器中allEq的用法(主要是用于过滤一些字段的查询)**************************/
    @Test
    public void selectByWrapperAllEq() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "测试8");
//        map.put("age",33);  //WHERE name = ? AND age = ?
        map.put("age", null); //WHERE name = ? AND age IS NULL
//        queryWrapper.allEq(map,true);
//        queryWrapper.allEq(map,false);//如果是null值，则不出现在sql语句中，自动过滤掉
        queryWrapper.allEq((k, v) -> !k.equals("name"), map); //过滤掉name字段，只有WHERE age IS NULL
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*******************其他条件构造器的用法selectMaps()方法的使用，能够将为null的字段不显示出来**************************/
    @Test
    public void selectByWrapperMaps() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        queryWrapper.like("name","雨").lt("age",40); // 非空字段显示:{create_time=2019-01-14 09:15:15.0, manager_id=1088248166370832385, name=张雨琪, id=1094590409767661570, age=31, email=zjq@baomidou.com}
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40); //可以指定字段显示：{name=张雨琪, id=1094590409767661570}
//        List<User> userList=userMapper.selectList(queryWrapper);
        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * Description: 按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄、并且只取年龄总和小于500的组
     * SELECT avg(age) as avg_age,min(age) as min_age,max(age) as max_age FROM user GROUP BY manager_id HAVING sum(age)<?
     * param: []
     * return: void
     * Date: 2019/8/25 14:03
     */
    @Test
    public void selectByWrapperMaps2() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        queryWrapper.like("name","雨").lt("age",40);
        queryWrapper.select("avg(age) as avg_age", "min(age) as min_age", "max(age) as max_age").groupBy("manager_id").having("sum(age)<{0}", 500);
//        List<User> userList=userMapper.selectList(queryWrapper);
        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*******************其他条件构造器的用法selectObjs()方法的使用，只显示第一个字段的信息**************************/

    /**
     * Description:
     * param: []
     * return: void
     * Date: 2019/8/25 14:15
     */
    @Test
    public void selectByWrapperObjs() throws Exception {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40);
        List<Object> userList = userMapper.selectObjs(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*******************其他条件构造器的用法selectCount()方法，记录数**************************/
    @Test
    public void selectByWrapperCounts() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").lt("age", 40);
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println("总记录数:" + count);
    }

    /*******************其他条件构造器的用法selectOne()方法，只会返回一条记录**************************/
    @Test
    public void selectByWrapperOne() throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "测试2").lt("age", 40);
        User user = userMapper.selectOne(queryWrapper);
//        List<Map<String, Object>> user = userMapper.selectMaps(queryWrapper);
        System.out.println(user);
    }

    /******************lambda条件构造器的用法(三种构造方法),使用lambda表达式，是程序更加健壮**************************/

    /**
     * Description: 使用lambda条件构造器查询数据（名字含“测”同时年龄小于40岁的用户）
     * SELECT id,name,age,email,manager_id,create_time FROM user WHERE name LIKE ? AND age < ?
     * param: []
     * return: void
     * Date: 2019/8/25 14:42
     */
    @Test
    public void selectByLambdaWrapper() throws Exception {
//    LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
//    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName, "测").lt(User::getAge, 40);
        List<User> userList = userMapper.selectList(lambdaQuery);
        userList.forEach(System.out::println);
    }

    /**
     * Description: 查找“测”姓 同时 （年龄小于40 或者 邮箱不为空）
     * SELECT id,name,age,email,manager_id,create_time FROM user WHERE name LIKE ? AND ( age < ? OR email IS NOT NULL )
     * param: []
     * return: void
     * Date: 2019/8/25 14:46
     */
    @Test
    public void selectByLambdaWrapper2() throws Exception {

//    LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
//    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName, "测")
                .and(lqw -> lqw.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        List<User> userList = userMapper.selectList(lambdaQuery);
        userList.forEach(System.out::println);
    }

    /**
     * Description: LambdaQueryChainWrapper的使用
     * param: []
     * return: void
     * Date: 2019/8/25 14:56
     */
    @Test
    public void selectByLambdaWrapper3() throws Exception {
        List<User> userList = new LambdaQueryChainWrapper<User>(userMapper)
                .like(User::getName, "雨").gt(User::getAge, 20).list();
        userList.forEach(System.out::println);
    }

    /******************自定义SQL测试*************************/

    /**
     * Description:使用自定义的SQL语句（条件可以使用lambdaQuery条件构造器）
     * select * from user WHERE name LIKE ? AND ( age < ? OR email IS NOT NULL )
     * param: []
     * return: void
     * Date: 2019/8/25 15:06
     */
    @Test
    public void selectAll() throws Exception {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName, "王")
                .and(lqw -> lqw.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        List<User> userList = userMapper.selectAll(lambdaQuery);
        userList.forEach(System.out::println);
    }

    /******************分页测试*************************/

    /**
     * Description: 分页的基本功能（未添加多表联查的能力，多表联查后需要自定义物理分页）
     * param: []
     * return: void
     * Date: 2019/8/25 15:29
     */
    @Test
    public void selectPage() throws Exception {

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.ge(User::getAge, 20);
        Page<User> page = new Page<User>(4, 2, true);//当前页、每页容量、是否查总数
//        Page<User> page = new Page<User>(4, 2,false);//当前页、每页容量、是否查总数

//        得到的是实体类
       /* IPage<User> iPage=userMapper.selectPage(page,lambdaQuery);
        System.out.println("总页数:"+iPage.getPages());
        System.out.println("总记录数:"+iPage.getTotal());
        System.out.println("当前页数:"+iPage.getCurrent());
        System.out.println("每页数量:"+iPage.getSize());
        List<User> userList= iPage.getRecords();*/

//        得到的是Map数据类型
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, lambdaQuery);
        System.out.println("总页数:" + mapIPage.getPages());
        System.out.println("总记录数:" + mapIPage.getTotal());
        System.out.println("当前页数:" + mapIPage.getCurrent());
        System.out.println("每页数量:" + mapIPage.getSize());
        List<Map<String, Object>> maps = mapIPage.getRecords();
        maps.forEach(System.out::println);
    }


    /**
     * Description:v 自定义物理分页
     * param: []
     * return: void
     * Date: 2019/8/25 15:55
     */
    @Test
    public void selectUserPage() throws Exception {

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.ge(User::getAge, 30);
        Page<User> page = new Page<User>(2, 3, true);//当前页、每页容量、是否查总数
        //        得到的是Map数据类型
        IPage<User> mapIPage = userMapper.selectUserPage(page, lambdaQuery);
        System.out.println("总页数:" + mapIPage.getPages());
        System.out.println("总记录数:" + mapIPage.getTotal());
        System.out.println("当前页数:" + mapIPage.getCurrent());
        System.out.println("每页数量:" + mapIPage.getSize());
        List<User> maps = mapIPage.getRecords();
        maps.forEach(System.out::println);
    }

    /******************更新方法的测试*************************/

    /**
     * Description: 更新用户信息: UPDATE user SET name=?, age=?, email=?, manager_id=?, create_time=? WHERE id=?
     * param: []
     * return: void
     * Date: 2019/8/25 16:04
     */
    @Test
    public void updateById() throws Exception {
        User user = new User();
        user.setId(1165525031879495682L);
        user.setName("测试4");
        user.setAge(22);
        user.setEmail("4404040404@qq.com");
        user.setManagerId(1087982257332887553L);
        user.setCreateTime(LocalDateTime.now());
        user.setRemark("更新完成");
        int rows = userMapper.updateById(user);
        System.out.println("影响行数:" + rows);
    }

    /**
     * Description: 根据更新条件构造器更新用户信息:   UPDATE user SET age=?, email=? WHERE name = ? AND age = ?
     * param: []
     * return: void
     * Date: 2019/8/25 16:08
     */
    @Test
    public void updateByWrapper() throws Exception {

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>();
        userUpdateWrapper.eq("name", "测试4").eq("age", 22);
        User user = new User();
        user.setEmail("848484848@qq.com");
        user.setAge(28);
        int rows = userMapper.update(user, userUpdateWrapper);
        System.out.println("影响行数:" + rows);
    }

    /**
     * Description: 实体作为条件传入到更新构造器中
     * param: []
     * return: void
     * Date: 2019/8/25 16:13
     */
    @Test
    public void updateByWrapper1() throws Exception {

        User whereUser = new User();
        whereUser.setName("测试4");
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>(whereUser);
        User user = new User();
        user.setEmail("444444444@qq.com");
        user.setAge(28);
        int rows = userMapper.update(user, userUpdateWrapper);
        System.out.println("影响行数:" + rows);
    }

    /**
     * Description: 直接在条件构造器中的更新字段数据
     * UPDATE user SET age=? WHERE name = ? AND age = ?
     * param: []
     * return: void
     * Date: 2019/8/25 16:15
     */
    @Test
    public void updateByWrapper2() throws Exception {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>();
        userUpdateWrapper.eq("name", "测试4").eq("age", 28).set("age", 30);
        int rows = userMapper.update(null, userUpdateWrapper);
        System.out.println("影响行数:" + rows);
    }

    /**
     * Description: 使用LambdaUpdateWrapper条件构造器进行数据的更新（增加健壮性）
     * UPDATE user SET age=? WHERE name = ? AND age = ?
     * param: []
     * return: void
     * Date: 2019/8/25 16:22
     */
    @Test
    public void updateByLambdaWrapper() throws Exception {
//        LambdaUpdateWrapper对象的两种创建方式
//        LambdaUpdateWrapper<User> lambdaQueryWrapper = new LambdaUpdateWrapper<User>();
        LambdaUpdateWrapper<User> lambda = Wrappers.<User>lambdaUpdate();
        lambda.eq(User::getName, "测试4").eq(User::getAge, 30).set(User::getAge, 31);
        int rows = userMapper.update(null, lambda);
        System.out.println("影响行数:" + rows);
    }

    /**
     * Description:使用LambdaUpdateChainWrapper进行更新，简易方便
     * UPDATE user SET age=? WHERE name = ? AND age = ?
     * param: []
     * return: void
     * Date: 2019/8/25 16:24
     */
    @Test
    public void updateByLambdaWrapper2() throws Exception {
        boolean flag = new LambdaUpdateChainWrapper<User>(userMapper)
                .eq(User::getName, "测试4").eq(User::getAge, 31).set(User::getAge, 32).update();
        System.out.println("更新结果:" + flag);
    }

    /****************************************删除案例***************************************/
    /**
     * @ Description: 通过主键
     * @params:  * @param
     * @return:void
     **/
    @Test
    public void deleteById() throws Exception {
        int result = userMapper.deleteById(1165071472753135618L);
        System.out.println(result);
    }

    /**
     * @ Description: 通过map构造参数
     * @params:  * @param
     * @return:void
     **/
    @Test
    public void deleteByMap() throws Exception {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name", "测试9");
        objectMap.put("age", 18);
        int result = userMapper.deleteByMap(objectMap);
        System.out.println(result);
    }

    /**
     * @ Description: 批量删除数据
     * @params:  * @param
     * @return:void
     **/
    @Test
    public void deleteBatchIds() throws Exception {
        int result = userMapper.deleteBatchIds(Arrays.asList(1166334606029631490L,1166334509569060866L));
        System.out.println(result);
    }
    /**
     * @ Description: 使用lambda条件构造器删除数据  DELETE FROM user WHERE age = ? OR age > ?
     * @params:  * @param
     * @return:void
     **/
    @Test
    public void deleteByWrapper() throws Exception {
        LambdaQueryWrapper<User> lambdaQueryWrapper= Wrappers.<User>lambdaQuery();
        lambdaQueryWrapper.eq(User::getAge,17).or().gt(User::getAge,40);
        int result=userMapper.delete(lambdaQueryWrapper);
        System.out.println(result);
    }


}