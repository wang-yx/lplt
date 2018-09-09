package com.wyx.proj.service;

import com.wyx.proj.entity.Picture;
import com.wyx.proj.entity.User;

import java.util.List;

public interface PictureService extends BaseService<User> {

    /**
     * 获取所有图片信息
     * @return
     * @throws Exception
     */
    public List<Picture> selectAllPics() throws Exception;

}
