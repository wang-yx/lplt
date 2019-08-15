package com.wyx.proj.service.impl;

import com.wyx.proj.bean.AfterServiceBean;
import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.dao.AfterServiceDao;
import com.wyx.proj.dao.NewDao;
import com.wyx.proj.dao.NewDetailDao;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.New;
import com.wyx.proj.entity.NewDetail;
import com.wyx.proj.service.AfterServiceService;
import com.wyx.proj.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("afterServiceService")
@Transactional
public class AfterServiceServiceImpl extends BaseServiceImpl<AfterService> implements AfterServiceService {


    @Override
    public PageResponseBean<AfterService> queryAfterServiceByCondition(AfterServiceBean afterServiceBean) throws Exception {

        PageResponseBean<AfterService> pageNewsBean = new PageResponseBean<>();
        int countNum = getAfterServiceDao().selectAllCount(afterServiceBean.getName(),
                afterServiceBean.getStarttime(), afterServiceBean.getEndtime());

        List<AfterService> tempList = new ArrayList<>();

        if (countNum > 0) {
            Integer offset = null, limit = null;
            offset = (afterServiceBean.getPageNo() - 1) * afterServiceBean.getPageSize();
            limit = afterServiceBean.getPageSize();
            tempList = getAfterServiceDao().selectSomeAfterServices(afterServiceBean.getName(),
                    afterServiceBean.getStarttime(), afterServiceBean.getEndtime(),
                    afterServiceBean.getIndustry(), afterServiceBean.getIsaftersale(), limit, offset);
            pageNewsBean = new PageResponseBean(afterServiceBean.getPageNo(), afterServiceBean.getPageSize(), countNum, tempList);
        } else {
            pageNewsBean = new PageResponseBean(1, 15, 0, tempList);
        }
        return pageNewsBean;

    }

    @Override
    public AfterService queryAfterServiceDetail(int Id) throws Exception {
        return getAfterServiceDao().selectAfterServiceById(Id);
    }

    @Override
    public boolean save(AfterService afterService) throws Exception {
        int returnNum = 0;
        if (afterService.getId()!= null && afterService.getId() != 0) {
            returnNum = getAfterServiceDao().updateAfterService(afterService);
        } else {
            returnNum = getAfterServiceDao().insertAfterService(afterService);
        }
        return returnNum > 0;
    }

    @Override
    public boolean deleteAfterServiceById(int id) throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        return getAfterServiceDao().batchDeleteAfterService(ids) > 1;
    }


    public AfterServiceDao getAfterServiceDao() {
        return getBaseDao().getMapper(AfterServiceDao.class);
    }


}
