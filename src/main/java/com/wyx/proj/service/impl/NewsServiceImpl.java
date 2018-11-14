package com.wyx.proj.service.impl;

import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.dao.NewsDao;
import com.wyx.proj.entity.News;
import com.wyx.proj.service.NewsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    /**
     *  NewDao
     * @return
     */
    public NewsDao getNewsDao() {
        return getBaseDao().getMapper(NewsDao.class);
    }

    @Override
    public PageResponseBean<News> queryNewsByCondition(NewsBean newsBean) throws Exception {
        PageResponseBean<News> pageNewsBean = new PageResponseBean<>();
        int countNum = getNewsDao().searchNewsCount(newsBean.getNewsName(),newsBean.getIsRelease(),
                newsBean.getStartTime(),newsBean.getEndTime());

        List<News> tempNewsList = new ArrayList<>();

        if(countNum>0){
            Integer offset = null, limit = null;
            offset = (newsBean.getPageNo()-1) * newsBean.getPageSize();
            limit = newsBean.getPageSize();
            tempNewsList = getNewsDao().searchNews(newsBean.getNewsName(),newsBean.getIsRelease(),limit,
                    offset,newsBean.getStartTime(),newsBean.getEndTime());
            pageNewsBean = new PageResponseBean(newsBean.getPageNo(),newsBean.getPageSize(),countNum,tempNewsList);
        }else{
            pageNewsBean = new PageResponseBean(1,15,0,tempNewsList);
        }
        return pageNewsBean;
    }

    @Override
    public int count(int isRelease) throws Exception {
        return getNewsDao().count(isRelease);
    }

    @Override
    public News queryNewsDetail(int newsId) throws Exception {
        return getNewsDao().selectNewById(newsId);
    }

    @Override
    public boolean save(News news) throws Exception {
        int resultNum = 0;
        if (news.getId()!=null && news.getId()!=0){
            resultNum = getNewsDao().updateNew(news);
        }else{
            resultNum = getNewsDao().insertNew(news);
        }
        return resultNum>0;
    }

    @Override
    public boolean deleteNewsById(int id) throws Exception {

        return getNewsDao().deleteNewById(id)>0;

    }



//    @Override
//    public List<News> queryNewsByCondition(NewsQueryParam param) {
//
//        Integer offset = null, limit = null;
//        if(param.getPage() != null){
//            offset = (param.getPage().getPageNo()-1) * param.getPage().getPageSize();
//            limit = param.getPage().getPageSize();
//        }
//
//        return getNewsDao().searchNews(null, null, 1, limit, offset, null, null);
//    }
//
//    @Override
//    public int count(int isRelease) {
//        return getNewsDao().count(isRelease);
//    }
//
//    @Override
//    public News queryNewsDetail(int newsId) {
//        return null;
//    }
//
//    @Override
//    public boolean save(News news) {
//        return getNewsDao().insertNew(news) > 0;
//    }
//
//    @Override
//    public boolean update(News news) {
//        return getNewsDao().updateNew(news) > 0;
//    }
//
//    @Override
//    public boolean addReadNums(int newsId) {
//        return false;
//    }




}
