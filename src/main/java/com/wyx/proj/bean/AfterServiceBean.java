package com.wyx.proj.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AfterServiceBean extends BaseBean {

    private String name;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date starttime;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endtime;

    private String industry;

    private Integer isaftersale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getIsaftersale() {
        return isaftersale;
    }

    public void setIsaftersale(Integer isaftersale) {
        this.isaftersale = isaftersale;
    }
}
