package com.wyx.proj.bean;

import com.wyx.proj.request.PageRequest;

import java.util.List;

public class PageResponseBean<T> {

    private int curPage;
    private int pageSize;
    private int totalSize;
    private int totalPage;
    private List<T> data;

    public PageResponseBean(int curPage, int pageSize, int totalSize, List<T> data) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.data = data;
    }

    public PageResponseBean() {
    }

    public static PageResponseBean create() {
        return new PageResponseBean();
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
