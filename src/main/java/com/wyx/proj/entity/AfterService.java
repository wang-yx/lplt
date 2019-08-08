package com.wyx.proj.entity;

import java.util.Date;

public class AfterService extends BaseEntity {

    private Integer id;
    private String name;  //报修人名称
    private String phone; //电话☎️
    private String email; //邮箱
    private String industry; //行业
    private String company;  //报修人公司
    private String question;  //报修人问题
    private String reply;  //售后回复
    private Date createtime; //创建时间
    private Date updatetime; //创建时间
    private int isdeal; //是否已经处理回复，0否，1是
    private int isaftersale; //售后0  在线咨询是1


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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

    public int getIsdeal() {
        return isdeal;
    }

    public void setIsdeal(int isdeal) {
        this.isdeal = isdeal;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getIsaftersale() {
        return isaftersale;
    }

    public void setIsaftersale(int isaftersale) {
        this.isaftersale = isaftersale;
    }
}
