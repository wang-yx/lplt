package com.wyx.proj.service.impl;

import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.dao.PictureDao;
import com.wyx.proj.dao.ProdCategoryDao;
import com.wyx.proj.dao.ProductDao;
import com.wyx.proj.dao.ProductDetailDao;
import com.wyx.proj.entity.*;
import com.wyx.proj.service.PictureService;
import com.wyx.proj.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private PictureService pictureService;

    @Override
    public PageResponseBean<Product> queryByCondition(ProductBean productBean) throws Exception {
        PageResponseBean<Product> resultData = null;
        List<Product> tempList = new ArrayList<>();
        int countNum = getProdDao().searchProductsCount(productBean.getName(), productBean.getType(), productBean.getBrand(),
                productBean.getCategoryid(), productBean.getLanguage(), productBean.getIsrelease(), productBean.getShowhomepage(),
                productBean.getStarttime(), productBean.getEndtime());
        if (countNum > 0) {
            Integer offset = null, limit = null;
            offset = (productBean.getPageNo() - 1) * productBean.getPageSize();
            limit = productBean.getPageSize();

            tempList = getProdDao().searchProducts(productBean.getName(), productBean.getType(), productBean.getBrand(),
                    productBean.getCategoryid(), productBean.getLanguage(), productBean.getIsrelease(), productBean.getShowhomepage(),
                    limit, offset, productBean.getStarttime(), productBean.getEndtime());

            if (tempList != null && tempList.size() > 0) {
                List<Prodcategory> allProdcategory = getProdCategoryDao().selectAllProdcategoris();
                HashMap<Integer, String> tempMap = new HashMap<>();
                for (Prodcategory pc : allProdcategory) {
                    if (productBean.getLanguage() == 0) {
                        tempMap.put(pc.getId(), pc.getName());
                    } else {
                        tempMap.put(pc.getId(), pc.getNameen());
                    }
                }
                //赋值categoryname
                for (Product prod : tempList) {
                    prod.setCategoryname(tempMap.get(prod.getCategoryid()));
                }
            }
            resultData = new PageResponseBean(productBean.getPageNo(), productBean.getPageSize(), countNum, tempList);
        } else {
            resultData = new PageResponseBean(1, 15, 0, tempList);
        }

        return resultData;
    }

    @Override
    public Product getProdDetail(int id) throws Exception {
        Product product = getProdDao().selectProdById(id);
        if (product != null) {
            product.setDetail_ch(getProdDetailDao().selectProdDetailById(product.getChineseid()));
            product.setDetail_en(getProdDetailDao().selectProdDetailById(product.getEnglishid()));
        }
        return product;
    }

    @Override
    public boolean save(Product product) throws Exception {

        if (product.getOrdernum() != null && getProdDao().countByIdOrOrdernum(product) > 0) {
            //进来的话，就表示有相同排序数字，重新需要调整排序
            List<Product> products = getProdDao().selectOthersByIdOrOrdernum(product);
            for (Product pp : products) {
                pp.setOrdernum(pp.getOrdernum() + 1);
            }
            getProdDao().updateOthersByIdOrOrdernum(products);
        } else {
            //目前的总数
            int countNum = getProdDao().selectAllCount();
            product.setOrdernum(countNum + 1);
        }

        int resultNum = 0;
        if (product.getId() ==null || product.getId() == 0) {
            ProductDetail productDetail_ch = product.getDetail_ch();
            getProdDetailDao().insertProdDetail(productDetail_ch);
            product.setChineseid(productDetail_ch.getId());

            ProductDetail productDetail_en = product.getDetail_en();
            getProdDetailDao().insertProdDetail(productDetail_en);
            product.setEnglishid(productDetail_en.getId());

            resultNum = getProdDao().insertProd(product);
        } else {
            Product tempProduce = getProdDao().selectProdById(product.getId());

            ProductDetail productDetail_ch = product.getDetail_ch();
            productDetail_ch.setId(tempProduce.getChineseid());

            ProductDetail productDetail_en = product.getDetail_en();
            productDetail_en.setId(tempProduce.getEnglishid());

            getProdDetailDao().updateProdDetail(productDetail_ch);
            getProdDetailDao().updateProdDetail(productDetail_en);
            resultNum = getProdDao().updateProd(product);
        }
        return resultNum > 0;
    }


    public void updateOrder(Product product) throws Exception {
        if (product.getOrdernum() != null && getProdDao().countByIdOrOrdernum(product) > 0) {
            //进来的话，就表示有相同排序数字，重新需要调整排序
            List<Product> products = getProdDao().selectOthersByIdOrOrdernum(product);
            for (Product pp : products) {
                pp.setOrdernum(pp.getOrdernum() + 1);
            }
            System.out.println("---size-->" + products.size());
            getProdDao().updateOthersByIdOrOrdernum(products);
        }
        getProdDao().updateByIdOrOrdernum(product);
    }


    @Override
    public boolean deleteById(int id) throws Exception {
        List<Integer> ids = new ArrayList<>();
        Product tempProduce = getProdDao().selectProdById(id);

        ids.add(tempProduce.getChineseid());
        ids.add(tempProduce.getEnglishid());
        getProdDetailDao().batchDeleteProd(ids);

        ids.clear();
        ids.add(id);
        getProdDao().batchDeleteProd(ids);

        pictureService.deleteFile(tempProduce.getImg());

        return true;
    }


    /**
     * ProductDao
     *
     * @return
     */
    public ProductDao getProdDao() {
        return getBaseDao().getMapper(ProductDao.class);
    }

    public ProductDetailDao getProdDetailDao() {
        return getBaseDao().getMapper(ProductDetailDao.class);
    }

    public ProdCategoryDao getProdCategoryDao() {
        return getBaseDao().getMapper(ProdCategoryDao.class);
    }
}
