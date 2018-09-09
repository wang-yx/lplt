package com.wyx.proj.entity;

import java.util.Date;

//@Table(name="t_user")
public class Prodcategory extends BaseEntity {

    private int id;

    private String catgName;   //类别名称

    private String catgComment; //类别备注

    private Date createTime; //创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public String getCatgComment() {
        return catgComment;
    }

    public void setCatgComment(String catgComment) {
        this.catgComment = catgComment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString(){
        return "User=[id:"+ id
                +"; catgName:"+ catgName
                +"; catgComment="+ catgComment
                +"; createTime="+ createTime +"]";
    }

}
