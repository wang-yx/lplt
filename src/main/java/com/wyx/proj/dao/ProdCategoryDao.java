package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.wyx.proj.entity.Prodcategory;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface ProdCategoryDao {

    /*
    private String catgName;   //类别名称
    private String catgComment; //类别备注
    private Date createTime; //创建时间
     */


    /**
     * 所有产品类别
     * @return
     */
    @Select("select * from t_prodcategory order by create_time desc ")
    @Results({
            @Result(column = "catg_name", property = "catgName"),
            @Result(column = "catg_comment", property = "catgComment"),
            @Result(column = "create_time", property = "createTime")
    })
    public List<Prodcategory> selectAllProdcategoris();


    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_prodcategory where id=#{id} ")
    @Results({
            @Result(column = "catg_name", property = "catgName"),
            @Result(column = "catg_comment", property = "catgComment"),
            @Result(column = "create_time", property = "createTime")
    })
    public Prodcategory selectProdcategoryById(int id);

    /**
     * 插入数据
     * @param prodcategory
     * @return
     */
    @Insert("insert into t_prodcategory(catg_name,catg_comment) values(#{catgName},#{catgComment})")
    public int insertProdcategory(Prodcategory prodcategory);

    /**
     * 跟新数据
     * @param prodcategory
     * @return
     */
    @Update("update t_prodcategory set catg_name=#{catgName},catg_comment=#{catgComment} where id=#{id} ")
    public int updateProdcategory(Prodcategory prodcategory);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @UpdateProvider(type = Provider.class,method = "batchDeleteProdcategory")
    public int batchDeleteProdcategory(List<Integer> ids);



    class Provider{


        public String batchDeleteProdcategory(Map map){
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_prodcategory where id in (");
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
