package com.wyx.proj.service.impl;

import com.wyx.proj.bean.PageResponseBean;
import com.wyx.proj.bean.ProdCategoryBean;
import com.wyx.proj.bean.ProductBean;
import com.wyx.proj.dao.ProdCategoryDao;
import com.wyx.proj.dao.ProductDao;
import com.wyx.proj.entity.Prodcategory;
import com.wyx.proj.entity.Product;
import com.wyx.proj.service.ProductCategoryService;
import com.wyx.proj.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productCategoryService")
public class ProductCategoryServiceImpl extends BaseServiceImpl<Prodcategory> implements ProductCategoryService {

    private final Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

    @Override
    public List<Prodcategory> selectAll() throws Exception {
        List<Prodcategory> alls = getProdCategoryDao().selectAllProdcategoris();

        Map<Integer, List<Prodcategory>> typeMap = new HashMap<>();

        for (Prodcategory aa : alls) {
            if (typeMap.containsKey(aa.getType())) {
                List<Prodcategory> temp = typeMap.get(aa.getType());
                temp.add(aa);
                typeMap.put(aa.getType(), temp);
            } else {
                List<Prodcategory> temp = new ArrayList<>();
                temp.add(aa);
                typeMap.put(aa.getType(), temp);
            }
        }
        for (int i = 5; i > 1; i--) {
            if (typeMap.get(i) != null) {
                List<Prodcategory> tempParent = typeMap.get(i - 1);
                List<Prodcategory> temp = typeMap.get(i);
                for (Prodcategory pp : tempParent) {
                    for (Prodcategory tt : temp) {
                        if (pp.getId() == tt.getParent()) {
                            List<Prodcategory> tempChildren = pp.getChildren() != null ? pp.getChildren() : new ArrayList<>();
                            tempChildren.add(tt);
                            pp.setChildren(tempChildren);
                        }
                    }
                }
            }
        }
        return typeMap.get(1);
    }

    @Override
    public List<Prodcategory> selectAll2() throws Exception {
        return getProdCategoryDao().selectAllProdcategoris2();
    }


    @Override
    public Prodcategory getProdDetail(int id) throws Exception {
        return getProdCategoryDao().selectProdcategoryById(id);
    }

    @Override
    public boolean save(Prodcategory prodcategory) throws Exception {
        int resultNum = 0;
        if (prodcategory.getId() != 0) {
            resultNum = getProdCategoryDao().updateProdcategory(prodcategory);
        } else {
            resultNum = getProdCategoryDao().insertProdcategory(prodcategory);
        }
        return resultNum > 0;
    }

    @Override
    public boolean deleteProdcategoryByid(int id) throws Exception {
        List<Integer> ids = new ArrayList<>();
        ProdCategoryBean prodCategoryBean = new ProdCategoryBean();
        prodCategoryBean.setParent(id);
        List<Prodcategory> prodcategorys = getProdCategoryDao().selectSome(prodCategoryBean);
        for (Prodcategory pp : prodcategorys) {
            ids.add(pp.getId());
        }
        ids.add(id);
        return getProdCategoryDao().batchDeleteProdcategory(ids) > 0;
    }

    @Override
    public List<Prodcategory> selectSome(ProdCategoryBean prodCategoryBean) throws Exception {
        return getProdCategoryDao().selectSome(prodCategoryBean);
    }

    /**
     * ProdCategoryDao
     *
     * @return
     */
    public ProdCategoryDao getProdCategoryDao() {
        return getBaseDao().getMapper(ProdCategoryDao.class);
    }
}
