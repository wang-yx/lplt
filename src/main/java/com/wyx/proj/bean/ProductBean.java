package com.wyx.proj.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductBean extends BaseBean {

    private String name;

    private String type;

    private String brand;

    private Integer language;

    private Integer categoryid;

    private Integer isrelease;

    private Integer showhomepage;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date starttime;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getIsrelease() {
        return isrelease;
    }

    public void setIsrelease(Integer isrelease) {
        this.isrelease = isrelease;
    }

    public Integer getShowhomepage() {
        return showhomepage;
    }

    public void setShowhomepage(Integer showhomepage) {
        this.showhomepage = showhomepage;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date startime) {
        this.starttime = startime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
