package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.OptionsDao;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.query.OptionsQuery;

@Repository
public class OptionsDaoCacheImpl implements OptionsDao {
	
	@Autowired
	private OptionsDao optionsDaoMysqlImpl;
	
//	@Autowired
//	private OptionsDao optionsDaoRedisImpl;

	@Override
	public boolean add(Options options) {
		return optionsDaoMysqlImpl.add(options);
	}

	@Override
	public Options get(Long id) {
	    return optionsDaoMysqlImpl.get(id);
//		return CacheLoader.get(optionsDaoRedisImpl, optionsDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return optionsDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Options options){
		return optionsDaoMysqlImpl.update(options);
	}
	
	@Override
	public List<Options> list(List<Long> idList) {
		return CacheLoader.list(optionsDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Options> map(Set<Long> idSet){
		return CacheLoader.map(optionsDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Options> page(int start, int count){
		return optionsDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Options> page(OptionsQuery query, int start, int count){
		return optionsDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Options> listAll(){
		return optionsDaoMysqlImpl.listAll();
	}

    @Override
    public List<Options> listByQuestionnaire(long questionnaireId) {
        return optionsDaoMysqlImpl.listByQuestionnaire(questionnaireId);
    }

    @Override
    public List<Options> listByQuestion(long questionId) {
        return optionsDaoMysqlImpl.listByQuestion(questionId);
    }
}

