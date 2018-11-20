package com.wyx.proj.biz;

import com.google.common.collect.Lists;
import com.wyx.proj.common.BizTemplate;
import com.wyx.proj.entity.New;
import com.wyx.proj.param.NewsQueryParam;
import com.wyx.proj.request.NewsDetailRequest;
import com.wyx.proj.request.NewsListRequest;
import com.wyx.proj.request.NewsSaveRequest;
import com.wyx.proj.response.NewsDetailResponse;
import com.wyx.proj.response.NewsListResponse;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.service.NewsService;
import com.wyx.proj.util.WAssert;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Component
public class NewsBiz {

    @Resource
    private NewsService newsService;

    public PageResponse<NewsListResponse> listQuery(@RequestBody NewsListRequest request){
        return new BizTemplate<PageResponse<NewsListResponse>>() {
            @Override
            public void checkParams() {

            }

            @Override
            public PageResponse<NewsListResponse> process() throws Exception {

                int count = newsService.count(1);
                List<NewsListResponse> responseList = Lists.newArrayList();
                if(count > 0){
                    NewsQueryParam param = new NewsQueryParam(request.getPage());
//                    List<News> newsList = newsService.queryNewsByCondition(param);
//                    if(newsList != null){
//                        responseList = newsList.stream().map(NewsAdapter::adapterResponse).collect(Collectors.toList());
//                    }
                }

                PageResponse.PageData pageData = new PageResponse.PageData(request.getPage(), count);

                return new PageResponse<>(pageData, responseList);
            }
        }.execute();
    }

    public NewsDetailResponse detail(@RequestBody NewsDetailRequest request){




        return null;
    }

    public String save(@RequestBody NewsSaveRequest request){
        return new BizTemplate<String>() {
            @Override
            public void checkParams() {

            }

            @Override
            public String process() throws Exception {
                if(request.getNewsId() == null || request.getNewsId() == 0){
                    //insert
                    newsService.save(adatperNews(null, request));
                    return "添加成功";
                }else{
                    //update
                    New news = newsService.queryNewsDetail(request.getNewsId());
                    WAssert.nutNull(news, String.format("新闻不存在:%s", request.getNewsId()));
                    newsService.save(adatperNews(news, request));
                    return "更新成功";
                }
            }

            protected New adatperNews(New news, NewsSaveRequest detail){
                if(news == null){
                    news = new New();
                }
                news.setNewName(detail.getNewsTitle());
                news.setNewImglkey(detail.getPicKey());
                news.setNewDetail(detail.getNewsDetail());
                return news;
            }
        }.execute();
    }
}
