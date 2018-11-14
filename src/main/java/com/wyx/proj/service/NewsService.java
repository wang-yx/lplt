package com.wyx.proj.service;

import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.News;
import com.wyx.proj.param.NewsQueryParam;

import java.util.List;

public interface NewsService {

    PageResponseBean<News> queryNewsByCondition(NewsBean newsBean) throws Exception;

    int count(int isRelease) throws Exception;

    News queryNewsDetail(int newsId) throws Exception;

    boolean save(News news) throws Exception;

    boolean deleteNewsById(int id) throws Exception;

}
