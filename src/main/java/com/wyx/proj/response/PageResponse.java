package com.wyx.proj.response;

import com.wyx.proj.request.PageRequest;

import java.util.List;

public class PageResponse<T> {

    private PageData page;
    private List<T> data;

    public PageResponse(PageData page, List<T> data) {
        this.page = page;
        this.data = data;
    }

    public static class Builder<T> {
        private List<T> data;
        private PageRequest.Page page;
        private int totalSize;

        public Builder<T> setData(List<T> data) {
            this.data = data;
            return this;
        }

        public Builder<T> setPage(PageRequest.Page page) {
            this.page = page;
            return this;
        }

        public Builder<T> setTotalSize(int totalSize) {
            this.totalSize = totalSize;
            return this;
        }

        public PageResponse<T> create(){
            return new PageResponse(new PageData(page, totalSize), data);
        }
    }

    public static class PageData {
        private int curPage;
        private int pageSize;
        private int totalSize;

        public PageData(PageRequest.Page page, int totalSize) {
            this.curPage = page.getPageNo();
            this.pageSize = page.getPageSize();
            this.totalSize = totalSize;
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
    }
}
