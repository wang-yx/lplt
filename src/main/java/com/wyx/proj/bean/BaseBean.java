package com.wyx.proj.bean;

import java.util.Date;

public class BaseBean {

    private int pageNo = 1;
    private final int pageSize = 15;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }


}
