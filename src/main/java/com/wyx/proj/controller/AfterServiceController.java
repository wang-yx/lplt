package com.wyx.proj.controller;

import com.wyx.proj.bean.AfterServiceBean;
import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.New;
import com.wyx.proj.service.AfterServiceService;
import com.wyx.proj.service.NewsService;
import com.wyx.proj.util.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;

@RestController
@RequestMapping(value="/afterService")
public class AfterServiceController {

    @Resource
    private AfterServiceService afterServiceService;

    @PostMapping(value = "list")
    public Object list(@RequestBody AfterServiceBean request){
        PageResponseBean<AfterService> result = null;
        try {
            result = afterServiceService.queryAfterServiceByCondition(request);
        } catch (Exception e) {
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok(result);
    }

    @PostMapping(value = "detail")
    public Object detail(@FormParam("id") int id){
        AfterService afterService = null;
        try {
            afterService = afterServiceService.queryAfterServiceDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok(afterService);
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody AfterService afterService){
        try {
            afterServiceService.save(afterService);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("保存成功");
    }

    @PostMapping(value = "delete")
    public Object save(@FormParam("id") int id){
        try {
            afterServiceService.deleteAfterServiceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("删除成功！");
    }


}
