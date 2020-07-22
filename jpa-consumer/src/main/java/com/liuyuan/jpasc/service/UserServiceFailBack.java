package com.liuyuan.jpasc.service;

import com.liuyuan.jpasc.entity.MyPageImpl;
import com.liuyuan.jpasc.entity.User;
import com.liuyuan.jpasc.entity.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFailBack implements UserService{

    @Override
    public MyPageImpl<User> list(UserVo userVo) {
        System.out.println(" 对不起，熔断了。。。。");
        return  null;
    }
}
