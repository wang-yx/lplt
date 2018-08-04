package com.wyx.proj.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";
    private static final int OK = 1;
    private static final int ERR = 0;

    public static ReturnResponse ok(String msg,Object data,Map<String, Object> extendInfo){
        return returnRes(OK,msg, data,extendInfo);
    }

    public static ReturnResponse ok(String msg,Object data){
        return returnRes(OK,msg, data,null);
    }

    public static ReturnResponse ok(Object data){
        return returnRes(OK,"success", data,null);
    }

    public static ReturnResponse err(String msg,Object data,Map<String, Object> extendInfo){
        return returnRes(ERR,msg, data,extendInfo);
    }

    public static ReturnResponse err(String msg,Object data){
        return returnRes(ERR,msg, data,null);
    }

    public static ReturnResponse err(Object data){
        return returnRes(ERR,"error", data,null);
    }

    public static ReturnResponse returnRes(int code,String msg,Object data,Map<String, Object> extendInfo){
        ReturnResponse returnResponse = new ReturnResponse(code,msg,data,extendInfo);
        return returnResponse;
    }


    /**
     * 内部类 返回结果值
     */
    public static class ReturnResponse{
        private int code;
        private String msg;
        private Object data;
        private Map<String, Object> extendInfo = new HashMap<String, Object>();

        public ReturnResponse(int code,String msg,Object data,Map<String, Object> extendInfo){
            this.code = code;
            this.msg = msg;
            this.data = data;
            this.extendInfo = extendInfo;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Map<String, Object> getExtendInfo() {
            return extendInfo;
        }

        public void setExtendInfo(Map<String, Object> extendInfo) {
            this.extendInfo = extendInfo;
        }
    }
}
