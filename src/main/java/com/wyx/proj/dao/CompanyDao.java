package com.wyx.proj.dao;


import com.wyx.proj.entity.Company;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface CompanyDao {


    @Select("select * from t_company where id=#{id} ")
    public Company selectCompanyById(int id);


    @Insert("insert into t_company(name,introduce,detail,comment,city,address,language) " +
            "values(#{name},#{introduce},#{detail},#{comment},#{city},#{address},#{language})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insertCompanyInfo(Company company);


    @UpdateProvider(type = Provider.class,method ="updateCompany")
    public int updateCompany(Company company);

    @DeleteProvider(type = Provider.class,method = "batchDeleteCompany")
    public int batchDeleteCompany(List<Integer> ids);

    @Delete("delete from t_company where id=#{id}")
    public int deleteCompanyById(int id);

    class Provider {
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public String batchDeleteCompany(Map map) {
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_company where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }

        public String updateCompany(Company company){
            StringBuilder sb = new StringBuilder();
            sb.append("update t_company set (");

            if(company.getName()!=null){
                sb.append(" name='"+ company.getName() +"',");
            }
            if(company.getIntroduce()!=null){
                sb.append(" introduce='"+ company.getIntroduce() +"',");
            }
            if(company.getDetail()!=null){
                sb.append(" detail='"+ company.getDetail() +"',");
            }
            if(company.getComment()!=null){
                sb.append(" comment='"+ company.getComment() +"',");
            }
            if(company.getCity()!=null){
                sb.append(" city='"+ company.getCity() +"',");
            }
            if(company.getAddress()!=null){
                sb.append(" address='"+ company.getAddress() +"',");
            }
            if(company.getLanguage()!=null){
                sb.append(" language="+ company.getLanguage() +",");
            }
            String nowStr = s.format(new Date());
            sb.append(" updatetime='"+ nowStr +"' ");

            return sb.toString() + " where id=" + company.getId();
        }

    }
}
