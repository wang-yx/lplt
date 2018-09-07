package com.wyx.proj.entity;

import java.util.Date;

public class News extends BaseEntity {

    private int id;

    private String newName;  //新闻名称

    private String newImgskey; //小图片，目录中显示

    private String newImgmkey; //中图片，list中显示

    private String newImglkey; //大图片

    private String newIntroduce; //新闻简介

    private String newDetail; //新闻详细

    private String newComment; // 新闻备注

    private Date createTime; //创建时间

    private int isRelease; //是否发布，0不发布，1发布

    private Date releaseTime; //发布时间

    private int showHomepage; //是否显示在首页，0不显示，1显示

    private int readNum;//浏览量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewImgskey() {
        return newImgskey;
    }

    public void setNewImgskey(String newImgskey) {
        this.newImgskey = newImgskey;
    }

    public String getNewImgmkey() {
        return newImgmkey;
    }

    public void setNewImgmkey(String newImgmkey) {
        this.newImgmkey = newImgmkey;
    }

    public String getNewImglkey() {
        return newImglkey;
    }

    public void setNewImglkey(String newImglkey) {
        this.newImglkey = newImglkey;
    }

    public String getNewIntroduce() {
        return newIntroduce;
    }

    public void setNewIntroduce(String newIntroduce) {
        this.newIntroduce = newIntroduce;
    }

    public String getNewDetail() {
        return newDetail;
    }

    public void setNewDetail(String newDetail) {
        this.newDetail = newDetail;
    }

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
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

    public int getShowHomepage() {
        return showHomepage;
    }

    public void setShowHomepage(int showHomepage) {
        this.showHomepage = showHomepage;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    @Override
    public String toString(){
        return "User=[id:"+ id
                +"; newName:"+ newName
                +"; newImgskey:"+ newImgskey
                +"; newImgmkey:"+ newImgmkey
                +"; newImglkey:"+ newImglkey
                +"; newIntroduce:"+ newIntroduce
                +"; newDetail:"+ newDetail
                +"; newComment:"+ newComment
                +"; showHomepage="+ showHomepage
                +"; readNum="+ readNum
                +"; isRelease="+ isRelease
                +"; releaseTime="+ releaseTime
                +"; createTime="+ createTime +"]";
    }

}