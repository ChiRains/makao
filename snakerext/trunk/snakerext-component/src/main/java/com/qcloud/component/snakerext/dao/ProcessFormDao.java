package com.qcloud.component.snakerext.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
public interface ProcessFormDao extends ISimpleDao<ProcessForm, Long> {
    public boolean add(ProcessForm processForm);

    public ProcessForm get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessForm processForm);

    public List<ProcessForm> list(List<Long> idList);

    public Map<Long, ProcessForm> map(Set<Long> idSet);

    public Page<ProcessForm> page(ProcessFormQuery query, int start, int size);

    public List<ProcessForm> listAll();

    public List<ProcessForm> list(Map<String, Object> map);
}
