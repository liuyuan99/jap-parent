package com.liuyuan.jpasc.controller;

import com.liuyuan.jpasc.entity.*;
import com.liuyuan.jpasc.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("del")
    public boolean del(@RequestParam(value = "uid") Integer uid){
        return userService.del(uid);
    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        return userService.add(user);
    }

    //获取部门列表
    @RequestMapping("departs")
    public List<Depart> getDeparts(){
        return userService.listDeparts();
    }

    //获取爱好列表
    @RequestMapping("favourites")
    public List<Favourite> getFavourites(){
        return userService.listFavourites();
    }
}
