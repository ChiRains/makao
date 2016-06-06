package com.qcloud.component.publicservice.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.MessageDao;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.model.Message;
import com.qcloud.component.publicservice.model.query.MessageQuery;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.pirates.util.TableSplitUtil;

@Repository
public class MessageDaoMysqlImpl implements MessageDao {

    @Resource(name = "sqlOperator-publicservice")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Message message) {

        throw new NotImplementedException();
        // return sqlOperator.insert("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.insert", message) == 1;
    }

    @Override
    public boolean add(String typeCode, int tableNumber, Message message) {

        Map<String, Object> param = BeanUtils.transBean2Map(message);
        param.put("table_name", getTableName(typeCode, tableNumber, message.getReceiver()));
        return sqlOperator.insert("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.insert", param) == 1;
    }

    @Override
    public Message get(Long id) {

        throw new NotImplementedException();
        // return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.get", id);
    }

    @Override
    public Message get(String typeCode, int tableNumber, long receiver, long id) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("table_name", getTableName(typeCode, tableNumber, receiver));
        param.put("id", id);
        return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.get", param);
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
        // return sqlOperator.delete("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Message message) {

        throw new NotImplementedException();
        // return sqlOperator.update("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.update", message) > 0;
    }

    @Override
    public boolean update(String typeCode, int tableNumber, Message message) {

        Map<String, Object> param = BeanUtils.transBean2Map(message);
        param.put("table_name", getTableName(typeCode, tableNumber, message.getReceiver()));
        return sqlOperator.update("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.update", param) > 0;
    }

    @Override
    public List<Message> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Message> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Message> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Message> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.count4page", param);
        Page<Message> page = new Page<Message>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Message> page(MessageQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Message> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.count4query", param);
        Page<Message> page = new Page<Message>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Message> listAll() {

        List<Message> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.listAll");
        return list;
    }

    @Override
    public List<Message> listByReceiver(String typeCode, int classify, int tableNumber, long receiver, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("receiver", receiver);
        param.put("start", start);
        param.put("count", count);
        param.put("classify", classify);
        param.put("table_name", getTableName(typeCode, tableNumber, receiver));
        List<Message> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.listByReceiver", param);
        return list;
    }

    private String getTableName(String typeCode, int tableNumber, long receiver) {

        if (tableNumber == 1) {
            return "publicservice_message_" + typeCode;
        } else if (tableNumber > 1 && tableNumber <= 100) {
            return TableSplitUtil.getTableSplitName(receiver, "publicservice_message_" + typeCode, tableNumber);
        } else {
            throw new PublicServiceException("消息分表数量不在指定范围内." + tableNumber);
        }
    }

    @Override
    public int countByReceiver(String typeCode, int classify, int tableNumber, long receiver) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("table_name", getTableName(typeCode, tableNumber, receiver));
        param.put("receiver", receiver);
        param.put("classify", classify);
        return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.countByReceiver", param);
    }

    @Override
    public int countUnreadByReceiver(String typeCode, int classify, int tableNumber, long receiver) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("table_name", getTableName(typeCode, tableNumber, receiver));
        param.put("receiver", receiver);
        param.put("classify", classify);
        return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.countUnreadByReceiver", param);
    }

    @Override
    public List<Message> listContentByReceiver(String typeCode, int classify, int tableNumber, long receiver, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("receiver", receiver);
        param.put("start", start);
        param.put("count", count);
        param.put("classify", classify);
        param.put("table_name", getTableName(typeCode, tableNumber, receiver));
        List<Message> list = sqlOperator.selectList("com.qcloud.component.publicservice.dao.mysql.mapper.MessageMapper.listContentByReceiver", param);
        return list;
    }

    @Override
    public int getNewMsgNumber(String code, long receiver) {

        throw new NotImplementedException();
    }

    @Override
    public boolean resetNewMsgNumber(String code, long receiver) {

        throw new NotImplementedException();
    }
}
