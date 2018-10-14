package com.wyx.proj.service;

import com.wyx.proj.entity.News;
import com.wyx.proj.param.NewsQueryParam;

import java.util.List;

public interface NewsService {

    List<News> queryNewsByCondition(NewsQueryParam param);

    int count(int isRelease);

    News queryNewsDetail(int newsId);

    boolean save(News news);

    boolean update(News news);

    boolean addReadNums(int newsId);
}
