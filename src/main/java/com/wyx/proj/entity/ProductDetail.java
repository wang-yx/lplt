package com.wyx.proj.entity;

import java.util.Date;

public class ProductDetail extends BaseEntity {

    private int id;
    private String name;  //产品名称
    private String maker; //制造商
    private String dealer; //经销商
    private String type; //型号
    private String brand; //品牌
    private String source; //来源
    private String introduce; //产品简介
    private String techadvantage; //技术优势
    private String techparams; //技术参数
    private String applicationarea; //应用场景
    private String detail; //产品详细
    private String comment; // 公司备注
    private Date createtime; //创建时间
    private Date updatetime; //更新时间
    private Integer language; //是否发布，0不发布，1发布


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTechadvantage() {
        return techadvantage;
    }

    public void setTechadvantage(String techadvantage) {
        this.techadvantage = techadvantage;
    }

    public String getTechparams() {
        return techparams;
    }

    public void setTechparams(String techparams) {
        this.techparams = techparams;
    }

    public String getApplicationarea() {
        return applicationarea;
    }

    public void setApplicationarea(String applicationarea) {
        this.applicationarea = applicationarea;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    @Override
    public String toString(){
        return null;
    }

}
