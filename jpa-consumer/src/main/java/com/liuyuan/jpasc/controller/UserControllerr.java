package com.liuyuan.jpasc.controller;

import com.liuyuan.jpasc.entity.MyPageImpl;
import com.liuyuan.jpasc.entity.User;
import com.liuyuan.jpasc.entity.UserVo;
import com.liuyuan.jpasc.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserControllerr {

    @Autowired
    UserService userService;

    @RequestMapping("list")
    public MyPageImpl<User> list(UserVo userVo){
        System.out.print(" 消费者参数是  " + userVo);
        MyPageImpl<User> page = userService.list(userVo);

        System.out.println ("  消费者 ========== 已经获取数据了。。。。。。。。。。。。");
        page.getContent().iterator().forEachRemaining(x->{System.out.println("消费者  x is " + x);});

        return page;
    }
}
