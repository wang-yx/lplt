package com.wyx.proj.service.impl;

import com.wyx.proj.dao.BaseDao;
import com.wyx.proj.dao.UserDao;
import com.wyx.proj.entity.User;
import com.wyx.proj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public List<User> selectAllUsers() throws Exception {

        List<User> users = getUserDao().selectAll();

        System.out.println("--------->"+users.size());
        System.out.println("--------->"+users.toString());


        logger.info("-----log--->"+users.toString());

        return users;
    }



    /**
     *  获取userDao
     * @return
     */
    public UserDao getUserDao() {
        return getBaseDao().getMapper1(UserDao.class);
    }
}
