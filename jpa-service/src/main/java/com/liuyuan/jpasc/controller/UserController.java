package com.liuyuan.jpasc.controller;

import com.liuyuan.jpasc.entity.*;
import com.liuyuan.jpasc.repository.UserRepository;
import com.liuyuan.jpasc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(
        value = "没有什么意义",
        tags = {"用户","管理"}
)
@RestController
@RequestMapping("user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("test1")
    public String test1(){
        User user = new User();
        user.setName("aaaa");
        userRepository.save(user);
        return "ok";
    }

    //对list方法的说明
    @ApiOperation(value = "获取用户列表",notes = "获取用户列表，用户列表的信息主要包含姓名，性别，等个人信息",
            response = MyPageImpl.class,httpMethod = "GET")
    @RequestMapping("list")
    @ApiResponse(code = 200,message="返回的MyPageImpl对象",response=MyPageImpl.class)
    public MyPageImpl<User> list(@ApiParam(name="userVo",value = "UserVo的对象",defaultValue = "") UserVo userVo){
        System.out.print(" 服务提供者  参数是  " + userVo);

        MyPageImpl<User> userPage = userService.list(userVo);
        log.info(" 已经获取数据了。。。。。。。。。。。。");
        userPage.getContent().iterator().forEachRemaining(x->{System.out.println("x is " + x);});
        log.info("page.class is " + userPage.getClass());
        return userPage;
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
