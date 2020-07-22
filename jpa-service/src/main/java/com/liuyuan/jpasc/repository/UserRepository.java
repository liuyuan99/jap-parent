package com.liuyuan.jpasc.repository;

import com.liuyuan.jpasc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
