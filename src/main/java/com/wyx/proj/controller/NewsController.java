package com.wyx.proj.controller;

import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.New;
import com.wyx.proj.service.NewsService;
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
        PageResponseBean<New> result = null;
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
        New news = null;
        try {
            news = newsService.queryNewsDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok(news);
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody New news){
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
