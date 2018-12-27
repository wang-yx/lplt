package com.wyx.proj.controller;

import com.wyx.proj.bean.ProdCategoryBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.entity.Prodcategory;
import com.wyx.proj.service.ProductCategoryService;
import com.wyx.proj.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping(value="/productCategory")
public class ProductCategoryController {

    private Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

    @Resource
    private ProductCategoryService productCategoryService;

    @PostMapping("save")
    public Object save(@RequestBody Prodcategory request){
        try {
            productCategoryService.save(request);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("保存成功！","保存成功！");
    }

    @PostMapping("specialList")
    public Object specialList(){
        List<Prodcategory> result = null;

        try {
            result = productCategoryService.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),result);
        }
        return ResponseUtil.ok(result);
    }

    @PostMapping("list")
    public Object list(){
        List<Prodcategory> result = null;

        try {
            result = productCategoryService.selectAll2();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),result);
        }
        return ResponseUtil.ok(result);
    }

    @PostMapping("filterList")
    public Object filterList(@RequestBody ProdCategoryBean prodCategoryBean){
        List<Prodcategory> result = null;

        try {
            result = productCategoryService.selectSome(prodCategoryBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),result);
        }
        return ResponseUtil.ok(result);
    }


    @PostMapping("detail")
    public Object detail(@FormParam("id") int id){
        Prodcategory prodcategory = null;
        try {
            prodcategory = productCategoryService.getProdDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),prodcategory);
        }
        return ResponseUtil.ok(prodcategory);
    }

    @GetMapping("detail")
    public Object detailGet(@QueryParam("id") int id){
        Prodcategory prodcategory = null;
        try {
            prodcategory = productCategoryService.getProdDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),prodcategory);
        }
        return ResponseUtil.ok(prodcategory);
    }

    @GetMapping("delete")
    public Object deleteProductCategoryGet(@QueryParam("id") int id){
        try {
            productCategoryService.deleteProdcategoryByid(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.err(e.getMessage(),"");
        }
        return ResponseUtil.ok("删除成功！");
    }



}
