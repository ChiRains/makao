package com.qcloud.component.permission.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.permission.dao.AccountRoleDao;
import com.qcloud.component.permission.model.AccountRole;

@Repository
public class AccountRoleDaoMysqlImpl implements AccountRoleDao {

    @Resource(name = "sqlOperator-permission")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(AccountRole accountRole) {

        return sqlOperator.insert("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.insert", accountRole) == 1;
    }

    @Override
    public AccountRole get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.delete", id) > 0;
    }

    @Override
    public boolean update(AccountRole accountRole) {

        return sqlOperator.update("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.update", accountRole) > 0;
    }

    @Override
    public List<AccountRole> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, AccountRole> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<AccountRole> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<AccountRole> list = sqlOperator.selectList("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.count4page", param);
        Page<AccountRole> page = new Page<AccountRole>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<AccountRole> list(Long accountId) {

        List<AccountRole> list = sqlOperator.selectList("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.listByAccount", accountId);
        return list;
    }

    @Override
    public AccountRole get(Long accountId, Long roleId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("accountId", accountId);
        param.put("roleId", roleId);
        return sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.getByAccountAndRole", param);
    }

    @Override
    public boolean unbindAccountGrant(long accountId) {

        return sqlOperator.delete("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.unbindAccountGrant", accountId) > 0;
    }

    @Override
    public List<AccountRole> listByRoleId(Long roleId) {

        return sqlOperator.selectList("com.qcloud.component.permission.dao.mysql.mapper.AccountRoleMapper.listByRoleId", roleId);
    }
}
