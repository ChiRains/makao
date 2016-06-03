package com.qcloud.component.snaker.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public interface SnakerConnectionDao {

    SqlSession getSession();

    SqlSessionFactory getSqlSessionFactory();
}
