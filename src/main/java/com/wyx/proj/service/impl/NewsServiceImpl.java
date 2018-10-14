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

        Integer offset = null, limit = null;
        if(param.getPage() != null){
            offset = (param.getPage().getPageNo()-1) * param.getPage().getPageSize();
            limit = param.getPage().getPageSize();
        }

        return getNewsDao().searchNews(null, null, 1, limit, offset, null, null);
    }

    @Override
    public int count(int isRelease) {
        return getNewsDao().count(isRelease);
    }

    @Override
    public News queryNewsDetail(int newsId) {
        return null;
    }

    @Override
    public boolean save(News news) {
        return getNewsDao().insertNew(news) > 0;
    }

    @Override
    public boolean update(News news) {
        return getNewsDao().updateNew(news) > 0;
    }

    @Override
    public boolean addReadNums(int newsId) {
        return false;
    }
}
