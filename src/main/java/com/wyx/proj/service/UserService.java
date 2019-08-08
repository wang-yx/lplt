package com.wyx.proj.service;

import com.wyx.proj.entity.User;
import com.wyx.proj.request.Login;

import java.util.List;

public interface UserService extends BaseService<User> {

    public List<User> selectAllUsers() throws Exception;

    public int searchUser(String userName, String passWord);

    public int addUser(User user) throws Exception;

    public int deleteUser(Integer id) throws Exception;

    public User selectUserById(Integer id) throws Exception;

    /**
     * 根据id修改User
     *
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser(User user) throws Exception;

    public String updatePass(Login login) throws Exception;

}
