package com.wyx.proj.entity;

import java.util.Date;

public class CompanyInfo extends BaseEntity {

    private int id;

    private String comyName;  //公司名称

    private String comyLogokey; //logo图片key

    private String comyIntroduce; //公司简介

    private String comyDetail; //公司详细

    private String comyComment; // 公司备注

    private String comyCity; //城市

    private String comyAddress; //地址

    private String comyPhone; //电话☎️

    private String comyEmail; //邮箱

    private String comyZipcode; //邮编

    private String comyFax; //传真

    private String comyPerson;//法人或者是负责人

    private Date comyRegisttime; //注册时间

    private Date createTime; //创建时间

    private int isInfo; //是否是联系我们的info，还是公司信息，0不info，1是info

    private int isRelease; //是否发布，0不发布，1发布

    private Date releaseTime; //发布时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComyName() {
        return comyName;
    }

    public void setComyName(String comyName) {
        this.comyName = comyName;
    }

    public String getComyLogokey() {
        return comyLogokey;
    }

    public void setComyLogokey(String comyLogokey) {
        this.comyLogokey = comyLogokey;
    }

    public String getComyIntroduce() {
        return comyIntroduce;
    }

    public void setComyIntroduce(String comyIntroduce) {
        this.comyIntroduce = comyIntroduce;
    }

    public String getComyDetail() {
        return comyDetail;
    }

    public void setComyDetail(String comyDetail) {
        this.comyDetail = comyDetail;
    }

    public String getComyComment() {
        return comyComment;
    }

    public void setComyComment(String comyComment) {
        this.comyComment = comyComment;
    }

    public String getComyCity() {
        return comyCity;
    }

    public void setComyCity(String comyCity) {
        this.comyCity = comyCity;
    }

    public String getComyAddress() {
        return comyAddress;
    }

    public void setComyAddress(String comyAddress) {
        this.comyAddress = comyAddress;
    }

    public String getComyPhone() {
        return comyPhone;
    }

    public void setComyPhone(String comyPhone) {
        this.comyPhone = comyPhone;
    }

    public String getComyEmail() {
        return comyEmail;
    }

    public void setComyEmail(String comyEmail) {
        this.comyEmail = comyEmail;
    }

    public String getComyZipcode() {
        return comyZipcode;
    }

    public void setComyZipcode(String comyZipcode) {
        this.comyZipcode = comyZipcode;
    }

    public String getComyFax() {
        return comyFax;
    }

    public void setComyFax(String comyFax) {
        this.comyFax = comyFax;
    }

    public String getComyPerson() {
        return comyPerson;
    }

    public void setComyPerson(String comyPerson) {
        this.comyPerson = comyPerson;
    }

    public Date getComyRegisttime() {
        return comyRegisttime;
    }

    public void setComyRegisttime(Date comyRegisttime) {
        this.comyRegisttime = comyRegisttime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsInfo() {
        return isInfo;
    }

    public void setIsInfo(int isInfo) {
        this.isInfo = isInfo;
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
                +"; comyName:"+ comyName
                +"; comyLogoKey:"+ comyLogokey
                +"; comyIntroduce:"+ comyIntroduce
                +"; comyDetail:"+ comyDetail
                +"; comyComment:"+ comyComment
                +"; comyCity:"+ comyCity
                +"; comyAddress:"+ comyAddress
                +"; comyPhone:"+ comyPhone
                +"; comyEmail:"+ comyEmail
                +"; comyZipcode:"+ comyZipcode
                +"; comyFax:"+ comyFax
                +"; comyPerson:"+ comyPerson
                +"; comyRegisttime:"+ comyRegisttime
                +"; isInfo="+ isInfo
                +"; isRelease="+ isRelease
                +"; releaseTime="+ releaseTime
                +"; createTime="+ createTime +"]";
    }

}
