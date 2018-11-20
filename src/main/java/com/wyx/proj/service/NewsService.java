package com.wyx.proj.service;

import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.New;

public interface NewsService {

    PageResponseBean<New> queryNewsByCondition(NewsBean newsBean) throws Exception;

    int count(int isRelease) throws Exception;

    New queryNewsDetail(int newsId) throws Exception;

    boolean save(New news) throws Exception;

    boolean deleteNewsById(int id) throws Exception;

}
