package com.wyx.proj.service.impl;

import com.wyx.proj.dao.UserDao;
import com.wyx.proj.entity.User;
import com.wyx.proj.request.Login;
import com.wyx.proj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public List<User> selectAllUsers() throws Exception {

        return getUserDao().selectAllUsers();
    }

    @Override
    public int searchUser(String userName, String passWord){

        return getUserDao().selectUser(userName,passWord);
    }

    @Override
    public int addUser(User user) throws Exception {
        return getUserDao().insertUser(user);
    }

    @Override
    public int deleteUser(Integer id) throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        return getUserDao().batchDeleteUsers(ids);
    }

    @Override
    public User selectUserById(Integer id) throws Exception {
        return getUserDao().selectUserById(id);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return getUserDao().updateUser(user);
    }

    @Override
    public String updatePass(Login login) throws Exception {
        if(login.getNewPassword()==null || login.getNewPassword()==""){
            return "新密码不能为空！";
        }
        if(!login.getNewPassword().equals(login.getNewPassword_again())){
            return "新密码不一致，请确认！";
        }
        List<User> users = getUserDao().selectOneUser(login.getUserName(),login.getPassword());
        if(users.size()>0){
            getUserDao().updatePass(login.getNewPassword(),users.get(0).getId());
        }else{
            return "原密码错误，请确认！";
        }
        return null;
    }



    /**
     *  获取userDao
     * @return
     */
    public UserDao getUserDao() {
        return getBaseDao().getMapper(UserDao.class);
    }
}
