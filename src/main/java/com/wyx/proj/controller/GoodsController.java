package com.wyx.proj.controller;

import com.wyx.proj.biz.GoodsBiz;
import com.wyx.proj.request.ProductDetailRequest;
import com.wyx.proj.request.ProductListRequest;
import com.wyx.proj.response.ProductDetailResponse;
import com.wyx.proj.response.ProductListResponse;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.util.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value="/goods")
public class GoodsController {

    @Resource
    private GoodsBiz goodsBiz;

    @RequestMapping(value = "detail", method = RequestMethod.POST)
    public Response<ProductDetailResponse> detail(@RequestBody ProductDetailRequest request){
        return Response.success(goodsBiz.detail(request));
    }

    @RequestMapping(value = "list/query", method = RequestMethod.POST)
    public Response<PageResponse<ProductListResponse>> listQuery(@RequestBody ProductListRequest request){
        return Response.success(goodsBiz.listQuery(request));
    }

//    //TODO 商品修改 ／ 添加
//    @RequestMapping(value = "list/query", method = RequestMethod.POST)
//    public Response<PageResponse<ProductListResponse>> listQuery(@RequestBody ProductListRequest request){
//        return Response.success(goodsBiz.listQuery(request));
//    }

}
