package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.ProcessProgressQuery;

public interface ProcessProgressService {

    public boolean add(ProcessProgress processProgress);

    public ProcessProgress get(Long id);

    public boolean delete(Long id);

    public boolean update(ProcessProgress processProgress);

    public Page<ProcessProgress> page(ProcessProgressQuery query, int start, int count);

    public List<ProcessProgress> listAll();

    public List<ProcessProgress> listByCarOwnerId(Long carOwnerId, int start, int count);

    public List<ProcessProgress> listByCarOwnerId(Long carOwnerId);

    public ProcessProgress getMaxByFormInstCode(String formInstCode);

    public ProcessProgress get(Long carOwnerId, Long formInstanceId, ProgressType progressType);

    public List<ProcessProgress> listByQuery(ProcessProgressQuery query);

    public ProcessProgress getByFormInstanceId(Long formInstanceId);

    /**
     * 用户流程状态，不包含站内信和邮箱推送
     */
    public boolean changeState(Long formInstanceId, int applyType, int progressState);

    /**
     * 用户流程状态，包含站内信和邮箱状态
     */
    public boolean changeState(Long formInstanceId, int applyType, int progressState, Long creator, MessageEntity messageEntity);

    public ProcessProgress get(Long carOwnerId, Long formInstanceId);

    public ProcessProgress get(long carOwnerId, String formInstCode);
}
