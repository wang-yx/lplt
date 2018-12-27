package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.wyx.proj.entity.AfterService;
import com.wyx.proj.entity.Company;
import org.apache.ibatis.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface AfterServiceDao {



    @Select("select * from t_after_service order by create_time desc ")
    public List<AfterService> selectAllAfterServices();

    @SelectProvider(type = Provider.class,method = "selectSomeAfterServices")
    public List<AfterService> selectSomeAfterServices(String name,Date startTime, Date endTime,String industry,Integer isaftersale,Integer limit, Integer offset);

    @SelectProvider(type = Provider.class,method = "selectAllCount")
    public int selectAllCount(String name,Date startTime, Date endTime);

    @Select("select * from t_after_service where id=#{id} ")
    public AfterService selectAfterServiceById(int id);


    @Insert("insert into t_after_service (name,phone,email,company,question,reply,industry,isaftersale) " +
            "values(#{name},#{phone},#{email},#{company},#{question},#{reply},#{industry},#{isaftersale})")
    public int insertAfterService(AfterService afterService);


    @UpdateProvider(type = Provider.class,method = "updateAfterService")
    public int updateAfterService(AfterService afterService);


    @Update("update t_after_service set reply=#{reply} where id=#{id} ")
    public int updateAfterServiceReply(int id, String reply);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @UpdateProvider(type = Provider.class,method = "batchDeleteAfterService")
    public int batchDeleteAfterService(List<Integer> ids);



    class Provider {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        public String selectSomeAfterServices(String name,Date startTime, Date endTime,String industry,Integer isaftersale,Integer limit, Integer offset){
            StringBuilder sb = new StringBuilder();
            sb.append("select * from t_after_service where 1=1  ");

            if(isaftersale!=null){
                sb.append(" and isaftersale ="+ isaftersale +" " );
            }
            if(!StringUtils.isEmpty(industry)){
                sb.append(" and industry like '%"+ industry +"%' " );
            }
            if(!StringUtils.isEmpty(name)){
                sb.append(" and name like '%"+ name +"%' " );
            }
            if(startTime!=null){
                String startTimeStr = s.format(startTime);
                sb.append(" and createtime >= '"+ startTimeStr +"' " );
            }
            if(endTime!=null){
                String endTimeStr = s.format(endTime);
                sb.append(" and createtime <= '"+ endTimeStr +"' " );
            }

            if(limit != null && offset != null){
                sb.append("  order by createtime desc  limit " + offset + "," + limit);
            }
            System.out.println("-------->"+sb.toString());
            return sb.toString();
        }

        public String selectAllCount(String name,Date startTime, Date endTime){
            StringBuilder sb = new StringBuilder();
            sb.append("select count(1) from t_after_service where 1=1  ");

            if(!StringUtils.isEmpty(name)){
                sb.append(" and name like '%"+ name +"%' " );
            }
            if(startTime!=null){
                String startTimeStr = s.format(startTime);
                sb.append(" and createtime >= '"+ startTimeStr +"' " );
            }
            if(endTime!=null){
                String endTimeStr = s.format(endTime);
                sb.append(" and createtime <= '"+ endTimeStr +"' " );
            }

            return sb.toString();

        }

        public String batchDeleteAfterService(Map map) {
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_after_service where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }

        public String updateAfterService(AfterService afterService){

            StringBuilder sb = new StringBuilder();
            sb.append("update t_after_service set ");

            if(afterService.getReply()!=null){
                sb.append(" reply='"+ afterService.getReply() +"',");
            }
            String nowStr = s.format(new Date());
            sb.append(" updatetime='"+ nowStr +"' ");

            return sb.toString() + " where id=" + afterService.getId();
        }
    }
}
