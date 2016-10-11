package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResExpect;
import com.cnfwsy.interfaces.mapper.emp.EmpResExpectMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResExpectSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-28 16:46:35
 */
@Service("empResExpectSrvImpl")
public class EmpResExpectSrvImpl extends CommonSrvImpl<EmpResExpect> implements IEmpResExpectSrv, InitializingBean {
    @Resource(name = "empResExpectMapper")
    private EmpResExpectMapper empResExpectMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResExpectMapper;
    }

    @Override
    public List<EmpResExpect> searchInfos(BaseForm info) {
        List<EmpResExpect> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResExpect info) {
        super.add(info);
    }

    @Override
    public void edit(EmpResExpect info) {
        super.edit(info);
    }

    @Override
    public EmpResExpect queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}