package com.wyx.proj.controller;


import com.wyx.proj.entity.User;
import com.wyx.proj.service.UserService;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
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

        List<User> users = null;
        try {
            users = userService.selectAllUsers();
        } catch (Exception e) {
            return ResponseUtil.err(e.getMessage(),null);
        }
        return ResponseUtil.ok(users);
    }

}
