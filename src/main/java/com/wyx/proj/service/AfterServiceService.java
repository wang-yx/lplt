package com.wyx.proj.service;

import com.wyx.proj.bean.AfterServiceBean;
import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.New;

public interface AfterServiceService {

    PageResponseBean<AfterService> queryAfterServiceByCondition(AfterServiceBean afterServiceBean) throws Exception;

    AfterService queryAfterServiceDetail(int Id) throws Exception;

    boolean save(AfterService afterService) throws Exception;

    boolean deleteAfterServiceById(int id) throws Exception;

}
