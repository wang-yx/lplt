package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface ProductDao {

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
    public List<Product> searchProducts(String prodName,String type,String brand,Integer prodCatg,Integer language,
                                        Integer isRelease, Integer showHomepage, Integer limit, Integer offset, Date startTime,Date endTime);


    /**
     * 按条件查询产品
     * @param prodName
     * @param prodCatg
     * @param isRelease
     * @param startTime
     * @param endTime
     * @return
     */
    @SelectProvider(type =Provider.class,method = "searchProductsCount")
    public int searchProductsCount(String prodName,String type,String brand,Integer prodCatg,Integer language,
                                   Integer isRelease, Integer showHomepage, Date startTime,Date endTime);



    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_product where id=#{id} ")
    public Product selectProdById(int id);


    /**
     * 根据id获取
     * @return
     */
    @SelectProvider(type =Provider.class,method = "searchByIdList")
    public List<Product> selectProdByIdList(List<Integer> ids);

    /**
     * 插入数据
     * @param product
     * @return
     */
    @Insert("insert into t_product(englishid,chineseid,categoryid,img,salehotline," +
            "servicehotline,isrelease,releasetime,showhomepage) " +
            "values(#{englishid},#{chineseid},#{categoryid},#{img},#{salehotline}," +
            "#{servicehotline},#{isrelease},#{releasetime},#{showhomepage})")
    public int insertProd(Product product);



    /**
      * 跟新数据
      * @param product
      * @return
      */

    @UpdateProvider(type =Provider.class,method = "updateProduct")
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
     *
     * @param id
     * @param isRelease
     * @param releaseTime
     * @return
     */
    @Update("update t_product set is_release=#{isRelease},release_time=#{releaseTime} where id=#{id} ")
    public int updateProdIsRelease(int id,int isRelease,Date releaseTime);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteProvider(type = Provider.class,method = "batchDeleteProd")
    public int batchDeleteProd(List<Integer> ids);



    class Provider{
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public String searchProducts(String prodName,String type,String brand,Integer prodCatg,Integer language,
                                     Integer isRelease, Integer showHomepage, Integer limit, Integer offset, Date startTime,Date endTime){

            StringBuilder sb = new StringBuilder();
            sb.append("select *,b.name as name from t_product a join t_product_detail b on ");

            String languageField = "chineseid";
            if(language!=null && language!=0){
                languageField = "englishid";
            }
            sb.append(" a." + languageField + "=b.id " );


            if(prodCatg!=null){
                sb.append(" and categoryid = "+ prodCatg + " " );
            }

            if(isRelease!=null){
                sb.append(" and isrelease = "+ isRelease +" " );
            }

            if(showHomepage != null){
                sb.append(" and showhomepage = " + showHomepage);
            }

            if(startTime!=null){
                String dateStr = s.format(startTime);
                sb.append(" and a.createtime >= '"+ dateStr +"' " );
            }
            if(endTime!=null){
                String dateStr = s.format(endTime);
                sb.append(" and a.createtime <= '"+ dateStr +"' " );
            }
            if(!StringUtils.isEmpty(prodName)){
                sb.append(" and b.name like '%"+ prodName +"%' " );
            }
            if(!StringUtils.isEmpty(type)){
                sb.append(" and type = '"+ type +"' " );
            }
            if(!StringUtils.isEmpty(prodName)){
                sb.append(" and brand = '"+ brand +"' " );
            }

            if(limit != null && offset != null){
                sb.append(" order by a.createtime desc limit " + offset + "," + limit );
            }
            System.out.println("---->"+sb.toString());
            return sb.toString();
        }

        public String searchProductsCount(String prodName, String type,String brand,Integer prodCatg,Integer language, Integer isRelease, Integer showHomepage, Date startTime,Date endTime){

            StringBuilder sb = new StringBuilder();
            sb.append("select count(1)  from t_product a join t_product_detail b on ");

            String languageField = "chineseid";
            if(language!=null && language!=0){
                languageField = "englishid";
            }
            sb.append(" a." + languageField + "=b.id " );


            if(prodCatg!=null){
                sb.append(" and categoryid = "+ prodCatg + " " );
            }

            if(isRelease!=null){
                sb.append(" and isrelease = "+ isRelease +" " );
            }

            if(showHomepage != null){
                sb.append(" and showhomepage = " + showHomepage);
            }

            if(startTime!=null){
                String dateStr = s.format(startTime);
                sb.append(" and a.createtime >= '"+ dateStr +"' " );
            }
            if(endTime!=null){
                String dateStr = s.format(endTime);
                sb.append(" and a.createtime <= '"+ dateStr +"' " );
            }
            if(!StringUtils.isEmpty(prodName)){
                sb.append(" and b.name like '%"+ prodName +"%' " );
            }
            if(!StringUtils.isEmpty(type)){
                sb.append(" and type = '"+ type +"' " );
            }
            if(!StringUtils.isEmpty(prodName)){
                sb.append(" and brand = '"+ brand +"' " );
            }
            System.out.println("---->"+sb.toString());
            return sb.toString();
        }

        public String updateProduct(Product product){
            StringBuilder sb = new StringBuilder();
            sb.append("update t_product set ");

            if(product.getCategoryid() !=null){
                sb.append(" categoryid="+product.getCategoryid()+",");
            }
            if(product.getImg()!=null){
                sb.append(" img='"+ product.getImg() + "'," );
            }
            if(product.getSalehotline()!=null){
                sb.append(" salehotline='"+ product.getSalehotline() + "'," );
            }

            if(product.getServicehotline()!=null){
                sb.append(" servicehotline='"+ product.getServicehotline() + "'," );
            }
            if(product.getIsrelease()!=null){
                String dateStr = s.format(new Date());
                sb.append(" isrelease = "+ product.getIsrelease() +"," );
                sb.append(" releasetime = '"+ dateStr +"'," );
            }
            if(product.getShowhomepage() != null){
                sb.append(" showhomepage = " + product.getShowhomepage() +",");
            }

            String dateStr = s.format(new Date());
            sb.append(" updatetime = '" + dateStr +"' ");
            return sb.toString() + " where id=" + product.getId();
        }


        public String searchByIdList(Map map){
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("select * from t_product where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
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
