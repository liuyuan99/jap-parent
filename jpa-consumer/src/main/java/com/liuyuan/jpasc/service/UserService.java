package com.liuyuan.jpasc.service;

import com.liuyuan.jpasc.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "jap-service",fallback = UserServiceFailBack.class)
public interface UserService {

    @RequestMapping("/user/list")
    MyPageImpl<User> list(UserVo userVo);

    @RequestMapping("/user/del")
    boolean del(@RequestParam(value = "uid") Integer uid);

    @RequestMapping("/user/add")
    boolean add(@RequestBody User user);

    @RequestMapping("/user/departs")
    List<Depart> listDeparts();

    //获取爱好列表
    @RequestMapping("/user/favourites")
    List<Favourite> listFavourites();
}
