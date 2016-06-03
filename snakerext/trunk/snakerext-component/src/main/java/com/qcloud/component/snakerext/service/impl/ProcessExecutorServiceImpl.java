package com.qcloud.component.snakerext.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.snaker.engine.model.EndModel;
import org.snaker.engine.model.NodeModel;
import org.snaker.engine.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QMainFormData;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.ExecutorVariableCalculator;
import com.qcloud.component.snakerext.dao.ProcessExecutorDao;
import com.qcloud.component.snakerext.exception.SnakerExtException;
import com.qcloud.component.snakerext.model.Executor;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;
import com.qcloud.component.snakerext.service.ExecutorFinderService;
import com.qcloud.component.snakerext.service.ProcessExecutorService;
import com.qcloud.pirates.core.context.PiratesBeanFactoryAware;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.data.Page;

@Service
public class ProcessExecutorServiceImpl implements ProcessExecutorService {

    @Autowired
    private ProcessExecutorDao                            processExecutorDao;

    @Autowired
    private AutoIdGenerator                               autoIdGenerator;

    private static final String                           ID_KEY        = "snakerext_process_executor";

    @Resource(name = "clerkExecutorFinderService")
    private ExecutorFinderService                         clerkExecutorFinderService;

    @Resource(name = "processRoleExecutorFinderService")
    private ExecutorFinderService                         processRoleExecutorFinderService;

    @Resource(name = "interfaceExecutorFinderService")
    private ExecutorFinderService                         interfaceExecutorFinderService;

    @Autowired
    private FormClient                                    formClient;

    private Map<String, List<ExecutorVariableCalculator>> calculatorMap = new HashMap<String, List<ExecutorVariableCalculator>>();

    private Log                                           logger        = LogFactory.getLog(getClass());

    @PostConstruct
    public void init() {

        Xml xml = XmlFactory.get("qi-cloud-ExecutorVariableCalculator");
        if (xml == null) {
            logger.info("qi-cloud-ExecutorVariableCalculator:发送下一步执行人计算器没有定义.");
            return;
        }
        List<XmlItem> list = xml.getItemList();
        for (XmlItem xmlItem : list) {
            String process = xmlItem.getAttrMap().get("process");
            String bean = xmlItem.getText();
            ExecutorVariableCalculator executorVariableCalculator = (ExecutorVariableCalculator) PiratesBeanFactoryAware.getBeanFactory().getBean(bean);
            List<ExecutorVariableCalculator> calculatorList = calculatorMap.get(process);
            if (calculatorList == null) {
                calculatorList = new ArrayList<ExecutorVariableCalculator>();
                calculatorMap.put(process, calculatorList);
            }
            calculatorList.add(executorVariableCalculator);
        }
    }

    @Override
    public boolean add(ProcessExecutor processExecutor) {

        long id = autoIdGenerator.get(ID_KEY);
        processExecutor.setId(id);
        return processExecutorDao.add(processExecutor);
    }

    @Override
    public ProcessExecutor get(Long id) {

        return processExecutorDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return processExecutorDao.delete(id);
    }

    @Override
    public boolean update(ProcessExecutor processExecutor) {

        return processExecutorDao.update(processExecutor);
    }

    @Override
    public Page<ProcessExecutor> page(ProcessExecutorQuery query, int start, int count) {

        return processExecutorDao.page(query, start, count);
    }

    public List<ProcessExecutor> listAll() {

        return processExecutorDao.listAll();
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return processExecutorDao.delete(map);
    }

    @Override
    public List<ProcessExecutor> listByProcessIdAndTaskName(String processId, String taskName) {

        return processExecutorDao.listByProcessIdAndTaskName(processId, taskName);
    }

    private List<KeyValueVO> listExecutor(QTask t, Long clerkId, String processId, String taskName) {

        List<ProcessExecutor> list = processExecutorDao.listByProcessIdAndTaskName(processId, taskName);
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<KeyValueVO>(0);
        }
        List<KeyValueVO> kvList = new ArrayList<KeyValueVO>();
        for (ProcessExecutor processExecutor : list) {
            switch (processExecutor.getType()) {
            case 1:
                List<KeyValueVO> clerkList = clerkExecutorFinderService.find(t, clerkId, processExecutor.getMemberId());
                if (CollectionUtils.isNotEmpty(clerkList)) {
                    kvList.addAll(clerkList);
                }
                break;
            case 2:
                List<KeyValueVO> roleMemberList = processRoleExecutorFinderService.find(t, clerkId, processExecutor.getMemberId());
                if (CollectionUtils.isNotEmpty(roleMemberList)) {
                    kvList.addAll(roleMemberList);
                }
                break;
            case 3:
                List<KeyValueVO> interfaceMemberList = interfaceExecutorFinderService.find(t, clerkId, processExecutor.getMemberId());
                if (CollectionUtils.isNotEmpty(interfaceMemberList)) {
                    kvList.addAll(interfaceMemberList);
                }
                break;
            default:
                throw new SnakerExtException("流程:" + processId + " 活动:" + taskName + " 设置执行人类型不合法." + processExecutor.getType());
            }
        }
        for (KeyValueVO keyValueVO : kvList) {
            keyValueVO.setMessage("");
        }
        return kvList;
    }

    @Autowired
    private ISnakerClient snakerClient;

    public List<Executor> list(Process process, Order order, Task task, QTask t, QClerk clerk) {

        QMainFormData mainFormData = formClient.get(t.getFormInstance());
        List<ExecutorVariableCalculator> calculatorList = calculatorMap.get(process.getName());
        Map<String, Object> map = mainFormData.toMap();
        Map<String, Object> tm = BeanUtils.transBean2Map(t);
        map.putAll(tm);
        Map<String, Object> vMap = new HashMap<String, Object>();
        vMap.putAll(map);
        if (CollectionUtils.isNotEmpty(calculatorList)) {
            for (ExecutorVariableCalculator executorVariableCalculator : calculatorList) {
                if (executorVariableCalculator != null) {
                    Map<String, Object> r = executorVariableCalculator.calculate(vMap);
                    vMap.putAll(r);
                }
            }
        }
        List<NodeModel> list = snakerClient.nextTaskModels(task.getId(), vMap);
        List<Executor> voList = new ArrayList<Executor>();
        for (NodeModel nodeModel : list) {
            Executor executorVO = new Executor();
            executorVO.setTaskName(nodeModel.getDisplayName());
            executorVO.setExecutorKey("");
            if (nodeModel instanceof TaskModel) {
                TaskModel taskModel = (TaskModel) nodeModel;
                String key = taskModel.getAssignee();
                executorVO.setExecutorKey(key);
                List<KeyValueVO> executors = listExecutor(t, clerk.getId(), order.getProcessId(), taskModel.getName());
                if (CollectionUtils.isNotEmpty(executors)) {
                    executorVO.getExecutorList().addAll(executors);
                } else {
                    throw new SnakerExtException("流程:" + order.getProcessId() + " 活动:" + task.getDisplayName() + " 尚未设置执行人.");
                }
            }
            voList.add(executorVO);
        }
        return voList;
    }

    public boolean isEndProcessActivity(Process process, Task task, QTask t) {

        QMainFormData mainFormData = formClient.get(t.getFormInstance());
        List<ExecutorVariableCalculator> calculatorList = calculatorMap.get(process.getName());
        Map<String, Object> map = mainFormData.toMap();
        Map<String, Object> tm = BeanUtils.transBean2Map(t);
        map.putAll(tm);
        Map<String, Object> vMap = new HashMap<String, Object>();
        vMap.putAll(map);
        if (CollectionUtils.isNotEmpty(calculatorList)) {
            for (ExecutorVariableCalculator executorVariableCalculator : calculatorList) {
                if (executorVariableCalculator != null) {
                    Map<String, Object> r = executorVariableCalculator.calculate(vMap);
                    vMap.putAll(r);
                }
            }
        }
        List<NodeModel> list = snakerClient.nextTaskModels(task.getId(), vMap);
        return list.size() == 1 && list.get(0) instanceof EndModel;
    }
}
