package com.liuyuan.jpasc.service;

import com.liuyuan.jpasc.entity.MyPageImpl;
import com.liuyuan.jpasc.entity.User;
import com.liuyuan.jpasc.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "jap-service",fallback = UserServiceFailBack.class)
public interface UserService {

    @RequestMapping("/user/list")
    MyPageImpl<User> list(@RequestBody UserVo userVo);
}
