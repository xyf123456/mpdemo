package com.bdqn.mp.pojo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @ClassName: UserTest
 * @Description: 反射测试类
 * @Author:      Administrator
 * @CreateDate: 2019/9/2 0002 下午 10:01
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Description: 测试对象的比较
     * param: []
     * return: void
     * Date: 2019/8/31 11:49
     */
    @Test
    public void test() throws Exception {
        /*如果根据equals(java.lang.Object)方法，两个对象不相等，那么对这两个对象中的任一对象上调用 hashCode
        方法不一定生成不同的整数结果。但是，程序员应该意识到，为不相等的对象生成不同整数结果可以提高哈希表的性能。*/
        Student student = new Student();
        student.setAge(12);
        student.setName("张三");
        Student student1 = new Student();
        student1.setAge(12);
        student1.setName("张三");
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
        System.out.println(student);
        System.out.println(student1);
        System.out.println(student.equals(student1));
    }

    /**
     * Description: 测试反射
     * param: []
     * return: void
     * Date: 2019/8/31 12:16
     */
    @Test
    public void testReflect() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        类也是个对象，这个对象是Class类的实例对象（）
//        Class 类的相关信息(三种创建对象的方式)第一种 通过 .class方式, c1,c2... 为Class 类的 实例对象，告诉我们每个类有个默认的静态变量class
//        官方: c3 表示了User类的类类型，也就是c3为User类的类类型，一个类只是Class类的一个实例对象
        /*User user = new User();
        Class cl = String.class;
        Class c2 = void.class;
        Class c3 = User.class;
        Class c4 = Object.class;
        Class c5 = Class.class;
        System.out.println(cl);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);*/
//        第二种种方式，已知该类的对象 通过getClass()获取Class 类的实例对象  （强调：只要是类的对象都能获取类的信息）
        // 官方: cl 表示了User类的类类型 ，也就是c1为User类的类类型，一个类只是Class类的一个实例对象
      /*  User user = new User();
        String str1 = "";
        String str2= "哈哈";
        Class cl = user.getClass();
        Class c2 = str1.getClass();
        Class c3 = str2.getClass();
        System.out.println(cl);
        System.out.println(c2);
        System.out.println(c3);*/
//        第三种方式 通过Class的forName()方法
        /*Class cl= null;
       cl=Class.forName("java.lang.Object");
//        Class c2=Class.forName("java.lang.Object1");//找不到类
        Class c3=Class.forName("com.bdqn.mp.pojo.User");//找不到类
        System.out.println(cl);
//        System.out.println(c2);
        System.out.println(c3);*/
        /************************************既然得到了该类的类类型，我们也可以创建该类的对象*****************************************/
        Student student = new Student();
        Class c1 = User.class;
        Class c2 = student.getClass();
        Class c3 = Class.forName("com.bdqn.mp.pojo.Student");
        System.out.println(c1==c2);
        System.out.println(c3==c2);
//        通过类的类类型创建该类的对象（今天骑自行车，差点摔倒，我一把把把把住了；我也想过过儿过过的生活）
        //前提要求User需要有无参数的构造方法
        Student student1= (Student) c1.newInstance();

        //        Class.forName("类的全称"):
        // 不仅表示了类的类类型，还代表了动态加载类
        //区分编译、运行
//        编译时刻加载类是静态加载类、运行时刻加载类是动态加
    }

    @Test
    public void testReflect1(){
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = double.class;
        System.out.println(c2.getTypeName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());
    }


}