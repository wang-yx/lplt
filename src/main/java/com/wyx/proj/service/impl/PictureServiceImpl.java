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

        return pictures;
    }

    @Override
    public List<Picture> selectCatgPics(int imgCatg) throws Exception {
        List<Picture> picturese = getPicDao().selectCatgAllPic(imgCatg);
        return picturese;
    }

    @Override
    public List<Picture> selectCatgReleasePics(int imgCatg,int isRelease) throws Exception {
        List<Picture> picturese = getPicDao().selectCatgSomePic(imgCatg,isRelease);
        return picturese;
    }

    @Override
    public Picture selectOnePics(String key) throws Exception {
        List<Picture> picturese = getPicDao().selectPicByKey(key);
        return picturese.get(1);
    }

    @Override
    public int saveOnePics(Picture pic) throws Exception {
        getPicDao().insertPic(pic);
        return pic.getId();
    }

    @Override
    public void deleteOnePics(List<String> picKeys) throws Exception {
        getPicDao().batchDeletePicByKey(picKeys);
    }

    @Override
    public void releasePics(List<Integer> picIds) throws Exception {

    }

    @Override
    public void updatePicsInfo(List<Picture> pictures) throws Exception {

    }

    @Override
    public void releasePic(int picId) throws Exception {
        getPicDao().releaseImg(picId);
    }

    /**
     *  获取userDao
     * @return
     */
    public PictureDao getPicDao() {
        return getBaseDao().getMapper(PictureDao.class);
    }
}
