package com.wyx.proj.entity;

import java.util.Date;

public class New extends BaseEntity {

    private Integer id;
    private Integer englishid;
    private Integer chineseid;
    private String img; //图片 关联图片id
    private Date updatetime; //创建时间
    private Date createtime; //创建时间
    private Integer isrelease; //是否发布，0不发布，1发布
    private Date releasetime; //发布时间
    private Integer showhomepage; //是否显示在首页，0不显示，1显示
    private Integer readnum;//浏览量

    private String name; //只用于展示name（中英文都会用到）
    private String introduce; //只用于展示introduce（中英文都会用到）

    private NewDetail newDetail_ch;
    private NewDetail newDetail_en;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewDetail getNewDetail_ch() {
        return newDetail_ch;
    }

    public void setNewDetail_ch(NewDetail newDetail_ch) {
        this.newDetail_ch = newDetail_ch;
    }

    public NewDetail getNewDetail_en() {
        return newDetail_en;
    }

    public void setNewDetail_en(NewDetail newDetail_en) {
        this.newDetail_en = newDetail_en;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
