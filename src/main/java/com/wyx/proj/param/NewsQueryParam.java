package com.wyx.proj.param;

import com.wyx.proj.request.PageRequest;

public class NewsQueryParam extends PageRequest {

    public NewsQueryParam(Page page) {
        this.page = page;
    }

    public static class Builder{
        private Page page;

        public Page getPage() {
            return page;
        }

        public void setPage(Page page) {
            this.page = page;
        }

        public NewsQueryParam build(){
            return new NewsQueryParam(page);
        }
    }
}
