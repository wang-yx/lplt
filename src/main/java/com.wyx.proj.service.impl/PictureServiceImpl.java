package com.wyx.proj.service.impl;

import com.wyx.proj.dao.PictureDao;
import com.wyx.proj.dao.UserDao;
import com.wyx.proj.entity.Picture;
import com.wyx.proj.entity.User;
import com.wyx.proj.service.PictureService;
import com.wyx.proj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pictureService")
public class PictureServiceImpl extends BaseServiceImpl<User> implements PictureService {

    private final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);


    @Override
    public List<Picture> selectAllPics() throws Exception {

        List<Picture> pictures = getPicDao().selectAllPic();

        System.out.println("--------"+pictures.size());

        return pictures;
    }



    /**
     *  获取userDao
     * @return
     */
    public PictureDao getPicDao() {
        return getBaseDao().getMapper(PictureDao.class);
    }
}
