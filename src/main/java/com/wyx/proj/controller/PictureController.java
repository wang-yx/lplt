package com.wyx.proj.controller;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.wyx.proj.entity.Picture;
import com.wyx.proj.param.PictureParam;
import com.wyx.proj.service.PictureService;
import com.wyx.proj.util.BASE64DecodedMultipartFile;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/image")
//@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class PictureController {

    private static Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Value("${uploadFile.path}")
    private String uploadDir;

    @Resource
    private PictureService pictureService;

//    @RequestMapping(value = "searchAllPics",method = RequestMethod.GET)
//    public Object searchAllPics(){
//        List<Picture> pics = new ArrayList<>();
//        try {
//            pics = pictureService.selectAllPics();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseUtil.err(e.getMessage(),"");
//        }
//
//        return ResponseUtil.ok(pics);
//    }
//
//
//    @RequestMapping(value = "releasePic",method = RequestMethod.POST)
//    public Object releasePic(@FormParam("imgid") int imgid){
//        try {
//            pictureService.releasePic(imgid);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseUtil.err(e.getMessage(),"");
//        }
//        return ResponseUtil.ok("发布成功");
//    }
//
//    @RequestMapping(value = "getSomeCatgImgs",method = RequestMethod.GET)
//    public Object getSomeCatgImgs(@FormParam("cagt") int cagt,@FormParam("isRelease") int isRelease){
//        List<Picture> pictures = new ArrayList<>();
//        try {
//            pictures = pictureService.selectCatgReleasePics(cagt,isRelease);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseUtil.err("获取失败"+e.getMessage());
//        }
//        return ResponseUtil.ok("获取成功",pictures);
//    }
//
//    @RequestMapping(value = "getAllCatgImgs",method = RequestMethod.GET)
//    public Object getAllCatgImgs(@FormParam("cagt") int cagt){
//        List<Picture> pictures = new ArrayList<>();
//        try {
//            pictures = pictureService.selectCatgPics(cagt);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseUtil.err("获取失败"+e.getMessage());
//        }
//
//        return ResponseUtil.ok("获取成功",pictures);
//    }
//
//
    //******************************************************************************************************************


    @RequestMapping(value = "updatePic", method = RequestMethod.POST)
    public Object uploadPhotoPic(@RequestParam(value = "file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空", "");
        }

        Picture picture = new Picture();
        // 获取文件名
        String oldFileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + oldFileName);
        // 获取文件的后缀名
        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String newFileName = "img_" + new Date().getTime() + suffixName;
        String filePath = uploadDir + newFileName;

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            filePath = filePath.substring(filePath.indexOf("webapps") + 8);
            picture.setImgPath(filePath);
            picture.setImgKey(newFileName);
            picture.setImgComment(StringUtils.isEmpty(picture.getImgComment()) ? oldFileName : picture.getImgComment());
            picture.setId(pictureService.saveOnePics(picture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("上传成功后的文件路径为：" + filePath);

        return ResponseUtil.ok(picture);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Object uploadPhoto(@RequestParam(value = "file") MultipartFile file,
                              @FormParam("pictureInfo") String pictureInfo) {

        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空", "");
        }

        Picture picture = new Picture();
        try {
            if (!StringUtils.isEmpty(pictureInfo)) {
                picture = JSON.toJavaObject((JSON) JSON.parse(pictureInfo), Picture.class);
            }
        } catch (Throwable t) {
            return ResponseUtil.err("pictureInfo无法被解析，保存失败" + t.getMessage(), "");
        }

        // 获取文件名
        String oldFileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + oldFileName);
        // 获取文件的后缀名
        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String newFileName = "img_" + new Date().getTime() + suffixName;
        String filePath = uploadDir + newFileName;

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            filePath = filePath.substring(filePath.indexOf("webapps") + 8);
            picture.setImgPath(filePath);
            picture.setImgKey(newFileName);
            picture.setImgComment(StringUtils.isEmpty(picture.getImgComment()) ? oldFileName : picture.getImgComment());
            picture.setId(pictureService.saveOnePics(picture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("上传成功后的文件路径为：" + filePath);

        return ResponseUtil.ok(picture);
    }

    //******************************************************************************************************************


    @RequestMapping(value = "searchMainPagePics", method = RequestMethod.GET)
    public Object searchMainPagePics() {
        List<Picture> pics = new ArrayList<>();
        try {
            pics = pictureService.selectMainPagePic();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(), "");
        }
        return ResponseUtil.ok(pics);
    }

    @RequestMapping(value = "deletePic", method = RequestMethod.POST)
    public Object deletePic(@FormParam("pictureInfo") String pictureInfo) {
        logger.info("---deletePic--param->" + pictureInfo.toString());
        //校验图片附带信息
        Picture picture = new Picture();
        try {
            if (!StringUtils.isEmpty(pictureInfo)) {
                picture = JSON.toJavaObject((JSON) JSON.parse(pictureInfo), Picture.class);
                if (picture.getId() ==null || picture.getId() == 0) {
                    return ResponseUtil.err("id不能为空", "");
                }
                picture = pictureService.selectOnePicById(picture.getId());
            }
        } catch (Throwable t) {
            return ResponseUtil.err("pictureInfo无法被解析，保存失败" + t.getMessage(), "");
        }
        logger.info("---picture.getImgPath()-->" + picture.getImgPath());
        //删除文件
        try {
            pictureService.deleteFile(picture.getImgPath());
        } catch (Exception e) {
            logger.error("删除图片失败：" + e.getMessage());
            return ResponseUtil.err("删除图片失败：" + e.getMessage(), "");
        }
        return ResponseUtil.ok("删除成功", "");
    }

    @RequestMapping(value = "deletePic", method = RequestMethod.GET)
    public Object deletePicGet(@RequestParam("id") int id) {
        logger.info("---deletePic--param->" + id);
        //校验图片附带信息
        Picture picture = new Picture();
        try {
            if (id != 0) {
                picture = pictureService.selectOnePicById(id);
//                List<String> l
//                pictureService.deleteOnePics(new ArrayList<String>(picture.getImgKey()));
            }
        } catch (Throwable t) {
            return ResponseUtil.err("pictureInfo无法被解析，保存失败" + t.getMessage(), "");
        }
        logger.info("---picture.getImgPath()-->" + picture.getImgPath());
        //删除文件
        try {
            pictureService.deleteFile(picture.getImgPath());
            picture.setImgPath("");
            pictureService.updatePicsPath(picture);
        } catch (Exception e) {
            logger.error("删除图片失败：" + e.getMessage());
            return ResponseUtil.err("删除图片失败：" + e.getMessage(), "");
        }
        return ResponseUtil.ok("删除成功", "");
    }


    /**
     * 上传图片，覆盖以前的图片的（只用作首页图片上传）
     *
     * @param pictureParam
     * @returnx
     */
    @RequestMapping(value = "updateBase64Pic", method = RequestMethod.POST)
    public Object uploadPhotoBase64Pic(@RequestBody PictureParam pictureParam) {

        System.out.println("---uploadPhotoBase64Pic-->"+JSON.toJSONString(pictureParam));

        //校验图片附带信息
        Picture picture = new Picture();
        try {
            if (!StringUtils.isEmpty(pictureParam.getPictureInfo())) {
                picture = JSON.toJavaObject((JSON) JSON.parse(pictureParam.getPictureInfo()), Picture.class);
            }
        } catch (Throwable t) {
            return ResponseUtil.err("pictureInfo无法被解析，保存失败" + t.getMessage(), "");
        }

        //删除文件
        try {
            pictureService.deleteFile(picture.getImgPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //base64转图片
        if (StringUtils.isEmpty(pictureParam.getBase64Str())) {
            return ResponseUtil.err("base64Str不能为空", "");
        }
        MultipartFile file = base64ToMultipart(pictureParam.getBase64Str());
        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空", "");
        }

        //Picture picture = new Picture();
        // 获取文件名
        String oldFileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + oldFileName);
        // 获取文件的后缀名
        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String newFileName = "img_" + new Date().getTime() + suffixName;
        String filePath = uploadDir + newFileName;

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            filePath = filePath.substring(filePath.indexOf("webapps") + 7);
            picture.setImgCatg("9");
            picture.setImgPath(filePath);
            picture.setIsRelease(1);
            picture.setImgKey(newFileName);
            picture.setImgComment(StringUtils.isEmpty(picture.getImgComment()) ? oldFileName : picture.getImgComment());
            picture.setId(pictureService.saveOnePics(picture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("上传成功后的文件路径为：" + filePath);

        return ResponseUtil.ok(picture);
    }


    /**
     * 只是上传图片的
     *
     * @param pictureParam
     * @return
     */
    @RequestMapping(value = "updateBase64", method = RequestMethod.POST)
    public Object uploadPhotoBase64(@RequestBody PictureParam pictureParam) {
    //public Object uploadPhotoBase64(@FormParam("base64Str") String base64Str) {
        logger.info("参数--base64Str--：" + pictureParam.getBase64Str());
        if (StringUtils.isEmpty(pictureParam.getBase64Str())) {
            return ResponseUtil.err("base64Str不能为空", "");
        }

        MultipartFile file = base64ToMultipart(pictureParam.getBase64Str());

        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空", "");
        }

        Picture picture = new Picture();
        // 获取文件名
        String oldFileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + oldFileName);
        // 获取文件的后缀名
        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String newFileName = "img_" + new Date().getTime() + suffixName;
        String filePath = uploadDir + newFileName;

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            filePath = filePath.substring(filePath.indexOf("webapps") + 7);
            picture.setImgPath(filePath);
            picture.setImgKey(newFileName);
            picture.setImgComment(StringUtils.isEmpty(picture.getImgComment()) ? oldFileName : picture.getImgComment());
            picture.setId(pictureService.saveOnePics(picture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("上传成功后的文件路径为：" + filePath);

        return ResponseUtil.ok(picture);
    }


    public static MultipartFile base64ToMultipart(String base64) {
        try {
            String[] baseStrs = base64.split(",");

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStrs[1]);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            return new BASE64DecodedMultipartFile(b, baseStrs[0]);
        } catch (IOException e) {
            logger.error("文件转化失败：" + e.getMessage());
            return null;
        }
    }


//    public class PictureParam{
//
//        PictureParam(String base64Str){
//            this.base64Str = base64Str;
//        }
//        PictureParam(){
//
//        }
//
//        public String getBase64Str() {
//            return base64Str;
//        }
//
//        public void setBase64Str(String base64Str) {
//            this.base64Str = base64Str;
//        }
//
//        public String base64Str;
//
//    }

}
