package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResCompany;
import com.cnfwsy.interfaces.mapper.emp.EmpResCompanyMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResCompanySrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-29 17:00:54
 */
@Service("empResCompanySrvImpl")
public class EmpResCompanySrvImpl extends CommonSrvImpl<EmpResCompany> implements IEmpResCompanySrv, InitializingBean {
    @Resource(name = "empResCompanyMapper")
    private EmpResCompanyMapper empResCompanyMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResCompanyMapper;
    }

    @Override
    public List<EmpResCompany> searchInfos(BaseForm info) {
        List<EmpResCompany> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResCompany info) {
        super.add(info);
    }

    @Override
    public void edit(EmpResCompany info) {
        super.edit(info);
    }

    @Override
    public EmpResCompany queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}