package com.wyx.proj.entity;

import java.util.Date;

public class Product extends BaseEntity {

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
    private Integer ordernum; //产品排序用

    private String name;  //这个name只做临时展现用
    private String categoryname; //这个name只做临时展现用

    private ProductDetail detail_ch;

    private ProductDetail detail_en;

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

    public ProductDetail getDetail_ch() {
        return detail_ch;
    }

    public void setDetail_ch(ProductDetail detail_ch) {
        this.detail_ch = detail_ch;
    }

    public ProductDetail getDetail_en() {
        return detail_en;
    }

    public void setDetail_en(ProductDetail detail_en) {
        this.detail_en = detail_en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    @Override
    public String toString(){

        return null;
    }

}
