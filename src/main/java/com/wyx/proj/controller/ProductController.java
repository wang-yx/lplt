package com.wyx.proj.controller;


import com.wyx.proj.biz.ProductBiz;
import com.wyx.proj.entity.User;
import com.wyx.proj.request.HomeProductRequest;
import com.wyx.proj.request.ProductDetailRequest;
import com.wyx.proj.request.ProductListRequest;
import com.wyx.proj.request.ProductSaveRequest;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.response.ProductDetailResponse;
import com.wyx.proj.response.ProductListResponse;
import com.wyx.proj.service.ProductService;
import com.wyx.proj.service.UserService;
import com.wyx.proj.util.Response;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value="/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;
    @Resource
    private ProductBiz productBiz;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object getAllUsers(){

        List<User> users = null;
        try {
            productService.selectAllPics();
        } catch (Exception e) {
            return ResponseUtil.err(e.getMessage(),null);
        }
        return ResponseUtil.ok(users);
    }

    @PostMapping("save")
    public Response<String> save(@RequestBody ProductSaveRequest request){
        return Response.success(productBiz.save(request));
    }

    @PostMapping("list")
    public Response<PageResponse<ProductListResponse>> list(@RequestBody ProductListRequest request){
        return Response.success(productBiz.list(request));
    }

    @PostMapping("detail")
    public Response<ProductDetailResponse> detail(@RequestBody ProductDetailRequest request){
        return Response.success(productBiz.detail(request));
    }

    @PostMapping("list/homePage")
    public Response<List<ProductListResponse>> listHomePage(@RequestBody HomeProductRequest request){
        return Response.success(productBiz.listHomePage(request));
    }

}
