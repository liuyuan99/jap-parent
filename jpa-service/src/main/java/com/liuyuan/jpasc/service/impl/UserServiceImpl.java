package com.liuyuan.jpasc.service.impl;

import com.liuyuan.jpasc.entity.MyPageImpl;
import com.liuyuan.jpasc.entity.User;
import com.liuyuan.jpasc.entity.UserVo;
import com.liuyuan.jpasc.repository.UserRepository;
import com.liuyuan.jpasc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyPageImpl<User> list(UserVo userVo) {
        // 生成分页的对象
        Pageable pageable = PageRequest.of(userVo.getPage(),userVo.getPageSize(), Sort.Direction.DESC,"uid");
        PageImpl<User> userPage = (PageImpl<User>)userRepository.findAll(pageable);
        return new MyPageImpl(userPage);
    }
}
