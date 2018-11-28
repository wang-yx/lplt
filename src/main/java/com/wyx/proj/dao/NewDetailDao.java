package com.wyx.proj.dao;



import com.wyx.proj.entity.NewDetail;
import org.apache.ibatis.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface NewDetailDao {


    @Select("select * from t_new_detail where id=#{id} ")
    public NewDetail selectNewDetailById(int id);

    @Insert("insert into t_new_detail (name,introduce,detail,comment,language) " +
            "values(#{name},#{introduce},#{detail},#{comment},#{language})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insertNewDetail(NewDetail newDetail);

    @UpdateProvider(type =Provider.class,method = "updateNewDetail")
    public int updateNewDetail (NewDetail newDetail);

    @DeleteProvider(type = Provider.class,method = "batchDeleteNewDetail")
    public int batchDeleteNewDetail (List<Integer> ids);

    @Delete("delete from t_new_detail where id=#{id}")
    public int deleteById(int id);


    class Provider{
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public String batchDeleteNewDetail(Map map){
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_new_detail where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }

        public String updateNewDetail(NewDetail newDetail){
            StringBuilder sb = new StringBuilder();
            sb.append("update t_new_detail set ");

            if(newDetail.getName()!=null){
                sb.append(" name='"+ newDetail.getName() +"',");
            }
            if(newDetail.getIntroduce()!=null){
                sb.append(" introduce='"+ newDetail.getIntroduce() +"',");
            }
            if(newDetail.getDetail()!=null){
                sb.append(" detail='"+ newDetail.getDetail() +"',");
            }
            if(newDetail.getComment()!=null){
                sb.append(" comment='"+ newDetail.getComment() +"',");
            }
            if(newDetail.getLanguage()!=null){
                sb.append(" language="+ newDetail.getLanguage() +",");
            }
            String nowStr = s.format(new Date());
            sb.append(" updatetime='"+ nowStr +"' ");

            return sb.toString() + " where id=" + newDetail.getId();
        }

    }
}
