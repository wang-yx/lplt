package com.wyx.proj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Info extends BaseEntity {


    private Integer id;
    private Integer chineseid;
    private Integer englishid;
    private String logokey; //logo图片key
    private String phone; //电话☎️

    private String servicehotline; //服务热线
    private String salehotline; //销售热线
    private String videopath; //视频path

    private String email; //邮箱

    private String zipcode; //邮编

    private String fax; //传真

    private String person;//法人或者是负责人
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date registtime; //注册时间

    private Date createtime; //创建时间

    private Date updatetime; //更新时间

    private Integer isinfo; //是否是联系我们的info，还是公司信息，0不info，1是info

    private Integer isrelease; //是否发布，0不发布，1发布

    private Date releasetime; //发布时间

    private Company company_ch;
    private Company company_en;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChineseid() {
        return chineseid;
    }

    public void setChineseid(Integer chineseid) {
        this.chineseid = chineseid;
    }

    public Integer getEnglishid() {
        return englishid;
    }

    public void setEnglishid(Integer englishid) {
        this.englishid = englishid;
    }

    public String getLogokey() {
        return logokey;
    }

    public void setLogokey(String logokey) {
        this.logokey = logokey;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
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

    public Integer getIsinfo() {
        return isinfo;
    }

    public void setIsinfo(Integer isinfo) {
        this.isinfo = isinfo;
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

    public Company getCompany_ch() {
        return company_ch;
    }

    public void setCompany_ch(Company company_ch) {
        this.company_ch = company_ch;
    }

    public Company getCompany_en() {
        return company_en;
    }

    public void setCompany_en(Company company_en) {
        this.company_en = company_en;
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

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }
}
