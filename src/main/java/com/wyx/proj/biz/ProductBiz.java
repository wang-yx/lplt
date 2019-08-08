package com.wyx.proj.biz;

import com.google.common.collect.Lists;
import com.wyx.proj.adapter.ProductAdapter;
import com.wyx.proj.common.BizTemplate;
import com.wyx.proj.dao.ProductDao;
import com.wyx.proj.entity.Product;
import com.wyx.proj.request.HomeProductRequest;
import com.wyx.proj.request.ProductDetailRequest;
import com.wyx.proj.request.ProductListRequest;
import com.wyx.proj.request.ProductSaveRequest;
import com.wyx.proj.response.PageResponse;
import com.wyx.proj.response.ProductDetailResponse;
import com.wyx.proj.response.ProductListResponse;
import com.wyx.proj.service.ProductService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductBiz {

    @Resource
    private ProductService productService;

    public String save(ProductSaveRequest request) {
        return null;

    }

    public PageResponse<ProductListResponse> list(ProductListRequest request) {
        return null;
    }

    public ProductDetailResponse detail(ProductDetailRequest request) {
        return null;
    }

    public List<ProductListResponse> listHomePage(HomeProductRequest request) {
        return new BizTemplate<List<ProductListResponse>>() {
            @Override
            public void checkParams() {

            }

            @Override
            public List<ProductListResponse> process() throws Exception {

//                List<Product> productList = productService.queryByCondition(1, 1, null, null);
//
//                if(productList != null){
//                    return productList.stream().map(ProductAdapter::adapterHomeRepsonse).collect(Collectors.toList());
//                }
                return Lists.newArrayList();
            }

        }.execute();
    }
}
