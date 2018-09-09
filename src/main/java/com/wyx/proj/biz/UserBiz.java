package com.wyx.proj.biz;

import com.google.common.base.Strings;
import com.wyx.proj.common.BizTemplate;
import com.wyx.proj.request.Login;
import com.wyx.proj.service.UserService;
import com.wyx.proj.util.WAssert;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserBiz {

    @Resource
    private UserService userService;

    public String userLogin(final Login login){
        return new BizTemplate<String>() {
            @Override
            public void checkParams() {
                WAssert.nutNull(login, "参数不能为空");
                WAssert.isTrue(Strings.isNullOrEmpty(login.getUserName()), "用户名不能为空");
                WAssert.isTrue(Strings.isNullOrEmpty(login.getPassword()), "密码不能为空");
            }

            @Override
            public String process() {
                WAssert.isTrue(userService.searchUser(login.getUserName(), login.getPassword()) > 0, "用户名或密码错误");
                return "登录成功";
            }
        }.execute();
    }

}
