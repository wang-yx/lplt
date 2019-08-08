package com.wyx.proj.service;

import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.bean.ProdCategoryBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.entity.Prodcategory;
import com.wyx.proj.entity.Product;

import java.util.List;

public interface ProductCategoryService extends BaseService<Prodcategory> {

    List<Prodcategory> selectAll() throws Exception;

    List<Prodcategory> selectAll2() throws Exception;

    public Prodcategory getProdDetail(int id) throws Exception;

    public boolean save(Prodcategory prodcategory) throws Exception;

    public boolean deleteProdcategoryByid(int id) throws Exception;

    List<Prodcategory> selectSome(ProdCategoryBean prodCategoryBean) throws Exception;

}
