package com.bdqn.mp.pojo;

import java.io.Serializable;
/**
 * ClassName: {@link Student}
 * Description: 学生类（用于测试）
 * Author: xyf
 * Date 2019/8/31 11:55
 */
public class Student implements Serializable{

    private static final long serialVersionUID = 6691131929635346468L;
    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getAge() != student.getAge()) return false;
        return getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        return result;
    }
}
