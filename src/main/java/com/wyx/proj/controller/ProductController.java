package com.wyx.proj.controller;


import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.biz.ProductBiz;
import com.wyx.proj.entity.News;
import com.wyx.proj.entity.Product;
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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value="/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    @PostMapping("save")
    public Object save(@RequestBody Product request){
        try {
            productService.save(request);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("保存成功！","保存成功！");
    }

    @PostMapping("list")
    public Object list(@RequestBody ProductBean request){
        PageResponseBean<Product> result = null;

        try {
            result = productService.queryByCondition(request);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),result);
        }
        return ResponseUtil.ok(result);
    }

    @PostMapping("detail")
    public Object detail(@FormParam("id") int id){
        Product product = null;
        try {
            product = productService.getProdDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),product);
        }
        return ResponseUtil.ok(product);
    }

    //最对只返回15条，一页的数据
    @PostMapping("list/homePage")
    public Object listHomePage(){
        PageResponseBean<Product> result = null;
        ProductBean productBean = new ProductBean();
        productBean.setShowHomePage(1);
        try {
            result = productService.queryByCondition(productBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),result);
        }
        return ResponseUtil.ok(result);
    }

    @PostMapping("delete")
    public Object deleteProdBYId(@FormParam("id") int id){
        try {
            productService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("删除成功！");
    }



//    @Resource
//    private ProductBiz productBiz;
//
//    @RequestMapping(value = "test",method = RequestMethod.GET)
//    public Object getAllUsers(){
//
//        List<User> users = null;
//        try {
//            productService.selectAllPics();
//        } catch (Exception e) {
//            return ResponseUtil.err(e.getMessage(),null);
//        }
//        return ResponseUtil.ok(users);
//    }
//
//    @PostMapping("save")
//    public Response<String> save(@RequestBody ProductSaveRequest request){
//        return Response.success(productBiz.save(request));
//    }
//
//    @PostMapping("list")
//    public Response<PageResponse<ProductListResponse>> list(@RequestBody ProductListRequest request){
//        return Response.success(productBiz.list(request));
//    }
//
//    @PostMapping("detail")
//    public Response<ProductDetailResponse> detail(@RequestBody ProductDetailRequest request){
//        return Response.success(productBiz.detail(request));
//    }
//
//    @PostMapping("list/homePage")
//    public Response<List<ProductListResponse>> listHomePage(@RequestBody HomeProductRequest request){
//        return Response.success(productBiz.listHomePage(request));
//    }

}
