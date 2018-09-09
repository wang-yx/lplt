package com.wyx.proj.service.impl;

import com.wyx.proj.dao.BaseDao;
import com.wyx.proj.dao.UserDao;
import com.wyx.proj.entity.BaseEntity;
import com.wyx.proj.service.BaseService;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Resource(name = "baseDao")
    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }
}
