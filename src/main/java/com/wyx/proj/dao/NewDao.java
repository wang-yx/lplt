package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.wyx.proj.entity.New;
import org.apache.ibatis.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface NewDao {


    /**
     * 所有新闻
     *
     * @return
     */
    @Select("select * from t_new order by isrelease asc,createtime desc ")
    public List<New> selectAllNews();


    @Select("select count(*) from t_new where isrelease=#{isrelease}")
    public int count(int isrelease);

    /**
     * 所有发布或者未发布的的新闻
     *
     * @return
     */
    @Select("select * from t_new where isrelease=#{isrelease} order by createtime desc ")
    public List<New> selectAllReleaseNews(int isrelease);


    @SelectProvider(type = Provider.class, method = "searchNewsCount")
    public int searchNewsCount(String name, Integer isRelease, Date startTime, Date endTime, Integer language);


    @SelectProvider(type = Provider.class, method = "searchNews")
    public List<New> searchNews(String name, Integer isRelease, Integer limit, Integer offset, Date startTime, Date endTime, Integer language);


    /**
     * 根据id获取
     *
     * @return
     */
    @Select("select * from t_new where id=#{id} ")
    public New selectNewById(int id);


    /**
     * 插入数据
     *
     * @param news
     * @return
     */
    @Insert("insert into t_new(englishid,chineseid,img,isrelease,releasetime,showhomepage,readnum) " +
            "values(#{englishid},#{chineseid},#{img},#{isrelease},#{releasetime},#{showhomepage},#{readnum})")
    public int insertNew(New news);


    @UpdateProvider(type = Provider.class, method = "updateNews")
    public int updateNew(New news);


    @Update("update t_new set readnum=#{readnum} where id=#{id} ")
    public int updateNewReadNum(int id, int readnum);


    @Update("update t_new set isrelease=#{isrelease},releasetime=#{releasetime} where id=#{id} ")
    public int updateNewIsRelease(int id, int isrelease, Date releasetime);


    /**
     * @param id
     * @return
     */
    @Update("delete from t_new where id=#{id} ")
    public int deleteNewById(int id);


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @DeleteProvider(type = Provider.class, method = "batchDeleteNews")
    public int batchDeleteNews(List<Integer> ids);


    class Provider {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public String searchNewsCount(String newName, Integer isRelease, Date startTime, Date endTime, Integer language) {

            StringBuilder sb = new StringBuilder();
            sb.append("select count(1) from t_new a join t_new_detail b on ");

            String languageField = "chineseid";
            if (language != 0) {
                languageField = "englishid";
            }
            sb.append(" a." + languageField + "=b.id ");

            if (!StringUtils.isEmpty(newName)) {
                sb.append(" and b.name like '%" + newName + "%' ");
            }
            if (isRelease != null) {
                sb.append(" and isrelease = " + isRelease + " ");
            }
            if (startTime != null) {
                String startTimeStr = s.format(startTime);
                sb.append(" and a.createtime >= '" + startTimeStr + "' ");
            }
            if (endTime != null) {
                String endTimeStr = s.format(endTime);
                sb.append(" and a.createtime <= '" + endTimeStr + "' ");
            }
            System.out.println("---sql-->" + sb.toString());
            return sb.toString();
        }

        public String searchNews(String newName, Integer isRelease, Integer limit, Integer offset,
                                 Date startTime, Date endTime, Integer language) {

            StringBuilder sb = new StringBuilder();
            sb.append("select *,b.name as name,b.introduce as introduce from t_new a join t_new_detail b on ");

            String languageField = "chineseid";
            if (language != 0) {
                languageField = "englishid";
            }
            sb.append(" a." + languageField + "=b.id ");

            if (!StringUtils.isEmpty(newName)) {
                sb.append(" and b.name like '%" + newName + "%' ");
            }
            if (isRelease != null) {
                sb.append(" and isrelease = " + isRelease + " ");
            }
            if (startTime != null) {
                String startTimeStr = s.format(startTime);
                sb.append(" and a.createtime >= '" + startTimeStr + "' ");
            }
            if (endTime != null) {
                String endTimeStr = s.format(endTime);
                sb.append(" and a.createtime <= '" + endTimeStr + "' ");
            }

            if (limit != null && offset != null) {
                sb.append("  order by a.createtime desc  limit " + offset + "," + limit);
            }
            return sb.toString();
        }


        public String batchDeleteNews(Map map) {
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_new where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }

        public String updateNews(New news) {
            StringBuilder sb = new StringBuilder();
            sb.append("update t_new set ");

            if (news.getImg() != null) {
                sb.append(" img='" + news.getImg() + "',");
            }
            if (news.getIsrelease() != null) {
                String nowStr = s.format(new Date());
                sb.append(" isrelease=" + news.getIsrelease() + ",");
                sb.append(" releasetime='" + nowStr + "',");
            }
            if (news.getShowhomepage() != null) {
                sb.append(" showhomepage=" + news.getShowhomepage() + ",");
            }
            if (news.getReadnum() != null) {
                sb.append(" readnum=" + news.getReadnum() + ",");
            }
            String nowStr = s.format(new Date());
            sb.append(" updatetime='" + nowStr + "' ");

            return sb.toString() + " where id=" + news.getId();
        }

    }
}
