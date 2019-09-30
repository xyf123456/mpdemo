package com.bdqn.mp.utils.reflect;

public class OfficeBetter {
    public static void main(String args[]){

        try{
            //动态加载类，在运行时刻加载类
            Class c1 = Class.forName(args[0]);
            //通过动态加载创建对象
            //Word word=(Word)c1.newInstance();
            //Excel excel=(Excel)c1.newInstance();
            OfficeAble oa = (OfficeAble)c1.newInstance();
            oa.start();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
