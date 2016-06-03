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
import com.qcloud.component.publicdata.dao.QuestionnaireDao;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;

@Repository
public class QuestionnaireDaoMysqlImpl implements QuestionnaireDao {

    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Questionnaire questionnaire) {

        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.insert", questionnaire) == 1;
    }

    @Override
    public Questionnaire get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Questionnaire questionnaire) {

        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.update", questionnaire) > 0;
    }

    @Override
    public List<Questionnaire> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Questionnaire> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Questionnaire> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Questionnaire> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.count4page", param);
        Page<Questionnaire> page = new Page<Questionnaire>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Questionnaire> page(QuestionnaireQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Questionnaire> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.count4query", param);
        Page<Questionnaire> page = new Page<Questionnaire>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Questionnaire> listAll() {

        List<Questionnaire> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.listAll");
        return list;
    }

    @Override
    public Questionnaire getByCode(String code) {

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionnaireMapper.getByCode", code);
    }
}
