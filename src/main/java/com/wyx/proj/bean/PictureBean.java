package com.wyx.proj.bean;

import com.wyx.proj.entity.BaseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class PictureBean {

    private String imgPath; //图片路径

    private String imgCatg; //是首页图片0，新闻中的图片1，还是产品的图片2

    private String imgComment; //图片备注

    private int isRelease; //是否发布，0不发布，1发布

    private MultipartFile file;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgCatg() {
        return imgCatg;
    }

    public void setImgCatg(String imgCatg) {
        this.imgCatg = imgCatg;
    }

    public String getImgComment() {
        return imgComment;
    }

    public void setImgComment(String imgComment) {
        this.imgComment = imgComment;
    }

    public int getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(int isRelease) {
        this.isRelease = isRelease;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "User=["
                + " imgPath:" + imgPath
                + "; imgCatg:" + imgCatg
                + "; imgComment:" + imgComment
                + "; isRelease=" + isRelease
                + "; fileName=" + file.getOriginalFilename() + "]";
    }

}
