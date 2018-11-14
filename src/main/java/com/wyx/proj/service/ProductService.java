package com.wyx.proj.service;

import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.entity.Picture;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService extends BaseService<Product> {

    PageResponseBean<Product> queryByCondition(ProductBean productBean) throws Exception;

    public Product getProdDetail(int id) throws  Exception;

    public boolean save(Product product) throws Exception;

    public boolean deleteById(int id) throws Exception;

}
