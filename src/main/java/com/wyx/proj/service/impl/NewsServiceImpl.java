package com.wyx.proj.service.impl;

import com.wyx.proj.dao.NewsDao;
import com.wyx.proj.entity.News;
import com.wyx.proj.param.NewsQueryParam;
import com.wyx.proj.service.NewsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    /**
     *  ProductDao
     * @return
     */
    public NewsDao getNewsDao() {
        return getBaseDao().getMapper(NewsDao.class);
    }

    @Override
    public List<News> queryNewsByCondition(NewsQueryParam param) {



        return null;
    }

    @Override
    public News queryNewsDetail(int newsId) {
        return null;
    }

    @Override
    public boolean save(News news) {
        return false;
    }

    @Override
    public boolean addReadNums(int newsId) {
        return false;
    }
}
