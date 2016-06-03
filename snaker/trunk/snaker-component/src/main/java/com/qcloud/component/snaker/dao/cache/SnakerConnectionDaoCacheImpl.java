package com.qcloud.component.snaker.dao.cache;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.qcloud.component.snaker.dao.SnakerConnectionDao;

@Repository
public class SnakerConnectionDaoCacheImpl implements SnakerConnectionDao {

    @Resource
    private SnakerConnectionDao snakerConnectionDaoMysqlImpl;

    @Override
    public SqlSession getSession() {

        return snakerConnectionDaoMysqlImpl.getSession();
    }

    @Override
    public SqlSessionFactory getSqlSessionFactory() {

        return snakerConnectionDaoMysqlImpl.getSqlSessionFactory();
    }
}
