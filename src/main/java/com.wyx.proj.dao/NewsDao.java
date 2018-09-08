package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wyx.proj.entity.News;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface NewsDao {

    /*
    private String newName;  //新闻名称
    private String newImgskey; //小图片，目录中显示
    private String newImgmkey; //中图片，list中显示
    private String newImglkey; //大图片
    private String newIntroduce; //新闻简介
    private String newDetail; //新闻详细
    private String newComment; // 新闻备注
    private Date createTime; //创建时间
    private int isRelease; //是否发布，0不发布，1发布
    private Date releaseTime; //发布时间
    private int showHomepage; //是否显示在首页，0不显示，1显示
    private int readNum;//浏览量
     */

    /**
     * 所有新闻
     * @return
     */
    @Select("select * from t_news order by is_release asc,create_time desc ")
    @Results({
            @Result(column = "new_name", property = "newName"),
            @Result(column = "new_imgskey", property = "newImgskey"),
            @Result(column = "new_imgmkey", property = "newImgmkey"),
            @Result(column = "new_imglkey", property = "newImglkey"),
            @Result(column = "new_introduce", property = "newIntroduce"),
            @Result(column = "new_detail", property = "newDetail"),
            @Result(column = "new_comment", property = "newComment"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "is_release", property = "isRelease"),
            @Result(column = "release_time", property = "releaseTime"),
            @Result(column = "show_homepage", property = "showHomepage"),
            @Result(column = "read_num", property = "readNum")
    })
    public List<Product> selectAllNews();


    /**
     * 所有发布或者未发布的的新闻
     * @return
     */
    @Select("select * from t_news where is_release=#{isRelease} order by create_time desc ")
    @Results({
            @Result(column = "new_name", property = "newName"),
            @Result(column = "new_imgskey", property = "newImgskey"),
            @Result(column = "new_imgmkey", property = "newImgmkey"),
            @Result(column = "new_imglkey", property = "newImglkey"),
            @Result(column = "new_introduce", property = "newIntroduce"),
            @Result(column = "new_detail", property = "newDetail"),
            @Result(column = "new_comment", property = "newComment"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "is_release", property = "isRelease"),
            @Result(column = "release_time", property = "releaseTime"),
            @Result(column = "show_homepage", property = "showHomepage"),
            @Result(column = "read_num", property = "readNum")
    })
    public List<Product> selectAllReleaseNews(int isRelease);


    /**
     * 查询符合条件的新闻
     * @param newName
     * @param newCatg
     * @param isRelease
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(type =Provider.class,method = "searchNews")
    @Results({
            @Result(column = "new_name", property = "newName"),
            @Result(column = "new_imgskey", property = "newImgskey"),
            @Result(column = "new_imgmkey", property = "newImgmkey"),
            @Result(column = "new_imglkey", property = "newImglkey"),
            @Result(column = "new_introduce", property = "newIntroduce"),
            @Result(column = "new_detail", property = "newDetail"),
            @Result(column = "new_comment", property = "newComment"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "is_release", property = "isRelease"),
            @Result(column = "release_time", property = "releaseTime"),
            @Result(column = "show_homepage", property = "showHomepage"),
            @Result(column = "read_num", property = "readNum")
    })
    public List<Product> searchNews(String newName, Integer newCatg, Integer isRelease, Date startTime, Date endTime);

    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_news where id=#{id} ")
    @Results({
            @Result(column = "new_name", property = "newName"),
            @Result(column = "new_imgskey", property = "newImgskey"),
            @Result(column = "new_imgmkey", property = "newImgmkey"),
            @Result(column = "new_imglkey", property = "newImglkey"),
            @Result(column = "new_introduce", property = "newIntroduce"),
            @Result(column = "new_detail", property = "newDetail"),
            @Result(column = "new_comment", property = "newComment"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "is_release", property = "isRelease"),
            @Result(column = "release_time", property = "releaseTime"),
            @Result(column = "show_homepage", property = "showHomepage"),
            @Result(column = "read_num", property = "readNum")
    })
    public Product selectNewById(int id);

    /**
     * 插入数据
     * @param news
     * @return
     */
    @Insert("insert into t_news(new_name,new_imgskey,new_imgmkey,new_imglkey,new_introduce,new_detail,new_comment,is_release,show_homepage) " +
            "values(#{newName},#{newImgskey},#{newImgmkey},#{newImglkey},#{newIntroduce},#{newDetail},#{newComment},#{isRelease},#{showHomepage})")
    public int insertNew(News news);

    /**
     * 跟新数据
     * @param news
     * @return
     */
    @Update("update t_news set new_name=#{newName},new_imgskey=#{newImgskey},new_imgmkey=#{newImgmkey}" +
            ",new_imglkey=#{newImglkey},new_introduce=#{newIntroduce},new_detail=#{newDetail},new_comment=#{newComment}" +
            ",is_release=#{isRelease},show_homepage=#{showHomepage} where id=#{id} ")
    public int updateNew(News news);

    /**
     * 跟新showHomepage字段
     * @param id
     * @param showHomepage
     * @return
     */
    @Update("update t_news set show_homepage=#{showHomepage} where id=#{id} ")
    public int updateNewShowHomepage(int id,int showHomepage);

    /**
     * 跟新readNum字段
     * @param id
     * @param readNum
     * @return
     */
    @Update("update t_news set read_num=#{readNum} where id=#{id} ")
    public int updateNewReadNum(int id,int readNum);

    /**
     *
     * @param id
     * @param isRelease
     * @param releaseTime
     * @return
     */
    @Update("update t_news set is_release=#{isRelease},release_time=#{releaseTime} where id=#{id} ")
    public int updateNewIsRelease(int id,int isRelease,Date releaseTime);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @UpdateProvider(type = Provider.class,method = "batchDeleteNews")
    public int batchDeleteNews(List<Integer> ids);



    class Provider{

        public String searchNews(String newName, Integer newCatg, Integer isRelease, Date startTime,Date endTime){

            StringBuilder sb = new StringBuilder();
            sb.append("select * from t_news where 1=1 ");

            if(!StringUtils.isEmpty(newName)){
                sb.append(" and new_name like '%"+ newName +"%' " );
            }

            if(newCatg!=null){
                sb.append(" and new_catg = "+ newCatg + " " );
            }

            if(isRelease!=null){
                sb.append(" and is_release = "+ isRelease +" " );
            }
            if(startTime!=null){
                sb.append(" and create_time >= "+ startTime +" " );
            }
            if(endTime!=null){
                sb.append(" and create_time = "+ endTime +" " );
            }
            return sb.toString();
        }


        public String batchDeleteNews(Map map){
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_news where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
