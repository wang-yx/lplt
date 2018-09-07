package com.wyx.proj.service.impl;

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

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<User> implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Override
    public List<Product> selectAllPics() throws Exception {


        Product product = new Product();
        product.setProdName("prodName");
        product.setProdCatg(1);
        product.setProdImgskey("123456");
        product.setProdImgmkey("123456");
        product.setProdImglkey("123456");
        product.setProdIntroduce("ProdIntroduce");
        product.setProdDetail("ProdDetail");
        product.setProdComment("Comment");
        product.setIsRelease(0);
        product.setShowHomepage(0);

        int ii = getProdDao().insertProd(product);

        System.out.println("--------"+ii);


        List<Product> products =  getProdDao().searchProducts("Name",null,null,null,null);

        System.out.println("--------"+products.get(0).toString());

        List<Integer> aaa = new ArrayList<Integer>();
        aaa.add(1);

        int bbb = getProdDao().batchDeleteProd(aaa);

        System.out.println("--------"+bbb);

        return null;
    }



    /**
     *  ProductDao
     * @return
     */
    public ProductDao getProdDao() {
        return getBaseDao().getMapper(ProductDao.class);
    }
}
