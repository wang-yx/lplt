package com.wyx.proj.entity;

import java.util.Date;

public class Picture extends BaseEntity {

    private int id;

    private String imgKey; //图片的key

    private String imgPath; //图片路径

    private String imgCatg; //是首页图片0，新闻中的图片1，还是产品的图片2

    private String imgComment; //图片备注

    private Date createTime; //创建时间

    private int isRelease; //是否发布，0不发布，1发布

    private Date releaseTime; //发布时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgKey() {
        return imgKey;
    }

    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(int isRelease) {
        this.isRelease = isRelease;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString(){
        return "User=[id:"+ id
                +"; imgKey:"+ imgKey
                +"; imgPath:"+ imgPath
                +"; imgCatg:"+ imgCatg
                +"; imgComment:"+ imgComment
                +"; isRelease="+ isRelease
                +"; releaseTime="+ releaseTime
                +"; createTime="+ createTime +"]";
    }

}
