package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResShow;
import com.cnfwsy.interfaces.mapper.emp.EmpResShowMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResShowSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("empResShowSrvImpl")
public class EmpResShowSrvImpl extends CommonSrvImpl<EmpResShow> implements IEmpResShowSrv, InitializingBean {
    @Resource(name = "empResShowMapper")
    private EmpResShowMapper empResShowMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResShowMapper;
    }

    @Override
    public List<EmpResShow> searchInfos(BaseForm info) {
        List<EmpResShow> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResShow info) {
        super.add(info);
    }

    @Override
    public void edit(EmpResShow info) {
        super.edit(info);
    }

    @Override
    public EmpResShow queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}