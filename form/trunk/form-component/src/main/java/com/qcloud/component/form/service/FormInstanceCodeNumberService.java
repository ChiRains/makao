package com.qcloud.component.form.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.model.FormInstanceCodeNumber;
import com.qcloud.component.form.model.query.FormInstanceCodeNumberQuery;

public interface FormInstanceCodeNumberService {

    public boolean add(FormInstanceCodeNumber formInstanceCodeNumber);

    public FormInstanceCodeNumber get(Long id);

    public int getNextNumber(String code);

    public boolean delete(Long id);

    public boolean update(FormInstanceCodeNumber formInstanceCodeNumber);

    public Page<FormInstanceCodeNumber> page(FormInstanceCodeNumberQuery query, int start, int count);

    public List<FormInstanceCodeNumber> listAll();
}
