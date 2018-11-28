package com.wyx.proj.controller;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.wyx.proj.entity.Picture;
import com.wyx.proj.service.PictureService;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/image")
//@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
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


    @RequestMapping(value = "releasePic",method = RequestMethod.POST)
    public Object releasePic(@FormParam("imgid") int imgid){
        try {
            pictureService.releasePic(imgid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("发布成功");
    }

    @RequestMapping(value = "getSomeCatgImgs",method = RequestMethod.GET)
    public Object getSomeCatgImgs(@FormParam("cagt") int cagt,@FormParam("isRelease") int isRelease){
        List<Picture> pictures = new ArrayList<>();
        try {
            pictures = pictureService.selectCatgReleasePics(cagt,isRelease);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err("获取失败"+e.getMessage());
        }
        return ResponseUtil.ok("获取成功",pictures);
    }

    @RequestMapping(value = "getAllCatgImgs",method = RequestMethod.GET)
    public Object getAllCatgImgs(@FormParam("cagt") int cagt){
        List<Picture> pictures = new ArrayList<>();
        try {
            pictures = pictureService.selectCatgPics(cagt);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err("获取失败"+e.getMessage());
        }

        return ResponseUtil.ok("获取成功",pictures);
    }


    @RequestMapping(value = "updatePic",method = RequestMethod.POST)
    public Object uploadPhotoPic(@RequestParam(value = "file") MultipartFile file){

        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空","");
        }

        Picture picture = new Picture();
        // 获取文件名
        String oldFileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + oldFileName);
        // 获取文件的后缀名
        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String newFileName = "img_"+new Date().getTime()+suffixName;
        String filePath = uploadDir + newFileName;

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            picture.setImgPath(filePath);
            picture.setImgKey(newFileName);
            picture.setImgComment(StringUtils.isEmpty(picture.getImgComment())?oldFileName:picture.getImgComment());
            picture.setId(pictureService.saveOnePics(picture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("上传成功后的文件路径为：" + filePath);

        return ResponseUtil.ok(picture);
    }



    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Object uploadPhoto(@RequestParam(value = "file") MultipartFile file,
                                @FormParam("pictureInfo") String pictureInfo){

        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空","");
        }

        Picture picture = new Picture();
        try {
            if(!StringUtils.isEmpty(pictureInfo)) {
                picture = JSON.toJavaObject((JSON) JSON.parse(pictureInfo), Picture.class);
            }
        } catch (Throwable t) {
            return ResponseUtil.err("pictureInfo无法被解析，保存失败"+t.getMessage(),"");
        }

        // 获取文件名
        String oldFileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + oldFileName);
        // 获取文件的后缀名
        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String newFileName = "img_"+new Date().getTime()+suffixName;
        String filePath = uploadDir + newFileName;

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            picture.setImgPath(filePath);
            picture.setImgKey(newFileName);
            picture.setImgComment(StringUtils.isEmpty(picture.getImgComment())?oldFileName:picture.getImgComment());
            picture.setId(pictureService.saveOnePics(picture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("上传成功后的文件路径为：" + filePath);

        return ResponseUtil.ok(picture);
    }

}
