package com.wyx.proj.dao;


import com.alibaba.druid.util.StringUtils;
import com.wyx.proj.bean.ProdCategoryBean;
import com.wyx.proj.entity.Prodcategory;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Mapper
public interface ProdCategoryDao {

    /**
     * 所有产品类别
     * @return
     */
    @Select("select * from t_prodcategory order by createtime ")
    public List<Prodcategory> selectAllProdcategoris();

    /**
     * 所有产品类别
     * @return
     */
    @Select("select * from t_prodcategory order by createtime desc ")
    public List<Prodcategory> selectAllProdcategoris2();

    @SelectProvider(type = Provider.class,method = "selectSome")
    public List<Prodcategory> selectSome(ProdCategoryBean prodCategoryBean);



    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_prodcategory where id=#{id} ")
    public Prodcategory selectProdcategoryById(int id);

    /**
     * 插入数据
     * @param prodcategory
     * @return
     */
    @Insert("insert into t_prodcategory(name,nameen,comment,parent,type) values(#{name},#{nameen},#{comment},#{parent},#{type})")
    public int insertProdcategory(Prodcategory prodcategory);

    /**
     * 跟新数据
     * @param prodcategory
     * @return
     */
    @Update("update t_prodcategory set name=#{name},nameen=#{nameen},comment=#{comment},parent=#{parent},type=#{type} where id=#{id} ")
    public int updateProdcategory(Prodcategory prodcategory);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @UpdateProvider(type = Provider.class,method = "batchDeleteProdcategory")
    public int batchDeleteProdcategory(List<Integer> ids);



    class Provider{

        public String selectSome(ProdCategoryBean prodCategoryBean){
            StringBuilder sb = new StringBuilder();
            sb.append("select * from t_prodcategory where 1=1 ");

            if(prodCategoryBean.getId()!=null){
                sb.append(" and id = "+ prodCategoryBean.getId() + " " );
            }
            if(!StringUtils.isEmpty(prodCategoryBean.getName())){
                sb.append(" and name like '%"+ prodCategoryBean.getName() +"%' " );
            }

            if(!StringUtils.isEmpty(prodCategoryBean.getNameen())){
                sb.append(" and nameen like '%" + prodCategoryBean.getNameen()+"%' ");
            }
            if(prodCategoryBean.getParent()!=null){
                sb.append(" and parent = "+ prodCategoryBean.getParent() + " " );
            }
            if(prodCategoryBean.getType()!=null){
                sb.append(" and type = "+ prodCategoryBean.getType() + " " );
            }

            sb.append(" order by createtime desc");

            System.out.println("---->"+sb.toString());
            return sb.toString();
        }


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
