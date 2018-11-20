package com.wyx.proj.service.impl;

import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.dao.ProdCategoryDao;
import com.wyx.proj.dao.ProductDao;
import com.wyx.proj.entity.Prodcategory;
import com.wyx.proj.entity.Product;
import com.wyx.proj.service.ProductCategoryService;
import com.wyx.proj.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productCategoryService")
public class ProductCategoryServiceImpl extends BaseServiceImpl<Prodcategory> implements ProductCategoryService {

    private final Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

    @Override
    public List<Prodcategory> selectAll() throws Exception {
        return getProdCategoryDao().selectAllProdcategoris();
    }

    @Override
    public Prodcategory getProdDetail(int id) throws Exception {
        return getProdCategoryDao().selectProdcategoryById(id);
    }

    @Override
    public boolean save(Prodcategory prodcategory) throws Exception {
        int resultNum = 0;
        if(prodcategory.getId()!=0){
            resultNum = getProdCategoryDao().updateProdcategory(prodcategory);
        }else{
            resultNum = getProdCategoryDao().insertProdcategory(prodcategory);
        }
        return resultNum>0;
    }

    @Override
    public boolean deleteProdcategoryByid(int id) throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        return getProdCategoryDao().batchDeleteProdcategory(ids)>0;
    }

    /**
     *  ProdCategoryDao
     * @return
     */
    public ProdCategoryDao getProdCategoryDao() {
        return getBaseDao().getMapper(ProdCategoryDao.class);
    }
}
