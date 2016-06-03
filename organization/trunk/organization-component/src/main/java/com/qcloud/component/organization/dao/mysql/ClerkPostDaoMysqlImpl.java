package com.qcloud.component.organization.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.organization.dao.ClerkPostDao;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.query.ClerkPostQuery;

@Repository
public class ClerkPostDaoMysqlImpl implements ClerkPostDao {

    @Resource(name = "sqlOperator-organization")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ClerkPost clerkPost) {

        return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.insert", clerkPost) == 1;
    }

    @Override
    public ClerkPost get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ClerkPost clerkPost) {

        return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.update", clerkPost) > 0;
    }

    @Override
    public List<ClerkPost> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ClerkPost> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ClerkPost> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ClerkPost> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.count4page", param);
        Page<ClerkPost> page = new Page<ClerkPost>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ClerkPost> page(ClerkPostQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("postId", query.getPostId());
        List<ClerkPost> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.count4query", param);
        Page<ClerkPost> page = new Page<ClerkPost>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ClerkPost> listAll() {

        List<ClerkPost> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.listAll");
        return list;
    }

    @Override
    public List<ClerkPost> listByClerk(long clerkId) {

        List<ClerkPost> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.listByClerk", clerkId);
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.deleteByMap", map) > 0;
    }

    @Override
    public List<ClerkPost> listByPost(Long postId) {
        List<ClerkPost> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.ClerkPostMapper.listByPost", postId);
        return list;
    }
}
