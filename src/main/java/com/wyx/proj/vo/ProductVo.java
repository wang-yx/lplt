package com.wyx.proj.vo;

import com.wyx.proj.entity.BaseEntity;

import java.util.Date;

public class ProductVo extends BaseEntity {

    private int id;
    private Integer englishid;
    private Integer chineseid;
    private Integer categoryid;
    private String img;
    private String servicehotline; //服务热线
    private String salehotline; //销售热线
    private Date createtime; //创建时间
    private Date updatetime; //创建时间
    private Integer isrelease; //是否发布，0不发布，1发布
    private Date releasetime; //发布时间
    private Integer showhomepage; //是否显示在首页，0不显示，1显示

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

    private String en_name;  //产品名称
    private String en_maker; //制造商
    private String en_dealer; //经销商
    private String en_type; //型号
    private String en_brand; //品牌
    private String en_source; //来源
    private String en_introduce; //产品简介
    private String en_techadvantage; //技术优势
    private String en_techparams; //技术参数
    private String en_applicationarea; //应用场景
    private String en_detail; //产品详细
    private String en_comment; // 公司备注



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEnglishid() {
        return englishid;
    }

    public void setEnglishid(Integer englishid) {
        this.englishid = englishid;
    }

    public Integer getChineseid() {
        return chineseid;
    }

    public void setChineseid(Integer chineseid) {
        this.chineseid = chineseid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getServicehotline() {
        return servicehotline;
    }

    public void setServicehotline(String servicehotline) {
        this.servicehotline = servicehotline;
    }

    public String getSalehotline() {
        return salehotline;
    }

    public void setSalehotline(String salehotline) {
        this.salehotline = salehotline;
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

    public Integer getIsrelease() {
        return isrelease;
    }

    public void setIsrelease(Integer isrelease) {
        this.isrelease = isrelease;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Integer getShowhomepage() {
        return showhomepage;
    }

    public void setShowhomepage(Integer showhomepage) {
        this.showhomepage = showhomepage;
    }

    @Override
    public String toString(){

        return null;
    }

}
