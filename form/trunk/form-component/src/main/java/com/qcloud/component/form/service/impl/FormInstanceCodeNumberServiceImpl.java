package com.qcloud.component.form.service.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.autoid.exception.AutoIdException;
import com.qcloud.component.form.dao.FormInstanceCodeNumberDao;
import com.qcloud.component.form.model.FormInstanceCodeNumber;
import com.qcloud.component.form.model.query.FormInstanceCodeNumberQuery;
import com.qcloud.component.form.service.FormInstanceCodeNumberService;
import com.qcloud.pirates.data.Page;

@Service
public class FormInstanceCodeNumberServiceImpl implements FormInstanceCodeNumberService {

    @Autowired
    private FormInstanceCodeNumberDao formInstanceCodeNumberDao;

    @Autowired
    private AutoIdGenerator           autoIdGenerator;

    private Log                       log    = LogFactory.getLog(getClass());

    private static final String       ID_KEY = "form_form_instance_code_number";

    private static final int          TIMES  = 10;

    @Override
    public boolean add(FormInstanceCodeNumber formInstanceCodeNumber) {

        long id = autoIdGenerator.get(ID_KEY);
        formInstanceCodeNumber.setId(id);
        return formInstanceCodeNumberDao.add(formInstanceCodeNumber);
    }

    @Override
    public FormInstanceCodeNumber get(Long id) {

        return formInstanceCodeNumberDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return formInstanceCodeNumberDao.delete(id);
    }

    @Override
    public boolean update(FormInstanceCodeNumber formInstanceCodeNumber) {

        return formInstanceCodeNumberDao.update(formInstanceCodeNumber);
    }

    @Override
    public Page<FormInstanceCodeNumber> page(FormInstanceCodeNumberQuery query, int start, int count) {

        return formInstanceCodeNumberDao.page(query, start, count);
    }

    public List<FormInstanceCodeNumber> listAll() {

        return formInstanceCodeNumberDao.listAll();
    }

    @Override
    public int getNextNumber(String code) {

        synchronized (code) {
            boolean update = false;
            FormInstanceCodeNumber formInstanceCodeNumber = null;
            int index = 0;
            do {
                log.info("尝试第" + (index + 1) + "次加载并计算下一阶段自增长id.");
                formInstanceCodeNumber = formInstanceCodeNumberDao.getByCode(code);
                if (formInstanceCodeNumber == null) {
                    formInstanceCodeNumber = new FormInstanceCodeNumber();
                    formInstanceCodeNumber.setCode(code);
                    formInstanceCodeNumber.setNumber(1);
                    update = add(formInstanceCodeNumber);
                } else {
                    update = formInstanceCodeNumberDao.incr(formInstanceCodeNumber.getId(), formInstanceCodeNumber.getNumber());
                }
                if (index >= TIMES) {
                    throw new AutoIdException("尝试了" + TIMES + "次,更新 " + code + " 自动id失败。");
                }
                index++;
            } while (!update);
            formInstanceCodeNumber = formInstanceCodeNumberDao.getByCode(code);
            return new Long(formInstanceCodeNumber.getNumber()).intValue();
        }
    }
}
