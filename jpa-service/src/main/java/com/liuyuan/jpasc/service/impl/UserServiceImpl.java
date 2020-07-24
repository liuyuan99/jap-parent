package com.liuyuan.jpasc.service.impl;

import com.liuyuan.jpasc.entity.*;
import com.liuyuan.jpasc.repository.DepartRepository;
import com.liuyuan.jpasc.repository.FavouritesrRepository;
import com.liuyuan.jpasc.repository.UserRepository;
import com.liuyuan.jpasc.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartRepository departRepository;

    @Autowired
    private FavouritesrRepository favouritesrRepository;

    @Override
    public MyPageImpl<User> list(UserVo userVo) {

        Specification specification = new Specification<UserVo>() {
            //动态生成
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                //根据username查询条件
                if(!StringUtils.isEmpty(userVo.getUsername())){
                    //第一个查询参数
                    Predicate username = criteriaBuilder.like(root.get("username"), "%" + userVo.getUsername() + "%");
                    list.add(username);
                }
                if(!StringUtils.isEmpty(userVo.getName())){
                    //第一个查询参数
                    Predicate name = criteriaBuilder.like(root.get("name"), "%" + userVo.getName() + "%");
                    list.add(name);
                }
                if(userVo.getSex()!=null){
                    //第一个查询参数
                    Predicate sex = criteriaBuilder.equal(root.get("sex"), userVo.getSex());
                    list.add(sex);
                }
                //获取条件的数组
                Predicate[] predicates = list.toArray(new Predicate[list.size()]);
                //把前述的所有条件组合生成一个条件
                Predicate predicateAll = criteriaBuilder.and(predicates);
                return predicateAll;
            }
        };

        // 生成分页的对象
        Pageable pageable = PageRequest.of(userVo.getPage(),userVo.getPageSize(), Sort.Direction.DESC,"uid");
       // Page<User> userPage = userRepository.findAll(pageable);
        Page page = userRepository.findAll(specification, pageable);
        return new MyPageImpl(page);
    }

    @Override
    public boolean del(Integer uid) {
        try {
            userRepository.deleteById(uid);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean add(User user) {
        try {
            User user1 = userRepository.saveAndFlush(user);
            if(user1.getUid()>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //获取部门列表
    @Override
    public List<Depart> listDeparts() {
        return  departRepository.findAll();
    }

    @Override
    public List<Favourite> listFavourites() {
        return favouritesrRepository.findAll();
    }
}



