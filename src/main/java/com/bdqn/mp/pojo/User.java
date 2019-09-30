package com.bdqn.mp.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName: {@link User}
 * Description: 用户实体类
 * Author: xyf
 * Date 2019/8/22 8:24
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
//@TableName(value = "tt_user")
public class User extends Model<User>{

    private static final long serialVersionUID = -5401427933776737772L;
    //主键,主键策略分为局部策略和全局策略，这里设置为局部主键策略，优于全局主键策略
//    @TableId
//    @TableId(type = IdType.AUTO) //自增长策略  alter TABLE `user` CHANGE COLUMN id id BIGINT(20) auto_increment;
//    @TableId(type = IdType.NONE) //默认测试，跟随全局的主键配置
//    @TableId(type = IdType.INPUT) //自己设置主键的值
    private Long id;
    /****以下三种主键策略，只有插如何对象ID为空，才能自动填充id****/
//    @TableId(type = IdType.UUID) //UUID的主键策略，主键为String类型，数据库也需要改为varchar类型
//    @TableId(type = IdType.ID_WORKER_STR) //ID_WORKER_STR的主键策略，主键为String类型，数据库也需要改为varchar类型
//    @TableId(type = IdType.ID_WORKER) //ID_WORKER的主键策略，主键为Integer类型，数据库也需要改为bigint类型
//    private Long id;
//    private Long userId;
    //姓名
    @TableField(condition = SqlCondition.LIKE,strategy = FieldStrategy.NOT_EMPTY)
    private String name;
//    @TableField(value = "name")
//    private String realName;
    //年龄
@TableField(condition = "%s&lt;#{%s}")
    private Integer age;
    //邮箱
    private String email;
    //直属上级
    private Long managerId;
    //创建时间
    private LocalDateTime createTime;

    //备注（排除非表字段的方式）
    @TableField(exist = false)
    private String remark;
//    (排除非表字段的方式1）
//        private transient String remark;

    //    (排除非表字段的方式2）
   /* private static String remark;

    public static String getRemark() {
        return remark;
    }

    public static void setRemark(String remark) {
        User.remark = remark;
    }*/
}
