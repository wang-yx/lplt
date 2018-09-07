package com.wyx.proj.controller;


import com.alibaba.fastjson.JSON;
import com.wyx.proj.bean.PictureBean;
import com.wyx.proj.entity.Picture;
import com.wyx.proj.service.PictureService;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/picture")
public class PictureController {

    private Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Value("${uploadFile.path}")
    private String uploadDir;

    @Resource
    private PictureService pictureService;

    @RequestMapping(value = "searchAllPics",method = RequestMethod.GET)
    public Object searchAllPics(){
        List<Picture> pics = new ArrayList<>();
        try {
            pics = pictureService.selectAllPics();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }

        return ResponseUtil.ok(pics);
    }


    @RequestMapping(value = "uploadOnePicture",method = RequestMethod.POST)
    public Object uploadOnePicture(@ModelAttribute("PictureBean") PictureBean pictureBean){


        return ResponseUtil.ok("已上传");
    }

    @RequestMapping(value = "uploadPictures",method = RequestMethod.POST)
    public Object uploadPictures(@ModelAttribute("PictureBean") PictureBean[] pictureBeans){




        return ResponseUtil.ok("已上传");
    }


    @RequestMapping(value = "uploadPhoto",method = RequestMethod.POST)
    public Object uploadPhoto(@RequestParam(value = "file") MultipartFile file,
                              @FormParam("pictureInfo") String pictureInfo){

        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空","");
        }

        List<Picture> list = null;
        try {
            list = JSON.parseArray(pictureInfo, Picture.class);
        } catch (Throwable t) {
            return ResponseUtil.err("pictureInfo无法被解析，保存失败"+t.getMessage(),"");
        }




        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = uploadDir;

        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("上传成功后的文件路径为：" + filePath + fileName);

        return ResponseUtil.ok("已上传");
    }

}
