package com.wyx.proj.dao;

import com.wyx.proj.entity.ProductDetail;
import org.apache.ibatis.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface ProductDetailDao {


    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_product_detail where id=#{id} ")
    public ProductDetail selectProdDetailById(int id);

    /**
     * 插入数据
     * @param productDetail
     * @return
     */
    @Insert("insert into t_product_detail (name,maker,dealer,type,brand,source," +
            "introduce,techadvantage,techparams,detail,comment,language) " +
            "values(#{name},#{maker},#{dealer},#{type},#{brand},#{source}," +
            "#{introduce},#{techadvantage},#{techparams},#{detail},#{comment},#{language})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insertProdDetail(ProductDetail productDetail );

    /**
      * 跟新数据
      * @param productDetail
      * @return
      */

    @UpdateProvider(type =Provider.class,method = "updateProductDetail")
    public int updateProdDetail(ProductDetail productDetail);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteProvider(type = Provider.class,method = "batchDeleteProd")
    public int batchDeleteProd(List<Integer> ids);



    class Provider{
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public String updateProductDetail(ProductDetail product){

            StringBuilder sb = new StringBuilder();
            sb.append("update t_product_detail set ");

            if(product.getName() !=null){
                sb.append(" name='"+product.getName()+"',");
            }
            if(product.getMaker()!=null){
                sb.append(" maker='"+ product.getMaker() + "'," );
            }
            if(product.getDealer()!=null){
                sb.append(" dealer='"+ product.getDealer() + "'," );
            }
            if(product.getType()!=null){
                sb.append(" type='"+ product.getType() + "'," );
            }
            if(product.getBrand()!=null){
                sb.append(" brand='"+ product.getBrand() + "'," );
            }
            if(product.getSource()!=null){
                sb.append(" source='"+ product.getSource() + "'," );
            }
            if(product.getIntroduce()!=null){
                sb.append(" introduce='"+ product.getIntroduce() + "'," );
            }
            if(product.getTechadvantage()!=null){
                sb.append(" techadvantage='"+ product.getTechadvantage() + "'," );
            }
            if(product.getTechparams()!=null){
                sb.append(" techparams='"+ product.getTechparams() + "'," );
            }
            if(product.getApplicationarea() !=null){
                sb.append(" applicationarea='"+ product.getApplicationarea() + "'," );
            }
            if(product.getDetail()!=null){
                sb.append(" detail='"+ product.getDetail() + "'," );
            }
            if(product.getComment()!=null){
                sb.append(" comment='"+ product.getComment() + "'," );
            }
            if(product.getLanguage()!=null){
                sb.append(" language = "+ product.getLanguage() +"," );
            }

            String dateStr = s.format(new Date());
            sb.append(" updatetime = '" + dateStr +"' ");

            return sb.toString() + " where id=" + product.getId();
        }

        public String batchDeleteProd(Map map){
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_product_detail where id in (");
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
