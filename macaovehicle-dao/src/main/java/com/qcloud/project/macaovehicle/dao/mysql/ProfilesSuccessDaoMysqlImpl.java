package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.ProfilesSuccessDao;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

@Repository
public class ProfilesSuccessDaoMysqlImpl implements ProfilesSuccessDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ProfilesSuccess profilesSuccess) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.insert", profilesSuccess) == 1;
    }

    @Override
    public ProfilesSuccess get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ProfilesSuccess profilesSuccess) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.update", profilesSuccess) > 0;
    }

    @Override
    public List<ProfilesSuccess> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProfilesSuccess> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProfilesSuccess> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProfilesSuccess> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.count4page", param);
        Page<ProfilesSuccess> page = new Page<ProfilesSuccess>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ProfilesSuccess> page(ProfilesSuccessQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("groupByStr", StringUtil.emptyToNull(query.getGroupByStr()));
        param.put("carOwnerId", query.getCarOwnerId());
        param.put("driverId", query.getDriverId());
        param.put("vehicleId", query.getVehicleId());
        param.put("vEnable", query.getvEnable());
        param.put("dEnable", query.getdEnable());
        param.put("plateNumber", StringUtil.emptyToNull(query.getPlateNumber()));
        param.put("licenseNumber", StringUtil.emptyToNull(query.getLicenseNumber()));
        param.put("driverName", StringUtil.emptyToNull(query.getDriverName()));
        param.put("driverIdCard", StringUtil.emptyToNull(query.getDriverIdCard()));
        param.put("models", StringUtil.emptyToNull(query.getModels()));
        param.put("idcardNumber", StringUtil.emptyToNull(query.getIdcardNumber()));
        param.put("sex", query.getSex());
        param.put("nation", query.getNation());
        List<ProfilesSuccess> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.count4query", param);
        Page<ProfilesSuccess> page = new Page<ProfilesSuccess>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ProfilesSuccess> listAll() {

        List<ProfilesSuccess> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.listAll");
        return list;
    }

    @Override
    public List<ProfilesSuccess> listByDriverId(Long driverId) {

        List<ProfilesSuccess> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.listByDriverId", driverId);
        return list;
    }

    @Override
    public Page<Object[]> pageByGroup(ProfilesSuccessQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("groupByStr", StringUtil.emptyToNull(query.getGroupByStr()));
        param.put("carOwnerId", query.getCarOwnerId());
        param.put("driverId", query.getDriverId());
        param.put("vehicleId", query.getVehicleId());
        List<Map<String, Object>> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.pageByGroup", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.countByGroup", param);
        Page<Object[]> page = new Page<Object[]>();
        page.setCount(total);
        List<Object[]> objs = new ArrayList<Object[]>();
        for (Map<String, Object> map : list) {
            Object[] obj = new Object[2];
            ProfilesSuccess profilesSuccess = new ProfilesSuccess();
            profilesSuccess.setId((Long) map.get("id"));
            profilesSuccess.setCarOwnerId((Long) map.get("carOwnerId"));
            profilesSuccess.setVehicleId((Long) map.get("vehicleId"));
            profilesSuccess.setDriverId((Long) map.get("driverId"));
            profilesSuccess.setCreateDate((Date) map.get("createDate"));
            profilesSuccess.setFormInstanceId((Long) map.get("formInstanceId"));
            obj[0] = profilesSuccess;
            obj[1] = map.get("vCount");
            objs.add(obj);
        }
        page.setData(objs);
        return page;
    }

    @Override
    public List<ProfilesSuccess> listByQuery(ProfilesSuccessQuery query) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("groupByStr", query.getGroupByStr());
        param.put("carOwnerId", query.getCarOwnerId());
        param.put("driverId", query.getDriverId());
        param.put("vehicleId", query.getVehicleId());
        param.put("vEnable", query.getvEnable());
        param.put("dEnable", query.getdEnable());
        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProfilesSuccessMapper.listByQuery", param);
    }
}
