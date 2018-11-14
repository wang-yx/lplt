package com.wyx.proj.controller;

import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.biz.NewsBiz;
import com.wyx.proj.entity.News;
import com.wyx.proj.request.NewsDetailRequest;
import com.wyx.proj.request.NewsListRequest;
import com.wyx.proj.request.NewsSaveRequest;
import com.wyx.proj.response.NewsDetailResponse;
import com.wyx.proj.response.NewsListResponse;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.service.NewsService;
import com.wyx.proj.util.Response;
import com.wyx.proj.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;

@RestController
@RequestMapping(value="/news")
public class NewsController {

    @Resource
    private NewsService newsService;

    @PostMapping(value = "list")
    public Object list(@RequestBody NewsBean request){
        PageResponseBean<News> result = null;
        try {
            result = newsService.queryNewsByCondition(request);
        } catch (Exception e) {

            System.out.println("--------------------------------------------------------------------------");

            //e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok(result);
    }

    @PostMapping(value = "detail")
    public Object detail(@FormParam("id") int id){
        News news = null;
        try {
            news = newsService.queryNewsDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok(news);
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody News news){
        try {
            newsService.save(news);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("保存成功");
    }

    @PostMapping(value = "delete")
    public Object save(@FormParam("id") int id){
        try {
            newsService.deleteNewsById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("删除成功！");
    }


//    @Resource
//    private NewsBiz newsBiz;

//    @PostMapping(value = "list")
//    public Response<PageResponse<NewsListResponse>> list(@RequestBody NewsListRequest request){
//        return Response.success(newsBiz.listQuery(request));
//    }
//
//    @PostMapping(value = "detail")
//    public Response<NewsDetailResponse> detail(@RequestBody NewsDetailRequest request){
//        return Response.success(newsBiz.detail(request));
//    }
//
//    @PostMapping(value = "save")
//    public Response<String> save(@RequestBody NewsSaveRequest request){
//        return Response.success(newsBiz.save(request));
//    }

}
