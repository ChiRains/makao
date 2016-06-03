package com.qcloud.component.snakerext.core;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.snakerext.SnakerExtClient;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
import com.qcloud.component.snakerext.service.ProcessExecutorInterfaceService;
import com.qcloud.component.snakerext.service.ProcessExecutorService;
import com.qcloud.component.snakerext.service.ProcessFormService;
import com.qcloud.pirates.core.reflect.BeanUtils;
@Service
public class SnakerExtClientImpl implements SnakerExtClient {
//    @Autowired
//    private ProcessFormService              processFormService;
//    @Autowired
//    private ProcessExecutorService          processExecutorService;
//    @Autowired
//    private ProcessExecutorInterfaceService processExecutorInterfaceService;
//
//    @Override
//    public List<ProcessForm> listAll(ProcessFormQuery query) {
//        return processFormService.list(BeanUtils.transBean2Map(query));
//    }
//
//    @Override
//    public List<ProcessExecutor> listAllProcessExecutor(Map<String, Object> map) {
//        return processExecutorService.listAll(map);
//    }
//
//    @Override
//    public List<ProcessExecutor> listAllProcessExecutor() {
//        return processExecutorService.listAll();
//    }
//
//    @Override
//    public List<ProcessExecutorInterface> listAllProcessExecutorInterface(Map<String, Object> map) {
//        return processExecutorInterfaceService.listAll(map);
//    }
//
//    @Override
//    public List<ProcessExecutorInterface> listAllProcessExecutorInterface() {
//        return processExecutorInterfaceService.listAll();
//    }
}