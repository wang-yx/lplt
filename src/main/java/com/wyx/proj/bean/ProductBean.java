package com.wyx.proj.bean;

import java.util.Date;

public class ProductBean extends BaseBean {

    private String prodName;

    private Integer prodCatg;

    private Integer isRelease;

    private Integer showHomePage;

    private Date startTime;

    private Date endTime;

    public Integer getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getShowHomePage() {
        return showHomePage;
    }

    public void setShowHomePage(Integer showHomePage) {
        this.showHomePage = showHomePage;
    }

    public Integer getProdCatg() {
        return prodCatg;
    }

    public void setProdCatg(Integer prodCatg) {
        this.prodCatg = prodCatg;
    }
}
