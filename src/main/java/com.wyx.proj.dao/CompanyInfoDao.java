package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.wyx.proj.entity.CompanyInfo;
import com.wyx.proj.entity.News;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface CompanyInfoDao {

    /*
    private String comyName;  //公司名称
    private String comyLogokey; //logo图片key
    private String comyIntroduce; //公司简介
    private String comyDetail; //公司详细
    private String comyComment; // 公司备注
    private String comyCity; //城市
    private String comyAddress; //地址
    private String comyPhone; //电话☎️
    private String comyEmail; //邮箱
    private String comyZipcode; //邮编
    private String comyFax; //传真
    private String comyPerson;//法人或者是负责人
    private Date comyRegisttime; //注册时间
    private Date createTime; //创建时间
    private int isInfo; //是否是联系我们的info，还是公司信息，0不info，1是info
    private int isRelease; //是否发布，0不发布，1发布
    private Date releaseTime; //发布时间
     */

    /**
     * 所有公司信息
     * @return
     */
    @Select("select * from t_company order by is_release asc,create_time desc ")
    @Results({
            @Result(column = "comy_name", property = "comyName"),
            @Result(column = "comy_logokey", property = "comyLogokey"),
            @Result(column = "comy_introduce", property = "newIntroduce"),
            @Result(column = "comy_detail", property = "newDetail"),
            @Result(column = "comy_comment", property = "newComment"),
            @Result(column = "comy_city", property = "comyCity"),
            @Result(column = "comy_address", property = "comyAddress"),
            @Result(column = "comy_phone", property = "comyPhone"),
            @Result(column = "comy_email", property = "comyEmail"),
            @Result(column = "comy_zipcode", property = "comyZipcode"),
            @Result(column = "comy_fax", property = "comyFax"),
            @Result(column = "comy_person", property = "comyPerson"),
            @Result(column = "comy_registtime", property = "comyRegisttime"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "is_info", property = "isInfo"),
            @Result(column = "is_release", property = "isRelease"),
            @Result(column = "release_time", property = "releaseTime")
    })
    public List<CompanyInfo> selectAllCompanyInfos();


    /**
     * 所有发布或者未发布的的公司信息
     * @return
     */
    @Select("select * from t_company where is_release=#{isRelease} and is_info=#{isInfo} order by create_time desc ")
    @Results({
            @Result(column = "comy_name", property = "comyName"),
            @Result(column = "comy_logokey", property = "comyLogokey"),
            @Result(column = "comy_introduce", property = "newIntroduce"),
            @Result(column = "comy_detail", property = "newDetail"),
            @Result(column = "comy_comment", property = "newComment"),
            @Result(column = "comy_city", property = "comyCity"),
            @Result(column = "comy_address", property = "comyAddress"),
            @Result(column = "comy_phone", property = "comyPhone"),
            @Result(column = "comy_email", property = "comyEmail"),
            @Result(column = "comy_zipcode", property = "comyZipcode"),
            @Result(column = "comy_fax", property = "comyFax"),
            @Result(column = "comy_person", property = "comyPerson"),
            @Result(column = "comy_registtime", property = "comyRegisttime"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "is_info", property = "isInfo"),
            @Result(column = "is_release", property = "isRelease"),
            @Result(column = "release_time", property = "releaseTime")
    })
    public List<CompanyInfo> selectSomeCompanyInfo(int isRelease, int isInfo);


    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_company where id=#{id} ")
    @Results({
            @Result(column = "comy_name", property = "comyName"),
            @Result(column = "comy_logokey", property = "comyLogokey"),
            @Result(column = "comy_introduce", property = "comyIntroduce"),
            @Result(column = "comy_detail", property = "comyDetail"),
            @Result(column = "comy_comment", property = "comyComment"),
            @Result(column = "comy_city", property = "comyCity"),
            @Result(column = "comy_address", property = "comyAddress"),
            @Result(column = "comy_phone", property = "comyPhone"),
            @Result(column = "comy_email", property = "comyEmail"),
            @Result(column = "comy_zipcode", property = "comyZipcode"),
            @Result(column = "comy_fax", property = "comyFax"),
            @Result(column = "comy_person", property = "comyPerson"),
            @Result(column = "comy_registtime", property = "comyRegisttime"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "is_info", property = "isInfo"),
            @Result(column = "is_release", property = "isRelease"),
            @Result(column = "release_time", property = "releaseTime")
    })
    public CompanyInfo selectCompanyInfoById(int id);


    /**
     * 插入数据
     * @param companyInfo
     * @return
     */
    @Insert("insert into t_company(comy_name,comy_logokey,comy_introduce,comy_detail,comy_comment,comy_city,comy_address," +
            "comy_phone,comy_email,comy_zipcode,comy_fax,comy_person,comy_registtime,create_time,is_info,is_release,release_time) " +
            "values(#{comyName},#{comyLogokey},#{comyIntroduce},#{comyDetail},#{comyComment},#{comyCity},#{comyAddress},#{comyPhone}," +
            "#{comyEmail},#{comyZipcode},#{comyFax},#{comyPerson},#{comyRegisttime},#{createTime},#{isInfo},#{isRelease}" +
            ",#{releaseTime})")
    public int insertCompanyInfo(CompanyInfo companyInfo);

    /**
     * 跟新数据
     * @param companyInfo
     * @return
     */
    @Update("update t_company set comy_name=#{comyName},comy_logokey=#{comyLogokey},comy_introduce=#{comyIntroduce}" +
            ",comy_detail=#{comyDetail},comy_comment=#{comyComment},comy_city=#{comyCity},comy_address=#{comyAddress}" +
            ",comy_phone=#{comyPhone},comy_email=#{comyEmail},comy_zipcode=#{comyZipcode},comy_fax=#{comyFax}" +
            ",comy_person=#{comyPerson},comy_registtime=#{comyRegisttime},is_info=#{isInfo},is_release=#{isRelease}" +
            ",release_time=#{releaseTime} where id=#{id} ")
    public int updateCompanyInfo(CompanyInfo companyInfo);

    /**
     * 跟新showHomepage字段
     * @param id
     * @param isRelease
     * @return
     */
    @Update("update t_company set is_release=#{isRelease},release_time=#{releaseTime} where id=#{id} ")
    public int updateCompanyInfoIsRelease(int id,int isRelease,Date releaseTime);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @UpdateProvider(type = NewsDao.Provider.class,method = "batchDeleteCompanyInfo")
    public int batchDeleteCompanyInfo(List<Integer> ids);



    class Provider {


        public String batchDeleteCompanyInfo(Map map) {
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
    }
}
