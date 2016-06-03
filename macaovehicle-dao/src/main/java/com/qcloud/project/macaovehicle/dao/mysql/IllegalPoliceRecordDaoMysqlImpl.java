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
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.IllegalPoliceRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;

@Repository
public class IllegalPoliceRecordDaoMysqlImpl implements IllegalPoliceRecordDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(IllegalPoliceRecord illegalPoliceRecord) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.insert", illegalPoliceRecord) == 1;
    }

    @Override
    public IllegalPoliceRecord get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.delete", id) > 0;
    }

    @Override
    public boolean update(IllegalPoliceRecord illegalPoliceRecord) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.update", illegalPoliceRecord) > 0;
    }

    @Override
    public List<IllegalPoliceRecord> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, IllegalPoliceRecord> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<IllegalPoliceRecord> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<IllegalPoliceRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.count4page", param);
        Page<IllegalPoliceRecord> page = new Page<IllegalPoliceRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<IllegalPoliceRecord> page(IllegalPoliceRecordQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("carOwnerId", query.getCarOwnerId());
        param.put("plateNumber", StringUtil.nullToEmpty(query.getPlateNumber()));
        param.put("tplateNumber", StringUtil.nullToEmpty(query.getTplateNumber()));
        param.put("departmentId", query.getDepartmentId());
        param.put("applyTimeFront", query.getApplyTimeFront());
        param.put("applyTimeBack", query.getApplyTimeBack() != null ? DateUtil.addDate(query.getApplyTimeBack(), 1) : null);
        List<IllegalPoliceRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.count4query", param);
        Page<IllegalPoliceRecord> page = new Page<IllegalPoliceRecord>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<IllegalPoliceRecord> listAll() {

        List<IllegalPoliceRecord> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.IllegalPoliceRecordMapper.listAll");
        return list;
    }
}
