package com.wyx.proj.controller;

import com.wyx.proj.biz.NewsBiz;
import com.wyx.proj.request.NewsDetailRequest;
import com.wyx.proj.request.NewsListRequest;
import com.wyx.proj.request.NewsSaveRequest;
import com.wyx.proj.response.NewsDetailResponse;
import com.wyx.proj.response.NewsListResponse;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value="/news")
public class NewsController {

    @Resource
    private NewsBiz newsBiz;

    @PostMapping(value = "list")
    public Response<PageResponse<NewsListResponse>> list(@RequestBody NewsListRequest request){
        return Response.success(newsBiz.listQuery(request));
    }

    @PostMapping(value = "detail")
    public Response<NewsDetailResponse> detail(@RequestBody NewsDetailRequest request){
        return Response.success(newsBiz.detail(request));
    }

    @PostMapping(value = "save")
    public Response<String> save(@RequestBody NewsSaveRequest request){
        return Response.success(newsBiz.save(request));
    }

}
