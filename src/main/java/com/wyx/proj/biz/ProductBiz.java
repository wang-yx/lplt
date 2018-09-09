package com.wyx.proj.biz;

import com.wyx.proj.request.ProductDetailRequest;
import com.wyx.proj.request.ProductListRequest;
import com.wyx.proj.request.ProductSaveRequest;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.response.ProductDetailResponse;
import com.wyx.proj.response.ProductListResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductBiz {

    public String save(ProductSaveRequest request){
        return null;

    }

    public PageResponse<ProductListResponse> list(ProductListRequest request){
        return null;
    }

    public ProductDetailResponse detail(ProductDetailRequest request){
        return null;
    }

    public List<ProductListResponse> listHomePage(){
        return null;
    }
}
