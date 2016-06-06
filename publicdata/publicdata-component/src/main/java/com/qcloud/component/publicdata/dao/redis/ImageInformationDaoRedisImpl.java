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
import com.qcloud.component.publicdata.dao.ImageInformationDao;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;

@Repository
public class ImageInformationDaoRedisImpl implements ImageInformationDao {

    // @Resource(name = "redis-publicdata")
    // private Redis redis;
    @Override
    public boolean add(ImageInformation imageInformation) {

        throw new NotImplementedException();
    }

    @Override
    public ImageInformation get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ImageInformation imageInformation) {

        throw new NotImplementedException();
    }

    @Override
    public List<ImageInformation> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ImageInformation> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ImageInformation> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ImageInformation> page(ImageInformationQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ImageInformation> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public ImageInformation getByCode(String code) {

        throw new NotImplementedException();
    }
}
