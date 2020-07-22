package com.liuyuan.jpasc.controller;

import com.liuyuan.jpasc.entity.MyPageImpl;
import com.liuyuan.jpasc.entity.User;
import com.liuyuan.jpasc.entity.UserVo;
import com.liuyuan.jpasc.repository.UserRepository;
import com.liuyuan.jpasc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("list")
    public MyPageImpl<User> list(UserVo userVo){
        System.out.print(" 服务提供者  参数是  " + userVo);

        MyPageImpl<User> userPage = userService.list(userVo);
        log.info(" 已经获取数据了。。。。。。。。。。。。");
        userPage.getContent().iterator().forEachRemaining(x->{System.out.println("x is " + x);});
        log.info("page.class is " + userPage.getClass());
        return userPage;
    }
}
