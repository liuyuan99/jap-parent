package com.liuyuan.jpasc.repository;

import com.liuyuan.jpasc.entity.Depart;
import com.liuyuan.jpasc.entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouritesrRepository extends JpaRepository<Favourite,Integer> {
}
