package com.wyx.proj.common;

import com.wyx.proj.exception.StatusCodeException;

import java.util.Objects;

public abstract class BizTemplate<T> {

    public abstract void checkParams();

    public abstract T process() throws Exception;

    public T execute(){
        try{
            this.checkParams();
        }catch (IllegalArgumentException e1){
            throw new StatusCodeException("参数校验失败");
        }catch (StatusCodeException e2){
            throw e2;
        }catch (Exception e3){
            throw new StatusCodeException("网络异常");
        }

        T result;
        try {
            result = process();
        } catch (Exception e) {
            throw new StatusCodeException("服务异常");
        }

        return result;
    }

}
