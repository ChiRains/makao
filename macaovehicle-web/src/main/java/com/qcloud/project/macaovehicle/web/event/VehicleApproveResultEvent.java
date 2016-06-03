package com.qcloud.project.macaovehicle.web.event;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.snakerext.ExecutorVariableCalculator;

@Component
public class VehicleApproveResultEvent implements FormEvent, ExecutorVariableCalculator {

    private Log logger = LogFactory.getLog(getClass());

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        Integer result = context.getNotionResult();
        result = result == null || result != 2 ? 1 : 2;
        context.addReturnResult("approve", result);
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> map) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        String workitem = (String) map.get("workitem");
        if (StringUtils.isEmpty(workitem)) {
            return resultMap;
        }
        for (Entry<String, Object> e : map.entrySet()) {
            String key = e.getKey();
            if (workitem.equals(e.getValue()) && key.endsWith("qc_sw_workitem")) {
                String str = key.replaceAll("qc_sw_workitem", "result");
                Integer result = (Integer) map.get(str);
                result = result == null || result != 2 ? 1 : 2;
                resultMap.put("approve", result);
            }
        }
        return resultMap;
    }
}
