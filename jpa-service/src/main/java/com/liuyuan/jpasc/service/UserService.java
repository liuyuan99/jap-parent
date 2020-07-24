package com.liuyuan.jpasc.service;

import com.liuyuan.jpasc.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface UserService{

    MyPageImpl list(UserVo userVo);

    boolean del(Integer uid);

    boolean add(@RequestBody User user);

    //获取部门列表
    List<Depart> listDeparts();

    List<Favourite> listFavourites();
}
