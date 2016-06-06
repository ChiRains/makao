package com.qcloud.component.snakerext.service;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
public interface ProcessFormService {
    public boolean add(ProcessForm processForm);

    public ProcessForm get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessForm processForm);

    public Page<ProcessForm> page(ProcessFormQuery query, int start, int count);

    public List<ProcessForm> listAll();

    public List<ProcessForm> list(Map<String, Object> map);
}
