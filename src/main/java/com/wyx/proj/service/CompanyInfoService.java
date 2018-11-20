package com.wyx.proj.service;

import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.Info;
import com.wyx.proj.entity.New;

import java.util.List;

public interface CompanyInfoService {

    /**
     * 获取公司介绍信息
     * @param infoId
     * @return
     * @throws Exception
     */
    Info getCompanyInfo(int infoId) throws Exception;

    /**
     * 获取联系方式信息
     * @param infoId
     * @return
     * @throws Exception
     */
    Info getContactInfo(int infoId) throws Exception;

    /**
     * 获取联系方式信息 列表
     * @return
     * @throws Exception
     */
    List<Info> getInfoList() throws Exception;

    /**
     * 保存公司介绍信息
     * @param info
     * @return
     * @throws Exception
     */
    boolean saveCompanyInfo(Info info) throws Exception;

    /**
     * 保存联系方式的信息
     * @param info
     * @return
     * @throws Exception
     */
    boolean saveContactInfo(Info info) throws Exception;

    /**
     * 根据ID删除信息
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteInfoById(int id) throws Exception;
}
