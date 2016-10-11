package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResEdu;
import com.cnfwsy.interfaces.mapper.emp.EmpResEduMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResEduSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-1 10:50:07
 */
@Service("empResEduSrvImpl")
public class EmpResEduSrvImpl extends CommonSrvImpl<EmpResEdu> implements IEmpResEduSrv, InitializingBean {
    @Resource(name = "empResEduMapper")
    private EmpResEduMapper empResEduMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResEduMapper;
    }

    @Override
    public List<EmpResEdu> searchInfos(BaseForm info) {
        List<EmpResEdu> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResEdu info) {
        super.add(info);
    }

    @Override
    public void edit(EmpResEdu info) {
        super.edit(info);
    }

    @Override
    public EmpResEdu queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}