package com.wyx.proj.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("baseDao")
public class BaseDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    public SqlSession getSqlSession(){

        if(sqlSession == null){

            synchronized (BaseDao.class){
                //sqlSessionFactory.getConfiguration().addMappers("com.wyx.proj.dao");
                this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
            }
        }

        return this.sqlSession;
    }

    public <T> T getMapper1(Class<T> cls){
        return getSqlSession().getMapper(cls);
    }


}



