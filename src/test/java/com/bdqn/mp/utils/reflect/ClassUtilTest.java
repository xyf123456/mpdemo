package com.bdqn.mp.utils.reflect;

import com.bdqn.mp.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassUtilTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printClassMessage() throws Exception {
//        User user = new User();
//        ClassUtil.printClassMessage(user);
        String st1 ="";
        ClassUtil.printClassMessage(st1);
    }

}