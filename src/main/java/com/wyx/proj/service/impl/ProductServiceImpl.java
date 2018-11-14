package com.wyx.proj.service.impl;

import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.dao.PictureDao;
import com.wyx.proj.dao.ProductDao;
import com.wyx.proj.entity.Picture;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import com.wyx.proj.service.PictureService;
import com.wyx.proj.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public PageResponseBean<Product> queryByCondition(ProductBean productBean) throws Exception {

        PageResponseBean<Product> resultData = null;
        List<Product> tempList = new ArrayList<>();
        int countNum = getProdDao().searchProductsCount(productBean.getProdName(),productBean.getProdCatg(),productBean.getIsRelease(),
                productBean.getShowHomePage(),productBean.getStartTime(),productBean.getEndTime());
        if(countNum>0){
            Integer offset = null, limit = null;
            offset = (productBean.getPageNo()-1) * productBean.getPageSize();
            limit = productBean.getPageNo();

            tempList = getProdDao().searchProducts(productBean.getProdName(),productBean.getProdCatg(),productBean.getIsRelease(),
                    productBean.getShowHomePage(),limit,offset,productBean.getStartTime(),productBean.getEndTime());

            resultData = new PageResponseBean(productBean.getPageNo(),productBean.getPageSize(),countNum,tempList);
        }else {
            resultData = new PageResponseBean(1, 15, 0, tempList);
        }

        return resultData;
    }

    @Override
    public Product getProdDetail(int id) throws Exception {
        return getProdDao().selectProdById(id);
    }

    @Override
    public boolean save(Product product) throws Exception {
        int resultNum = 0;
        if(product.getId()!=0){
            resultNum = getProdDao().insertProd(product);
        }else{
            resultNum = getProdDao().updateProd(product);
        }
        return resultNum>0;
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        return getProdDao().batchDeleteProd(ids)>0;
    }


    /**
     *  ProductDao
     * @return
     */
    public ProductDao getProdDao() {
        return getBaseDao().getMapper(ProductDao.class);
    }
}
