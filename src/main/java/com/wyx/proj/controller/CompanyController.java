package com.wyx.proj.controller;

import com.wyx.proj.bean.AfterServiceBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.Info;
import com.wyx.proj.service.AfterServiceService;
import com.wyx.proj.service.CompanyInfoService;
import com.wyx.proj.util.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;

@RestController
@RequestMapping(value="/company")
public class CompanyController {

    @Resource
    private CompanyInfoService companyInfoService;


    @PostMapping(value = "detail")
    public Object detail(@FormParam("id") int id){
        Info info = null;
        try {
            info = companyInfoService.getCompanyInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok(info);
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody Info info){
        try {
            info.setIsinfo(0);
            companyInfoService.saveCompanyInfo(info);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("保存成功");
    }

    @PostMapping(value = "delete")
    public Object save(@FormParam("id") int id){
        try {
            companyInfoService.deleteInfoById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("删除成功！");
    }


}
