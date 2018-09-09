package com.wyx.proj.controller;


import com.wyx.proj.entity.User;
import com.wyx.proj.service.ProductService;
import com.wyx.proj.service.UserService;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value="/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object getAllUsers(){

        List<User> users = null;
        try {
            productService.selectAllPics();
        } catch (Exception e) {
            return ResponseUtil.err(e.getMessage(),null);
        }
        return ResponseUtil.ok(users);
    }

}
