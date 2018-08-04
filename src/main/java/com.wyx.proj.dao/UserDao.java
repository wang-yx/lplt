package com.wyx.proj.dao;


import com.wyx.proj.entity.User;

import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserDao {

    @Select("select id,user_name from t_user ")
    @Results({
        @Result(property = "userName",column = "user_name")
    })
    public List<User> selectAll();
}
