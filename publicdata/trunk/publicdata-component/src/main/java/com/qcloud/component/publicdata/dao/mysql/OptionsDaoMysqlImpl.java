package com.qcloud.component.publicdata.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicdata.dao.OptionsDao;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.query.OptionsQuery;

@Repository
public class OptionsDaoMysqlImpl implements OptionsDao {

    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Options options) {

        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.insert", options) == 1;
    }

    @Override
    public Options get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Options options) {

        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.update", options) > 0;
    }

    @Override
    public List<Options> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Options> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Options> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Options> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.count4page", param);
        Page<Options> page = new Page<Options>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Options> page(OptionsQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("questionnaireId", query.getQuestionnaireId());
        param.put("questionId", query.getQuestionId());
        List<Options> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.count4query", param);
        Page<Options> page = new Page<Options>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Options> listAll() {

        List<Options> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.listAll");
        return list;
    }

    @Override
    public List<Options> listByQuestionnaire(long questionnaireId) {

        List<Options> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.listByQuestionnaire", questionnaireId);
        return list;
    }

    @Override
    public List<Options> listByQuestion(long questionId) {

        List<Options> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.OptionsMapper.listByQuestion", questionId);
        return list;
    }
}
