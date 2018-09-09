package com.wyx.proj.controller;


import com.wyx.proj.entity.User;
import com.wyx.proj.service.UserService;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/photo")
public class photoController {

    private Logger logger = LoggerFactory.getLogger(photoController.class);

    @Value("${uploadFile.path}")
    private String uploadDir;

    @RequestMapping(value = "uploadPhoto",method = RequestMethod.POST)
    public Object uploadPhoto(@RequestParam(value = "file") MultipartFile file){

        if (file.isEmpty()) {
            return ResponseUtil.err("文件不能为空");
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
