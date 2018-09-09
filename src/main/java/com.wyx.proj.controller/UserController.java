package com.wyx.proj.controller;


import com.alibaba.fastjson.JSON;
import com.wyx.proj.entity.User;
import com.wyx.proj.service.UserService;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "getAllUsers",method = RequestMethod.GET)
    public Object getAllUsers(){
        logger.info("---getAllUsers--->"+"this is getAllUsers");
        List<User> users = null;
        try {
            users = userService.selectAllUsers();
        } catch (Exception e) {
            logger.error("error:"+e.getMessage());
            return ResponseUtil.err(e.getMessage(),null);
        }
        return ResponseUtil.ok(users);
    }

    /**
     * 根据用户名密码验证用户
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping(value = "selectUserAndPwd",method = RequestMethod.POST)
    public Object  selectUserAndPwd(@FormParam("userName")String userName,@FormParam("passWord")String passWord){

        logger.info("---selectUserAndPwd--params->userName="+ userName +", passWord="+passWord);

        int isExsit = 0;
        try {
            isExsit = userService.searchUser(userName,passWord);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),null);
        }
        if(isExsit==0){
            return ResponseUtil.err("密码或者用户名不正确",null);
        }

        HashMap<String,Integer> mapRrt = new HashMap<>();
        mapRrt.put("isExsit",1);

        return ResponseUtil.ok(mapRrt);
    }

    public Object addUser(@FormParam("userJson") String userJson){

        logger.info("---addUser--params->userJson="+ userJson);

        User user = JSON.parseObject(userJson,User.class);
        int returnNum = 1;
        try {
            returnNum = userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err("保存失败："+e.getMessage(),"");
        }
        if (returnNum!=1){
            return ResponseUtil.err("保存失败："+e.getMessage(),"");
        }
        return ResponseUtil.ok("保存成功","");
    }

}
