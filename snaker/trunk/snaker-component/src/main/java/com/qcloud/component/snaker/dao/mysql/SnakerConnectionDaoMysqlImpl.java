package com.qcloud.component.snaker.dao.mysql;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.qcloud.component.snaker.dao.SnakerConnectionDao;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;

@Repository
public class SnakerConnectionDaoMysqlImpl implements SnakerConnectionDao {

    @Resource(name = "sqlOperator-snaker")
    private SqlOperator sqlOperator;

    public SqlSession getSession() {

        return sqlOperator.getSession();
    }

    @Override
    public SqlSessionFactory getSqlSessionFactory() {

        return sqlOperator.getSqlSessionFactory();
    }
}
