/*
 * Copyright 2013-2015 www.snakerflow.com. * * Licensed under the Apache License, Version 2.0 (the "License"); * you may not use this file except in compliance with the License. * You may obtain a copy of the License at * * http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License.
 */
package com.qcloud.component.snaker.access.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snaker.engine.DBAccess;
import org.snaker.engine.SnakerException;
import org.snaker.engine.access.AbstractDBAccess;
import org.snaker.engine.access.dialect.Dialect;
import org.snaker.engine.access.dialect.MySqlDialect;
import org.snaker.engine.access.jdbc.BeanPropertyHandler;
import org.snaker.engine.access.jdbc.JdbcAccess;
import org.snaker.engine.access.jdbc.JdbcHelper;
import org.snaker.engine.entity.Process;
import org.snaker.engine.helper.ClassHelper;
import com.qcloud.component.snaker.dao.SnakerConnectionDao;
import com.qcloud.pirates.core.context.PiratesBeanFactoryAware;

/**
 * mybatis方式的数据库访问
 * @author yuqs
 * @since 1.0
 */
public class MybatisAccess extends AbstractDBAccess implements DBAccess {

    private static final Logger log                 = LoggerFactory.getLogger(JdbcAccess.class);

    /**
     * dbutils的QueryRunner对象
     */
    private QueryRunner         runner              = new QueryRunner(true);

    SnakerConnectionDao         snakerConnectionDao = (SnakerConnectionDao) PiratesBeanFactoryAware.getBeanFactory().getBean(SnakerConnectionDao.class);

    /**
     * 使用原生JDBC操作BLOB字段
     */
    public void saveProcess(Process process) {

        super.saveProcess(process);
        SqlSession sqlSession = getSession();
        if (process.getBytes() != null) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = sqlSession.getConnection();
                pstmt = conn.prepareStatement(PROCESS_UPDATE_BLOB);
                pstmt.setBytes(1, process.getBytes());
                pstmt.setString(2, process.getId());
                pstmt.execute();
            } catch (Exception e) {
                throw new SnakerException(e.getMessage(), e.getCause());
            } finally {
                try {
                    JdbcHelper.close(pstmt);
                    SqlSessionUtils.closeSqlSession(sqlSession, getSqlSessionFactory());
                } catch (SQLException e) {
                    throw new SnakerException(e.getMessage(), e.getCause());
                }
            }
        }
    }

    /**
     * 使用原生JDBC操作BLOB字段
     */
    public void updateProcess(Process process) {

        super.updateProcess(process);
        SqlSession sqlSession = getSession();
        if (process.getBytes() != null) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = sqlSession.getConnection();
                pstmt = conn.prepareStatement(PROCESS_UPDATE_BLOB);
                pstmt.setBytes(1, process.getBytes());
                pstmt.setString(2, process.getId());
                pstmt.execute();
            } catch (Exception e) {
                throw new SnakerException(e.getMessage(), e.getCause());
            } finally {
                try {
                    JdbcHelper.close(pstmt);
                    SqlSessionUtils.closeSqlSession(sqlSession, getSqlSessionFactory());
                } catch (SQLException e) {
                    throw new SnakerException(e.getMessage(), e.getCause());
                }
            }
        }
    }

    /**
     * 查询指定列
     * @param column 结果集的列索引号
     * @param sql sql语句
     * @param params 查询参数
     * @return 指定列的结果对象
     */
    public Object query(int column, String sql, Object... params) {

        SqlSession sqlSession = getSession();
        Object result;
        try {
            if (log.isDebugEnabled()) {
                log.debug("查询单列数据=\n" + sql);
            }
            result = runner.query(sqlSession.getConnection(), sql, new ScalarHandler(column), params);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            SqlSessionUtils.closeSqlSession(sqlSession, getSqlSessionFactory());
        }
        return result;
    }

    public Integer getLatestProcessVersion(String name) {

        String where = " where name = ?";
        Object result = query(1, QUERY_VERSION + where, name);
        return new Long(ClassHelper.castLong(result)).intValue();
    }

    public boolean isORM() {

        return false;
    }

    public void saveOrUpdate(Map<String, Object> map) {

        SqlSession sqlSession = getSession();
        String sql = (String) map.get(KEY_SQL);
        Object[] args = (Object[]) map.get(KEY_ARGS);
        try {
            if (log.isDebugEnabled()) {
                log.debug("增删改数据(需手动提交事务)=\n" + sql);
            }
            runner.update(sqlSession.getConnection(), sql, args);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            SqlSessionUtils.closeSqlSession(sqlSession, getSqlSessionFactory());
        }
    }

    public <T> T queryObject(Class<T> clazz, String sql, Object... args) {

        SqlSession sqlSession = getSession();
        List<T> result = null;
        try {
            if (log.isDebugEnabled()) {
                log.debug("查询单条记录=\n" + sql);
            }
            result = runner.query(sqlSession.getConnection(), sql, new BeanPropertyHandler<T>(clazz), args);
            return JdbcHelper.requiredSingleResult(result);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new SnakerException(e.getMessage(), e.getCause());
        } finally {
            SqlSessionUtils.closeSqlSession(sqlSession, getSqlSessionFactory());
        }
    }

    public <T> List<T> queryList(Class<T> clazz, String sql, Object... args) {

        SqlSession sqlSession = getSession();
        try {
            if (log.isDebugEnabled()) {
                log.debug("查询多条记录=\n" + sql);
            }
            return runner.query(sqlSession.getConnection(), sql, new BeanPropertyHandler<T>(clazz), args);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new SnakerException(e.getMessage(), e.getCause());
        } finally {
            SqlSessionUtils.closeSqlSession(sqlSession, getSqlSessionFactory());
        }
    }

    public Object queryCount(String sql, Object... args) {

        return query(1, sql, args);
    }

    public void initialize(Object accessObject) {

    }

    private SqlSession getSession() {

        return snakerConnectionDao.getSession();
    }

    private SqlSessionFactory getSqlSessionFactory() {

        return snakerConnectionDao.getSqlSessionFactory();
    }

    @Override
    protected Dialect getDialect() {

        return new MySqlDialect();
    }

    protected Connection getConnection() throws SQLException {

        throw new SnakerException("mybatis 不提供获取数据库连接实现.");
    }
}
