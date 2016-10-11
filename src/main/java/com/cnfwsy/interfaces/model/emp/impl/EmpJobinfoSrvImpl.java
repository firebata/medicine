package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpJobinfo;
import com.cnfwsy.interfaces.mapper.emp.EmpJobinfoMapper;
import com.cnfwsy.interfaces.model.emp.IEmpJobinfoSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-28 0:36:59
 */
@Service("empJobinfoSrvImpl")
public class EmpJobinfoSrvImpl extends CommonSrvImpl<EmpJobinfo> implements IEmpJobinfoSrv, InitializingBean {
    @Resource(name = "empJobinfoMapper")
    private EmpJobinfoMapper empJobinfoMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empJobinfoMapper;
    }

    @Override
    public List<EmpJobinfo> searchInfos(BaseForm info) {
        List<EmpJobinfo> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpJobinfo info) {
        super.add(info);
    }

    @Override
    public void edit(EmpJobinfo info) {
        super.edit(info);
    }

    @Override
    public EmpJobinfo queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}