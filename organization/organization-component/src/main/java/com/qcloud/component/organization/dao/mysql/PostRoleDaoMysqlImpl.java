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
import com.qcloud.component.organization.dao.PostRoleDao;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.model.query.PostRoleQuery;

@Repository
public class PostRoleDaoMysqlImpl implements PostRoleDao {

    @Resource(name = "sqlOperator-organization")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(PostRole postRole) {

        return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.insert", postRole) == 1;
    }

    @Override
    public PostRole get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.delete", id) > 0;
    }

    @Override
    public boolean update(PostRole postRole) {

        return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.update", postRole) > 0;
    }

    @Override
    public List<PostRole> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, PostRole> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<PostRole> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<PostRole> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.count4page", param);
        Page<PostRole> page = new Page<PostRole>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<PostRole> page(PostRoleQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<PostRole> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.count4query", param);
        Page<PostRole> page = new Page<PostRole>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<PostRole> listAll() {

        List<PostRole> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.listAll");
        return list;
    }

    @Override
    public List<PostRole> listAll(Map<String, Object> map) {

        List<PostRole> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.listAllByMap", map);
        return list;
    }

    @Override
    public List<PostRole> listByPost(long postId) {

        List<PostRole> list = sqlOperator.selectList("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.listByPost", postId);
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.PostRoleMapper.deleteByMap", map) > 0;
    }
}
