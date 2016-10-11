package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.emp.EmpResSkill;
import com.cnfwsy.interfaces.mapper.emp.EmpResSkillMapper;
import com.cnfwsy.interfaces.model.emp.IEmpResSkillSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("empResSkillSrvImpl")
public class EmpResSkillSrvImpl extends CommonSrvImpl<EmpResSkill> implements IEmpResSkillSrv, InitializingBean {
    @Resource(name = "empResSkillMapper")
    private EmpResSkillMapper empResSkillMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empResSkillMapper;
    }

    @Override
    public List<EmpResSkill> searchInfos(BaseForm info) {
        List<EmpResSkill> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpResSkill info) {
        super.add(info);
    }

    @Override
    public void edit(EmpResSkill info) {
        super.edit(info);
    }

    @Override
    public EmpResSkill queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}