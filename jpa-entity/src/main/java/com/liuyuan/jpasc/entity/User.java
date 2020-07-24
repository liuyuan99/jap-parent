package com.liuyuan.jpasc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    // 性别
    private Integer sex;
    // 状态
    private Integer state;

    private String code;

    //一对一
    @OneToOne(targetEntity = DriverCard.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",insertable = true,updatable = false,nullable = false)
    private DriverCard driverCard;

    //多对一
    @ManyToOne(targetEntity = Depart.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "depart_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true,
        foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private Depart depart;

    //一对多  有了多对多需要变成懒加载FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "uid",insertable = true,updatable = true,nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Room> roomList;

    //多对多
    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinTable(name="hg_user_favourite",
            // 本表与中间表的关系 one to many
            joinColumns={@JoinColumn(name = "user_id",referencedColumnName = "uid",foreignKey=@ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            // 描述的中间表与目标表的对应关系  many to one
            inverseJoinColumns = {@JoinColumn(name = "favourite_id",referencedColumnName = "id",foreignKey=@ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            //唯一约束
            uniqueConstraints={@UniqueConstraint(name="unit",columnNames={"user_id","favourite_id"})}
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Favourite> favouriteList;
}