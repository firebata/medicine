package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResProject;
import com.cnfwsy.interfaces.mapper.emp.EmpResProjectMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResProjectSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("empResProjectSrvImpl")
public class EmpResProjectSrvImpl extends CommonSrvImpl<EmpResProject> implements IEmpResProjectSrv, InitializingBean {
    @Resource(name = "empResProjectMapper")
    private EmpResProjectMapper empResProjectMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResProjectMapper;
    }

    @Override
    public List<EmpResProject> searchInfos(BaseForm info) {
        List<EmpResProject> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResProject info) {
        super.add(info);
    }

    @Override
    public void edit(EmpResProject info) {
        super.edit(info);
    }

    @Override
    public EmpResProject queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}