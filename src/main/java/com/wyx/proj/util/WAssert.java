package com.wyx.proj.util;

import com.wyx.proj.exception.StatusCode;
import com.wyx.proj.exception.StatusCodeException;

public class WAssert {

    public static void isTrue(boolean expression){
        if(!expression){
            throw new StatusCodeException("");
        }
    }

    public static void isTrue(boolean expression, String reason){
        if(!expression){
            throw new StatusCodeException(reason);
        }
    }

    public static void isTrue(boolean expression, StatusCode statusCode){
        if(!expression){
            throw new StatusCodeException(statusCode);
        }
    }

    public static void nutNull(Object object){
        if(object == null){
            throw new StatusCodeException("");
        }
    }

    public static void nutNull(Object object, String reason){
        if(object == null){
            throw new StatusCodeException(reason);
        }
    }

    public static void nutNull(Object object, StatusCode statusCode){
        if(object == null){
            throw new StatusCodeException(statusCode);
        }
    }
}
