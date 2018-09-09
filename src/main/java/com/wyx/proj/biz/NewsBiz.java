package com.wyx.proj.biz;

import com.wyx.proj.request.NewsDetailRequest;
import com.wyx.proj.request.NewsListQueryRequest;
import com.wyx.proj.request.NewsSaveRequest;
import com.wyx.proj.response.NewsDetailResponse;
import com.wyx.proj.response.NewsListQueryResponse;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.service.NewsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Component
public class NewsBiz {

    @Resource
    private NewsService newsService;

    public PageResponse<NewsListQueryResponse> listQuery(@RequestBody NewsListQueryRequest request){


        return null;
    }

    public NewsDetailResponse detail(@RequestBody NewsDetailRequest request){
        return null;
    }

    public String save(@RequestBody NewsSaveRequest request){
        return null;
    }
}
