package com.wyx.proj.controller;

import com.wyx.proj.biz.GoodsBiz;
import com.wyx.proj.request.GoodsDetailRequest;
import com.wyx.proj.request.GoodsListQueryRequest;
import com.wyx.proj.response.GoodsDetailResponse;
import com.wyx.proj.response.GoodsListQueryResponse;
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
    public Response<GoodsDetailResponse> detail(@RequestBody GoodsDetailRequest request){
        return Response.success(goodsBiz.detail(request));
    }

    @RequestMapping(value = "list/query", method = RequestMethod.POST)
    public Response<PageResponse<GoodsListQueryResponse>> listQuery(@RequestBody GoodsListQueryRequest request){
        return Response.success(goodsBiz.listQuery(request));
    }
}
