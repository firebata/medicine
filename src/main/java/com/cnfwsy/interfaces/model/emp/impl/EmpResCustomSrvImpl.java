package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResCustom;
import com.cnfwsy.interfaces.mapper.emp.EmpResCustomMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResCustomSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("empResCustomSrvImpl")
public class EmpResCustomSrvImpl extends CommonSrvImpl<EmpResCustom> implements IEmpResCustomSrv, InitializingBean {
    @Resource(name = "empResCustomMapper")
    private EmpResCustomMapper empResCustomMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResCustomMapper;
    }

    @Override
    public List<EmpResCustom> searchInfos(BaseForm info) {
        List<EmpResCustom> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResCustom info) {
        super.add(info);
    }

    @Override
    public void edit(EmpResCustom info) {
        super.edit(info);
    }

    @Override
    public EmpResCustom queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}