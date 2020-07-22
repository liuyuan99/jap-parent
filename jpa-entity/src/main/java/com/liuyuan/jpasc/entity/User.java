package com.liuyuan.jpasc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="jpa_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 标注用于声明一个实体类的属性映射为数据库的主键列。**/
    @Id
    /** 用于标注主键的生成策略，通过strategy 属性指定。**/
    /** JPA 自动选择一个最适合底层数据库的主键生成策略**/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    // 用户名
    private String username;
    // 密码
    private String password;
     // 姓名
    private String name;
    // 邮箱
    private String email;
    // 电话
    private String telephone;
    // 出生日期
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    // 性别
    private Integer sex;
    // 状态
    private Integer state;

    private String code;

}