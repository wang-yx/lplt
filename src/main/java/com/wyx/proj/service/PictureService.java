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

    /**
     * 获取一个图片信息
     * @return
     * @throws Exception
     */
    public List<Picture> selectCatgPics(int imgCatg) throws Exception;

    /**
     * 获取一个图片信息
     * @return
     * @throws Exception
     */
    public List<Picture> selectCatgReleasePics(int imgCatg,int isRelease) throws Exception;

    /**
     * 获取一个图片信息
     * @return
     * @throws Exception
     */
    public Picture selectOnePics(String key) throws Exception;

    /**
     * 保存图片信息
     * @param pic
     * @throws Exception
     */
    public int saveOnePics(Picture pic) throws Exception;

    /**
     * 根据ids删除图片
     * @param
     * @throws Exception
     */
    public void deleteOnePics(List<String> picKeys) throws Exception;

    /**
     * 发布图片
     * @param picIds
     * @throws Exception
     */
    public void releasePics(List<Integer> picIds) throws Exception;


    /**
     * 跟新图片信息
     * @param pictures
     * @throws Exception
     */
    public void updatePicsInfo(List<Picture> pictures) throws Exception;

    /**
     * 发布图片
     * @param picId
     * @throws Exception
     */
    public void releasePic(int picId) throws Exception;


    public List<Picture> selectMainPagePic() throws Exception;

    public boolean deleteFile(String fileName) throws Exception;

}
