package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.MessageType;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;

public interface InstanceMessageService {

    public boolean add(InstanceMessage instanceMessage);

    public InstanceMessage get(Long id);

    public boolean delete(Long id);

    public boolean update(InstanceMessage instanceMessage);

    public List<InstanceMessage> listByFormInstanceId(Long formInstanceId);

    public List<InstanceMessage> listByMessageCerkId(Long messageCerkId);

    public Page<InstanceMessage> page(InstanceMessageQuery query, int start, int count);

    public List<InstanceMessage> listAll();

    public String getMessageContent(Long formInstanceId, MessageType messageType);
}
