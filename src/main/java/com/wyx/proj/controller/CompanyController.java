package com.wyx.proj.controller;

import com.wyx.proj.bean.AfterServiceBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.Info;
import com.wyx.proj.service.AfterServiceService;
import com.wyx.proj.service.CompanyInfoService;
import com.wyx.proj.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Resource
    private CompanyInfoService companyInfoService;


    @PostMapping(value = "detail")
    public Object detail() {
        Info info = null;
        try {
            info = companyInfoService.getCompanyInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok(info);
    }

    @GetMapping(value = "detail")
    public Object detailGet() {
        Info info = null;
        try {
            info = companyInfoService.getCompanyInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok(info);
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody Info info) {
        try {
            info.setIsinfo(0);
            companyInfoService.saveCompanyInfo(info);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok("保存成功");
    }

    @PostMapping(value = "delete")
    public Object delete(@FormParam("id") int id) {
        try {
            companyInfoService.deleteInfoById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok("删除成功！");
    }

    @GetMapping(value = "delete")
    public Object deleteGet(@QueryParam("id") int id) {
        try {
            companyInfoService.deleteInfoById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok("删除成功！");
    }

}
