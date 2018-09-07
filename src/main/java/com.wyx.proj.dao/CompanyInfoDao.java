package com.wyx.proj.dao;


import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CompanyInfoDao {

    @Select("select id,user_name from t_user ")
    @Results({
        @Result(property = "userName",column = "user_name")
    })
    public List<User> selectAll();
}
