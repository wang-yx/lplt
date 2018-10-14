package com.wyx.proj.service;

import com.wyx.proj.entity.Picture;
import com.wyx.proj.entity.Product;
import com.wyx.proj.entity.User;

import java.util.List;

public interface ProductService extends BaseService<User> {

    /**
     * 获取所有图片信息
     * @return
     * @throws Exception
     */
    public List<Product> selectAllPics() throws Exception;

    List<Product> queryByCondition(Integer isRelease, Integer showHomepage, Integer pageNo, Integer pageSize);

}
