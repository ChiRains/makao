package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.IllegalOwnerRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;

@Repository
public class IllegalOwnerRecordDaoMysqlImpl implements IllegalOwnerRecordDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(IllegalOwnerRecord illegalOwnerRecord) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.insert", illegalOwnerRecord) == 1;
    }

    @Override
    public IllegalOwnerRecord get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.delete", id) > 0;
    }

    @Override
    public boolean update(IllegalOwnerRecord illegalOwnerRecord) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.update", illegalOwnerRecord) > 0;
    }

    @Override
    public List<IllegalOwnerRecord> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, IllegalOwnerRecord> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<IllegalOwnerRecord> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<IllegalOwnerRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.count4page", param);
        Page<IllegalOwnerRecord> page = new Page<IllegalOwnerRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<IllegalOwnerRecord> page(IllegalOwnerRecordQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("certificatesNo", StringUtil.emptyToNull(query.getCertificatesNo()));
        param.put("departmentId", query.getDepartmentId());
        param.put("name", StringUtil.emptyToNull(query.getName()));
        List<IllegalOwnerRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.count4query", param);
        Page<IllegalOwnerRecord> page = new Page<IllegalOwnerRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<IllegalOwnerRecord> listAll() {

        List<IllegalOwnerRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalOwnerRecordMapper.listAll");
        return list;
    }
}
