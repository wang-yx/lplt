package com.wyx.proj.service.impl;

import com.wyx.proj.bean.AfterServiceBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.dao.AfterServiceDao;
import com.wyx.proj.dao.CompanyDao;
import com.wyx.proj.dao.InfoDao;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.Company;
import com.wyx.proj.entity.Info;
import com.wyx.proj.service.AfterServiceService;
import com.wyx.proj.service.CompanyInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("companyInfoService")
@Transactional
public class CompanyInfoServiceImpl extends BaseServiceImpl<AfterService> implements CompanyInfoService {


    public CompanyDao getCompanyDao() {
        return getBaseDao().getMapper(CompanyDao.class);
    }
    public InfoDao getInfoDao() {
        return getBaseDao().getMapper(InfoDao.class);
    }


    @Override
    public Info getCompanyInfo() throws Exception {
        Info resultInfo = new Info();
        List<Info> resultInfos = getInfoDao().selectInfos(0);
        if(resultInfos!=null && resultInfos.size()>0) {
            resultInfo = resultInfos.get(0);
            Company com_ch = getCompanyDao().selectCompanyById(resultInfo.getChineseid());
            Company com_en = getCompanyDao().selectCompanyById(resultInfo.getEnglishid());
            resultInfo.setCompany_ch(com_ch);
            resultInfo.setCompany_en(com_en);
        }
        return resultInfo;
    }

    @Override
    public Info getContactInfo(int infoId) throws Exception {
        return getInfoDao().selectInfoById(infoId);
    }

    @Override
    public List<Info> getInfoList() throws Exception {

        List<Info> infoList = getInfoDao().selectInfos(1);

        return infoList;
    }

    @Override
    public boolean saveCompanyInfo(Info info) throws Exception {
        int resultNum = 0;
        if(info.getIsinfo()==1){
            info.setChineseid(0);
            info.setEnglishid(0);
            if (info.getId() != 0) { //update
                resultNum = getInfoDao().updateInfo(info);
            }else{ //insert
                resultNum = getInfoDao().insertInfo(info);
            }
        }else {

            if (info.getId() != 0) { //upsert
                Info tempInfo = getInfoDao().selectInfoById(info.getId());
                Company com_ch = info.getCompany_ch();
                com_ch.setId(tempInfo.getChineseid());
                getCompanyDao().updateCompany(com_ch);

                Company com_en = info.getCompany_en();
                com_en.setId(tempInfo.getEnglishid());
                getCompanyDao().updateCompany(com_en);

                resultNum = getInfoDao().updateInfo(info);
            } else { //insert
                Company com_ch = info.getCompany_ch();
                getCompanyDao().insertCompanyInfo(com_ch);
                info.setChineseid(com_ch.getId());

                Company com_en = info.getCompany_en();
                getCompanyDao().insertCompanyInfo(com_en);
                info.setEnglishid(com_en.getId());

                resultNum = getInfoDao().insertInfo(info);
            }
        }
        return resultNum>0;
    }

    @Override
    public boolean saveContactInfo(Info info) throws Exception {
        int resultNum = 0;
        if(info.getId()!=0){ //upsert
            resultNum = getInfoDao().updateInfo(info);
        }else{ //insert
            resultNum = getInfoDao().insertInfo(info);
        }
        return resultNum>0;
    }

    @Override
    public boolean deleteInfoById(int id) throws Exception {
        Info tempInfo = getInfoDao().selectInfoById(id);
        List<Integer> ids = new ArrayList<>();
        if(tempInfo.getChineseid() !=null ){
            ids.add(tempInfo.getChineseid());
        }
        if(tempInfo.getEnglishid() !=null ){
            ids.add(tempInfo.getEnglishid());
        }
        getCompanyDao().batchDeleteCompany(ids);

        return getInfoDao().DeleteInfoByid(id)>0;
    }
}
