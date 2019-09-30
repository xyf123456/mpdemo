package com.bdqn.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdqn.mp.dao.UserMapper;
import com.bdqn.mp.pojo.User;
import com.bdqn.mp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: com.bdqn.mp.service.impl.UserServiceImpl
 * @Description: 用户业务接口实现类
 * @Author:      Administrator
 * @CreateDate: 2019/8/27 0027 下午 11:12
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
}
