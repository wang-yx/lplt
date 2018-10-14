package com.wyx.proj.request;

import java.io.Serializable;

public class PageRequest implements Serializable {

    private static final long serialVersionUID = 4056467250135252959L;

    public Page page = new Page(1, 15);

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public static class Page {
        private int pageNo;
        private int pageSize;

        public Page(int pageNo, int pageSize) {
            this.pageNo = pageNo;
            this.pageSize = pageSize;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }
}
