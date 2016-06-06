package com.qcloud.component.form;

import java.util.List;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.ElementDefQuery;
import com.qcloud.component.form.model.query.FormDefQuery;

public interface FormClient {

	public List<FormDef> listAll(FormDefQuery query);

	public FormDef getFormDef(Long id);

	public List<ElementDef> listAllElementDef(ElementDefQuery query);

	QMainFormData get(Long formInstanceId);

	QMainFormData getHist(Long formInstanceHistId);

	String getFormInstCode(Long formInstanceId);

	QMainForm getForm(Long formId);

	String getMobileDomain();

	QFormInstance getByCode(String code);

}
