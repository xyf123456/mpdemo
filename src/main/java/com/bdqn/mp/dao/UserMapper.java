package com.bdqn.mp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.mp.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: {@link UserMapper}
 * Description: 用户实体数据访问接口
 * Author: xyf
 * Date 2019/8/22 8:26
 */
public interface UserMapper extends BaseMapper<User>{

//    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    /**
     * Description: 实现物理分页
     * param: [page, wrapper]
     * return: com.baomidou.mybatisplus.core.metadata.IPage<com.bdqn.mp.pojo.User>
     * Date: 2019/8/25 15:48
     */
    IPage<User> selectUserPage(Page<User> page,@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
