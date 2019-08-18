package com.wyx.proj.param;


public class PictureParam {

    private String base64Str;

    private String pictureInfo;

    PictureParam(String base64Str,String pictureInfo){
        this.base64Str = base64Str;
        this.pictureInfo = pictureInfo;
    }
    PictureParam(){

    }

    public String getBase64Str() {
        return base64Str;
    }

    public void setBase64Str(String base64Str) {
        this.base64Str = base64Str;
    }

    public String getPictureInfo() {
        return pictureInfo;
    }

    public void setPictureInfo(String pictureInfo) {
        this.pictureInfo = pictureInfo;
    }
}
