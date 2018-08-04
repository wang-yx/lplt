package com.wyx.proj.service;

import com.wyx.proj.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    public List<User> selectAllUsers () throws Exception;

}
