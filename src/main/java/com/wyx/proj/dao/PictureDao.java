package com.wyx.proj.dao;


import com.wyx.proj.entity.Picture;
import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;


@Mapper
public interface PictureDao {
    /*
    private int id;
    private String imgKey; //图片的key
    private String imgPath; //图片路径
    private String imgCatg; //是首页图片0，新闻中的图片1，还是产品的图片2
    private String imgComment; //图片备注
    private Date createTime; //创建时间
    private int isRelease; //是否发布，0不发布，1发布
    private Date releaseTime; //发布时间
     */

    /**
     * 查询所有图片
     * @return
     */
    @Select("select * from t_picture ")
    @Results({
            @Result(property = "imgKey",column = "img_key"),
            @Result(property = "imgPath",column = "img_path"),
            @Result(property = "imgCatg",column = "img_catg"),
            @Result(property = "imgComment",column = "img_comment"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isRelease",column = "is_release"),
            @Result(property = "releaseTime",column = "release_time")
    })
    public List<Picture> selectAllPic();

    /**
     * 查询某类型的所有图片信息
     * @return
     */
    @Select("select * from t_picture where img_catg=#{imgCatg}")
    @Results({
            @Result(property = "imgKey",column = "img_key"),
            @Result(property = "imgPath",column = "img_path"),
            @Result(property = "imgCatg",column = "img_catg"),
            @Result(property = "imgComment",column = "img_comment"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isRelease",column = "is_release"),
            @Result(property = "releaseTime",column = "release_time")
    })
    public List<Picture> selectCatgAllPic(int imgCatg);

    /**
     * 查询某类型的所有图片信息
     * @return
     */
    @Select("select * from t_picture where img_catg=#{imgCatg} and is_release=#{isRelease}")
    @Results({
            @Result(property = "imgKey",column = "img_key"),
            @Result(property = "imgPath",column = "img_path"),
            @Result(property = "imgCatg",column = "img_catg"),
            @Result(property = "imgComment",column = "img_comment"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isRelease",column = "is_release"),
            @Result(property = "releaseTime",column = "release_time")
    })
    public List<Picture> selectCatgSomePic(int imgCatg,int isRelease);

    /**
     * 根据key查询图片路径
     * @param key
     * @return
     */
    @Select("select * from t_picture where img_key=#{key}")
    @Results({
            @Result(property = "imgKey",column = "img_key"),
            @Result(property = "imgPath",column = "img_path"),
            @Result(property = "imgCatg",column = "img_catg"),
            @Result(property = "imgComment",column = "img_comment"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isRelease",column = "is_release"),
            @Result(property = "releaseTime",column = "release_time")
    })
    public List<Picture> selectPicByKey(String key);


    /**
     * 插入图片
     * @param picture
     * @return
     */
    @Insert("insert into t_picture (img_key,img_path,img_catg,img_comment,create_time,is_release,release_time) " +
            "values(#{imgKey}, #{imgPath}, #{imgCatg},#{imgComment}, #{createTime}, #{isRelease}, #{releaseTime})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insertPic(Picture picture);

    /**
     * 批量插入图片
     * @param pictures
     * @return
     */
    @InsertProvider(type =Provider.class,method = "batchInsertPic")
    public int batchInsertPic(List<Picture> pictures);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @Delete("delete from t_picture where id=#{id}")
    public int deletePicById(int id);

    /**
     * 根据图片的key删除
     * @param key
     * @return
     */
    @Delete("delete from t_picture where img_key=#{key}")
    public int deletePicByKey(String key);

    /**
     * 根据key批量删除图片
     * @param keys
     * @return
     */
    @DeleteProvider(type=Provider.class,method = "batchDeletePicByKey")
    public int batchDeletePicByKey(List<String> keys);

    /**
     * 统计count
     * @return
     */
    @Select("select count(1) from t_picture")
    public int countPic();

    /**
     * 统计不同种类的图片的count
     * @return
     */
    @Select("select count(1) from t_picture where img_catg=#{imgCatg}")
    public int countCatgPic(int imgCatg);


    /**
     * 统计不同种类的图片的count
     * @return
     */
    @Select("update t_picture set isRelease=1 where id=#{imgid}")
    public int releaseImg(int imgid);


    class Provider{
        /**
         * 批量插入
         * @param map
         * @return
         */
        public String batchInsertPic(Map map){
            List<Picture> pictures = (List<Picture>) map.get("list");
            StringBuilder sb = new StringBuilder();

            sb.append("insert into t_picture (img_key,img_path,img_catg,img_comment,create_time,is_release,release_time) values ");

            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].imgKey}, #'{'list[{0}].imgPath}, #'{'list[{0}].imgCatg}, " +
                            "#'{'list[{0}].imgComment}, #'{'list[{0}].createTime}, #'{'list[{0}].isRelease}, #'{'list[{0}].releaseTime})"
            );

            for (int i = 0; i < pictures.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < pictures.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }

        /**
         * 批量删除pic根据imgkey
         * @param map
         * @return
         */
        public String batchDeletePicByKey(Map map){
            List<String> keys = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_picture img_key in (");
            for (int i = 0; i < keys.size(); i++) {
                sb.append("'").append(keys.get(i)).append("'");
                if (i < keys.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();

        }
    }
}
