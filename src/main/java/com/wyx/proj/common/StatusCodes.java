package com.wyx.proj.common;

import com.wyx.proj.exception.StatusCode;

public class StatusCodes {

    private static StatusCode of(int status, String reason) {
        return new StatusCode(status, reason);
    }

    public interface UserLogin {
        StatusCode PASSWORD_ERROR = of(-100010, "用户名密码错误");
    }
}
