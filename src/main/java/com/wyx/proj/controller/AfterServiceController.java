package com.wyx.proj.controller;

import com.wyx.proj.bean.AfterServiceBean;
import com.wyx.proj.bean.NewsBean;
import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.New;
import com.wyx.proj.service.AfterServiceService;
import com.wyx.proj.service.NewsService;
import com.wyx.proj.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/afterService")
public class AfterServiceController {

    @Resource
    private AfterServiceService afterServiceService;

    @PostMapping(value = "list")
    public Object list(@RequestBody AfterServiceBean request) {
        PageResponseBean<AfterService> result = null;
        try {
            if (request.getEndtime() != null) {
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStr = s.format(request.getEndtime());
                Date endtime = null;
                endtime = s2.parse(dateStr + " 23:59:59");
                request.setEndtime(endtime);
            }
            result = afterServiceService.queryAfterServiceByCondition(request);
        } catch (Exception e) {
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok(result);
    }

    @PostMapping(value = "detail")
    public Object detail(@FormParam("id") int id) {
        AfterService afterService = null;
        try {
            afterService = afterServiceService.queryAfterServiceDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok(afterService);
    }

    @GetMapping(value = "detail")
    public Object detailGet(@QueryParam("id") int id) {
        AfterService afterService = null;
        try {
            afterService = afterServiceService.queryAfterServiceDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok(afterService);
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody AfterService afterService) {
        try {
            afterServiceService.save(afterService);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok("保存成功");
    }

    @PostMapping(value = "delete")
    public Object delete(@FormParam("id") int id) {
        try {
            afterServiceService.deleteAfterServiceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok("删除成功！");
    }

    @GetMapping(value = "delete")
    public Object deleteGet(@QueryParam("id") int id) {
        try {
            afterServiceService.deleteAfterServiceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok("删除成功！");
    }


}
