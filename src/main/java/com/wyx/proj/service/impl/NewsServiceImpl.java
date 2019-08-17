package com.wyx.proj.service.impl;

import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.controller.UserController;
import com.wyx.proj.dao.NewDao;
import com.wyx.proj.dao.NewDetailDao;
import com.wyx.proj.entity.New;
import com.wyx.proj.entity.NewDetail;
import com.wyx.proj.service.NewsService;
import com.wyx.proj.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("newsService")
@Transactional
public class NewsServiceImpl extends BaseServiceImpl<New> implements NewsService {
    private Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Resource
    private PictureService pictureService;

    public NewDao getNewsDao() {
        return getBaseDao().getMapper(NewDao.class);
    }

    public NewDetailDao getNewDetailDao() {
        return getBaseDao().getMapper(NewDetailDao.class);
    }

    @Override
    public PageResponseBean<New> queryNewsByCondition(NewsBean newsBean) throws Exception {
        PageResponseBean<New> pageNewsBean = new PageResponseBean<>();
        int countNum = getNewsDao().searchNewsCount(newsBean.getName(), newsBean.getIsrelease(),
                newsBean.getStarttime(), newsBean.getEndtime(), newsBean.getLanguage());

        List<New> tempNewsList = new ArrayList<>();

        if (countNum > 0) {
            Integer offset = null, limit = null;
            offset = (newsBean.getPageNo() - 1) * newsBean.getPageSize();
            limit = newsBean.getPageSize();
            tempNewsList = getNewsDao().searchNews(newsBean.getName(), newsBean.getIsrelease(), limit,
                    offset, newsBean.getStarttime(), newsBean.getEndtime(), newsBean.getLanguage());
            pageNewsBean = new PageResponseBean(newsBean.getPageNo(), newsBean.getPageSize(), countNum, tempNewsList);
        } else {
            pageNewsBean = new PageResponseBean(1, 15, 0, tempNewsList);
        }
        return pageNewsBean;
    }

    @Override
    public int count(int isRelease) throws Exception {
        return getNewsDao().count(isRelease);
    }

    @Override
    public New queryNewsDetail(int newsId) throws Exception {
        New tempNew = getNewsDao().selectNewById(newsId);
        tempNew.setNewDetail_ch(getNewDetailDao().selectNewDetailById(tempNew.getChineseid()));
        tempNew.setNewDetail_en(getNewDetailDao().selectNewDetailById(tempNew.getEnglishid()));
        return tempNew;
    }

    @Override
    public boolean save(New news) throws Exception {
        logger.info("----news.getId--->" + news.getId());


        int resultNum = 0;
        if (news.getId() == null || news.getId() == 0) {

            NewDetail newDetail_ch = news.getNewDetail_ch();
            newDetail_ch.setLanguage(0);
            getNewDetailDao().insertNewDetail(newDetail_ch);
            news.setChineseid(newDetail_ch.getId());

            NewDetail newDetail_en = news.getNewDetail_en();
            newDetail_en.setLanguage(1);
            getNewDetailDao().insertNewDetail(newDetail_en);
            news.setEnglishid(newDetail_en.getId());

            resultNum = getNewsDao().insertNew(news);
        } else {
            New tempNews = getNewsDao().selectNewById(news.getId());
            news.setChineseid(tempNews.getChineseid());
            news.setEnglishid(tempNews.getEnglishid());

            NewDetail newDetail_ch = news.getNewDetail_ch();
            newDetail_ch.setId(tempNews.getChineseid());
            newDetail_ch.setLanguage(0);
            getNewDetailDao().updateNewDetail(newDetail_ch);

            NewDetail newDetail_en = news.getNewDetail_en();
            newDetail_en.setId(tempNews.getEnglishid());
            newDetail_en.setLanguage(1);
            getNewDetailDao().updateNewDetail(newDetail_en);

            resultNum = getNewsDao().updateNew(news);

        }
        return resultNum > 0;
    }

    @Override
    public boolean deleteNewsById(int id) throws Exception {
        New tempNew = getNewsDao().selectNewById(id);
        List<Integer> ids = new ArrayList<>();
        ids.add(tempNew.getChineseid());
        ids.add(tempNew.getEnglishid());
        getNewDetailDao().batchDeleteNewDetail(ids);
        getNewsDao().deleteNewById(id);

        pictureService.deleteFile(tempNew.getImg());

        return true;
    }


}
