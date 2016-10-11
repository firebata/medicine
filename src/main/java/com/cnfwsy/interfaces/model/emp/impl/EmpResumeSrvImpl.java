package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResume;
import com.cnfwsy.interfaces.mapper.emp.EmpResumeMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResumeSrv;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("empResumeSrvImpl")
public class EmpResumeSrvImpl extends CommonSrvImpl<EmpResume> implements IEmpResumeSrv, InitializingBean {
    @Resource(name = "empResumeMapper")
    private EmpResumeMapper empResumeMapper;
    @Autowired
    private INoGenerator resumeNoGenerator;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResumeMapper;
    }

    @Override
    public List<EmpResume> searchInfos(BaseForm info) {
        List<EmpResume> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResume info) {
        String no = resumeNoGenerator.offer();
        info.setEmployeeId(no);
        super.add(info);
    }

    @Override
    public void edit(EmpResume info) {
        super.edit(info);
    }

    @Override
    public EmpResume queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}