package com.wyx.proj.adapter;

import com.wyx.proj.entity.New;
import com.wyx.proj.response.NewsListResponse;

public class NewsAdapter {

    public static NewsListResponse adapterResponse(New news){
        NewsListResponse response = new NewsListResponse();

        response.setNewsId(news.getId());
        response.setNewsTitle(news.getNewName());
        response.setIntroduce(news.getNewIntroduce());
        response.setPicKey(news.getNewImglkey());
        response.setCreateTime(news.getCreateTime());

        return response;
    }
}
