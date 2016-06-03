package com.qcloud.component.publicdata.web.handler;
import java.util.List;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.web.vo.ClassifyVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminClassifyVO;
public interface ClassifyHandler {
    List<ClassifyVO> toVOList(List<Classify> list);

    ClassifyVO toVO(Classify classify);

    List<AdminClassifyVO> toVOList4Admin(List<Classify> list, long type);

    List<AdminClassifyVO> toVOList4Admin(List<Classify> list, Classify classify, long type);

    AdminClassifyVO toVO4Admin(Classify classify);
}
