package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicdata.dao.OptionsDao;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.query.OptionsQuery;

@Repository
public class OptionsDaoRedisImpl implements OptionsDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(Options options) {			
		throw new NotImplementedException();
	}

	@Override
	public Options get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Options options){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Options> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Options> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Options> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Options> page(OptionsQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Options> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public List<Options> listByQuestionnaire(long questionnaireId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Options> listByQuestion(long questionId) {
        throw new NotImplementedException();
    }
}

