package com.liuyuan.jpasc.service;

import com.liuyuan.jpasc.entity.MyPageImpl;
import com.liuyuan.jpasc.entity.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface UserService{


    MyPageImpl list(UserVo userVo);
}
