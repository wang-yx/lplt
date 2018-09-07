package com.wyx.proj.entity;

import java.util.Date;

public class Product extends BaseEntity {

    private int id;

    private String prodName;  //产品名称

    private int prodCatg; //产品分类

    private String prodImgskey; //小图片，目录中显示

    private String prodImgmkey; //中图片，list中显示

    private String prodImglkey; //大图片

    private String prodIntroduce; //产品简介

    private String prodDetail; //产品详细

    private String prodComment; // 公司备注

    private Date createTime; //创建时间

    private int isRelease; //是否发布，0不发布，1发布

    private Date releaseTime; //发布时间

    private int showHomepage; //是否显示在首页，0不显示，1显示


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdCatg() {
        return prodCatg;
    }

    public void setProdCatg(int prodCatg) {
        this.prodCatg = prodCatg;
    }

    public String getProdImgskey() {
        return prodImgskey;
    }

    public void setProdImgskey(String prodImgskey) {
        this.prodImgskey = prodImgskey;
    }

    public String getProdImgmkey() {
        return prodImgmkey;
    }

    public void setProdImgmkey(String prodImgmkey) {
        this.prodImgmkey = prodImgmkey;
    }

    public String getProdImglkey() {
        return prodImglkey;
    }

    public void setProdImglkey(String prodImglkey) {
        this.prodImglkey = prodImglkey;
    }

    public String getProdIntroduce() {
        return prodIntroduce;
    }

    public void setProdIntroduce(String prodIntroduce) {
        this.prodIntroduce = prodIntroduce;
    }

    public String getProdDetail() {
        return prodDetail;
    }

    public void setProdDetail(String prodDetail) {
        this.prodDetail = prodDetail;
    }

    public String getProdComment() {
        return prodComment;
    }

    public void setProdComment(String prodComment) {
        this.prodComment = prodComment;
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

    @Override
    public String toString(){
        return "User=[id:"+ id
                +"; prodName:"+ prodName
                +"; prodCatg:"+ prodCatg
                +"; prodImgskey:"+ prodImgskey
                +"; prodImgmkey:"+ prodImgmkey
                +"; prodImglkey:"+ prodImglkey
                +"; prodIntroduce:"+ prodIntroduce
                +"; prodDetail:"+ prodDetail
                +"; prodComment:"+ prodComment
                +"; showHomepage="+ showHomepage
                +"; isRelease="+ isRelease
                +"; releaseTime="+ releaseTime
                +"; createTime="+ createTime +"]";
    }

}
