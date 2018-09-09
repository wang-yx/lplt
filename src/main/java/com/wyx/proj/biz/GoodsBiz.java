package com.wyx.proj.biz;

import com.wyx.proj.request.ProductDetailRequest;
import com.wyx.proj.request.ProductListRequest;
import com.wyx.proj.response.ProductDetailResponse;
import com.wyx.proj.response.ProductListResponse;
import com.wyx.proj.response.PageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class GoodsBiz {

    public ProductDetailResponse detail(@RequestBody ProductDetailRequest request){

        return null;
    }

    public PageResponse<ProductListResponse> listQuery(@RequestBody ProductListRequest request){
        return null;
    }
}
