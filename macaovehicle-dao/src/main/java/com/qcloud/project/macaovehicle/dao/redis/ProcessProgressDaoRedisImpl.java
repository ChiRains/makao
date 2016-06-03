package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.ProcessProgressDao;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.ProcessProgressQuery;

@Repository
public class ProcessProgressDaoRedisImpl implements ProcessProgressDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(ProcessProgress processProgress) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessProgress get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ProcessProgress processProgress) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessProgress> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessProgress> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessProgress> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessProgress> page(ProcessProgressQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessProgress> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessProgress> listByCarOwnerId(Long carOwnerId, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessProgress getMaxByFormInstCode(String formInstCode) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId, ProgressType progressType) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProcessProgress> listByQuery(ProcessProgressQuery query) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessProgress getByFormInstanceId(Long formInstanceId) {

        throw new NotImplementedException();
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId) {

        throw new NotImplementedException();
    }
}
