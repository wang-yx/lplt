package com.wyx.proj.bean;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class ProdCategoryBean {

    private Integer id;

    private String name;   //类别名称

    private String nameen; //英文类别名

    private Integer parent; //上级分类

    private Integer type; //一级分类是1，二分类是2，三级分类是3 ...

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
}
