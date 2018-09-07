package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface ProductDao {

    /*
    private String prodName;  //产品名称
    private int prodCatg; //产品分类
    private String prodImgskey; //小图片，目录中显示
    private String prodImgmkey; //中图片，list中显示
    private String prodImglkey; //大图片
    private String prodIntroduce; //产品简介
    private String prodDetail; //产品详细
    private String prodComment; // 公司备注
    private Date createTime; //创建时间
    private int isRelease; //是否发布，0不发布，1发布
    private Date releaseTime; //发布时间
    private int showHomepage; //是否显示在首页，0不显示，1显示
     */

    /*
    @Select("select id,user_name from t_user ")
    @Results({
        @Result(property = "userName",column = "user_name")
    })
    public List<User> selectAll();
    */

    /**
     * 所有产品
     * @return
     */
    @Select("select * from t_product order by is_release asc,create_time desc ")
    public List<Product> selectAllProds();


    /**
     * 所有发布或者未发布的的产品
     * @return
     */
    @Select("select * from t_product where is_release=#{isRelease} order by create_time desc ")
    public List<Product> selectAllReleaseProds(int isRelease);


    /**
     * 按条件查询产品
     * @param prodName
     * @param prodCatg
     * @param isRelease
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(type =Provider.class,method = "searchProducts")
    public List<Product> searchProducts(String prodName, Integer prodCatg, Integer isRelease, Date startTime,Date endTime);

    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_product where id=#{id} ")
    public Product selectProdById(int id);

    /**
     * 插入数据
     * @param product
     * @return
     */
    @Insert("insert into t_product(prod_name,prod_catg,prod_imgskey,prod_imgmkey,prod_imglkey,prod_introduce,prod_detail,prod_comment,is_release,show_homepage) " +
            "values(#{prodName},#{prodCatg},#{prodImgskey},#{prodImgmkey},#{prodImglkey},#{prodIntroduce},#{prodDetail},#{prodComment},#{isRelease},#{showHomepage})")
    public int insertProd(Product product);

    /**
     * 跟新数据
     * @param product
     * @return
     */
    @Update("update t_product set prod_name=#{prodName},prod_catg=#{prodCatg},prod_imgskey=#{prodImgskey},prod_imgmkey=#{prodImgmkey}" +
            ",prod_imglkey=#{prodImglkey},prod_introduce=#{prodIntroduce},prod_detail=#{prodDetail},prod_comment=#{prodComment}" +
            ",is_release=#{isRelease},show_homepage=#{showHomepage} where id=#{id} ")
    public int updateProd(Product product);

    /**
     * 跟新showHomepage字段
     * @param id
     * @param showHomepage
     * @return
     */
    @Update("update t_product set show_homepage=#{showHomepage} where id=#{id} ")
    public int updateProdShowHomepage(int id,int showHomepage);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @UpdateProvider(type = Provider.class,method = "batchDeleteProd")
    public int batchDeleteProd(List<Integer> ids);



    class Provider{

        public String searchProducts(String prodName, Integer prodCatg, Integer isRelease, Date startTime,Date endTime){

            System.out.println("-----1111111-->");

            StringBuilder sb = new StringBuilder();
            sb.append("select * from t_product where 1=1 ");

            System.out.println("-----1111111-->");

            if(!StringUtils.isEmpty(prodName)){
                sb.append(" and prod_name like '%"+ prodName +"%' " );
            }

            System.out.println("-----1111111-->");

            if(prodCatg!=null){
                sb.append(" and prod_catg = "+ prodCatg + " " );
            }

            System.out.println("-----1111111-->");
//            if(isRelease!=0 && isRelease!=1){
//                sb.append(" and is_release = "+ isRelease +" " );
//            }

            System.out.println("-----1111111-->");
            if(startTime!=null){
                sb.append(" and create_time >= "+ startTime +" " );
            }

            System.out.println("-----1111111-->");

            if(endTime!=null){
                sb.append(" and create_time = "+ endTime +" " );
            }

            System.out.println("------->"+sb.toString());

            return sb.toString();
        }


        public String batchDeleteProd(Map map){
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_product where id in (");
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
