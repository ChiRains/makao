package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.ProcessProgressQuery;

public interface ProcessProgressDao extends ISimpleDao<ProcessProgress, Long> {

    public boolean add(ProcessProgress processProgress);

    public ProcessProgress get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessProgress processProgress);

    public List<ProcessProgress> list(List<Long> idList);

    public Map<Long, ProcessProgress> map(Set<Long> idSet);

    public Page<ProcessProgress> page(ProcessProgressQuery query, int start, int size);

    public List<ProcessProgress> listAll();

    List<ProcessProgress> listByCarOwnerId(Long carOwnerId, int start, int count);

    List<ProcessProgress> listByCarOwnerId(Long carOwnerId);

    public ProcessProgress getMaxByFormInstCode(String formInstCode);

    public ProcessProgress get(Long carOwnerId, Long formInstanceId, ProgressType progressType);

    public List<ProcessProgress> listByQuery(ProcessProgressQuery query);

    public ProcessProgress getByFormInstanceId(Long formInstanceId);

    public ProcessProgress get(Long carOwnerId, Long formInstanceId);

    public ProcessProgress get(Long carOwnerId, String formInstCode);
}
