package com.wyx.proj.biz;

import com.wyx.proj.request.GoodsDetailRequest;
import com.wyx.proj.request.GoodsListQueryRequest;
import com.wyx.proj.response.GoodsDetailResponse;
import com.wyx.proj.response.GoodsListQueryResponse;
import com.wyx.proj.response.PageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class GoodsBiz {

    public GoodsDetailResponse detail(@RequestBody GoodsDetailRequest request){

        return null;
    }

    public PageResponse<GoodsListQueryResponse> listQuery(@RequestBody GoodsListQueryRequest request){
        return null;
    }
}
