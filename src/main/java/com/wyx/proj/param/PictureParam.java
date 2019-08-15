package com.wyx.proj.param;


public class PictureParam {

    PictureParam(String base64Str){
        this.base64Str = base64Str;
    }
    PictureParam(){

    }

    public String getBase64Str() {
        return base64Str;
    }

    public void setBase64Str(String base64Str) {
        this.base64Str = base64Str;
    }

    public String base64Str;
}
