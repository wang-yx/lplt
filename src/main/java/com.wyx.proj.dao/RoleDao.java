package com.wyx.proj.dao;


import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("select * from t_user")
    public List<User> findOne11();
}
