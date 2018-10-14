package com.wyx.proj.adapter;

import com.wyx.proj.entity.Product;
import com.wyx.proj.response.ProductListResponse;

public class ProductAdapter {

    public static ProductListResponse adapterHomeRepsonse(Product product){
        ProductListResponse response = new ProductListResponse();

        response.setProductId(product.getId());
        response.setProductName(product.getProdName());
        response.setProductPic(product.getProdImglkey());
        response.setCreateTime(product.getCreateTime());

        return response;
    }
}
