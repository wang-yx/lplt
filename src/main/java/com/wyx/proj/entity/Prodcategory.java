package com.wyx.proj.entity;

import java.util.Date;
import java.util.List;

public class Prodcategory extends BaseEntity {

    private Integer id;

    private String name;   //类别名称

    private String nameen; //英文类别名

    private String comment; //类别备注

    private Date createtime; //创建时间

    private Integer parent; //上级分类

    private Integer type; //一级分类是1，二分类是2，三级分类是3 ...

    private List<Prodcategory> children;

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

    public String getNameen() {
        return nameen;
    }

    public void setNameen(String nameen) {
        this.nameen = nameen;
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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Prodcategory> getChildren() {
        return children;
    }

    public void setChildren(List<Prodcategory> children) {
        this.children = children;
    }
}
