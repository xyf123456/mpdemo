package com.bdqn.mp.utils.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName: com.bdqn.mp.utils.reflect.ClassUtil
 * @Description: Class工具类
 * @Author: Administrator
 * @CreateDate: 2019/9/2 0002 下午 10:05
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
public class ClassUtil {
    /**
     * @ Description: 打印类的信息，包含类的成员变量、成员方法
     * @params: * @param object
     * @return:void
     **/
    public static void printClassMessage(Object object) {
//        要获取类的信息，首先要获取类的类类型
        Class c = object.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
//        获取类的名称
        System.out.print("类的名称:" + c.getName());
//        通过Method类，方法对象
//            一个成员方法就是一个Method对象
//        getMethods():获取所有public 的方法，包括从父类继承过来的
//        getDeclaredMethods():获取所有该类自己声明的方法，不问访问权限
        Method[] ms = c.getMethods(); //        c.getDeclaredMethods();
        for (int i = 0; i < ms.length; i++) {
//            得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
//            得到方法的名称
            System.out.println(ms[i].getName() + "(");
            //获取参数的类型--》获取的是参数列表的类型的类类型
            Class[] parameterTypes = ms[i].getParameterTypes();
            for (Class class1 :
                    parameterTypes) {
                System.out.println(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

}
