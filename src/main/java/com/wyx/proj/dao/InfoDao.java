package com.wyx.proj.dao;


import com.wyx.proj.entity.Company;
import com.wyx.proj.entity.Info;
import org.apache.ibatis.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface InfoDao {


    @Select("select * from t_info where isinfo=#{isinfo} order by createtime desc,isrelease desc ")
    public List<Info> selectInfos(int isinfo);


    @Select("select * from t_info where id=#{id} ")
    public Info selectInfoById(int id);


    @Insert("insert into t_info(chineseid,englishid,logokey,phone,email,zipcode,fax," +
            "person,registtime,isinfo,isrelease,releasetime) " +
            "values(#{chineseid},#{englishid},#{logokey},#{phone},#{email},#{zipcode},#{fax},#{person}," +
            "#{registtime},#{isinfo},#{isrelease},#{releasetime})")
    public int insertInfo(Info info);


    @UpdateProvider(type = Provider.class,method = "updateInfo")
    public int updateInfo(Info info);


    @Update("update t_info set isrelease=#{isrelease},releasetime=#{releasetime} where id=#{id} ")
    public int updateInfoIsRelease(int id,int isrelease,Date releasetime);

    @UpdateProvider(type = Provider.class,method = "batchDeleteInfo")
    public int batchDeleteInfo(List<Integer> ids);

    @Delete("delete from t_info where id=#{id}")
    public int DeleteInfoByid(int id);

    class Provider {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public String batchDeleteInfo(Map map) {
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_info where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }

        public String updateInfo(Info info){
            StringBuilder sb = new StringBuilder();
            sb.append("update t_info set ");

            if(info.getChineseid()!=null){
                sb.append(" chineseid='"+ info.getChineseid() +"',");
            }
            if(info.getEnglishid()!=null){
                sb.append(" englishid='"+ info.getEnglishid() +"',");
            }
            if(info.getLogokey()!=null){
                sb.append(" logokey='"+ info.getLogokey() +"',");
            }
            if(info.getPhone()!=null){
                sb.append(" phone='"+ info.getPhone() +"',");
            }
            if(info.getEmail()!=null){
                sb.append(" email='"+ info.getEmail() +"',");
            }
            if(info.getZipcode()!=null){
                sb.append(" zipcode='"+ info.getZipcode() +"',");
            }
            if(info.getFax()!=null){
                sb.append(" fax='"+ info.getFax() +"',");
            }
            if(info.getPerson()!=null){
                sb.append(" person='"+ info.getPerson() +"',");
            }
            if(info.getRegisttime()!=null){
                String nowStr = s.format(info.getRegisttime());
                sb.append(" registtime='"+ nowStr +"',");
            }
            if(info.getPerson()!=null){
                sb.append(" person='"+ info.getPerson() +"',");
            }
            if(info.getIsrelease()!=null){
                String nowStr = s.format(new Date());
                sb.append(" isrelease="+ info.getIsrelease() +",");
                sb.append(" releasetime='"+ nowStr +"',");
            }
            if(info.getIsinfo()!=null){
                sb.append(" isinfo="+ info.getIsinfo() +",");
            }
            String nowStr = s.format(new Date());
            sb.append(" updatetime='"+ nowStr +"' ");

            return sb.toString() + " where id=" + info.getId();
        }
    }



}
