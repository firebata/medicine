package com.cnfwsy.interfaces.model.ent.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.ent.EntCompany;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import com.cnfwsy.interfaces.mapper.ent.EntJobinfoMapper;
import com.cnfwsy.interfaces.model.ent.IEntCompanySrv;
import com.cnfwsy.interfaces.model.ent.IEntJobinfoSrv;
import com.cnfwsy.interfaces.model.ent.helper.EntJobHelper;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-20 15:21:09
 */
@Service("entJobinfoSrvImpl")
public class EntJobinfoSrvImpl extends CommonSrvImpl<EntJobinfo> implements IEntJobinfoSrv, InitializingBean {
    /**
     * 职位查询
     */
    @Resource(name = "entJobinfoMapper")
    private EntJobinfoMapper entJobinfoMapper;


    @Resource(name = "entJobNoGenerator")
    INoGenerator entJobNoGenerator;

    @Resource(name = "entCompanySrvImpl")
    private IEntCompanySrv entCompanySrvImpl;

    @Override
    public void afterPropertiesSet() {
        commonMapper = entJobinfoMapper;
    }

    @Override
    public List<EntJobinfo> searchInfos(BaseForm info) {
        List<EntJobinfo> jobinfos = super.searchInfos(info);
        EntJobHelper.SINGLETONE.encodeJobAnCompanyId(jobinfos);
        return jobinfos;
    }


    @Override
    public void add(EntJobinfo info) {
        info.setJobId(entJobNoGenerator.offer());
        super.add(info);
    }

    @Override
    public void edit(EntJobinfo info) {
        super.edit(info);
    }

    @Override
    public EntJobinfo queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }



    @Override
    public EntJobinfo queryInfoById(String businessKey) {
        String jobId = Base64Utils.decode(businessKey);
        EntJobinfo entJobinfo = queryInfoByNatrualKey(jobId);
        String companyId = entJobinfo.getCompanyId();
        EntCompany entCompany = entCompanySrvImpl.queryInfoByNatrualKey(entJobinfo.getCompanyId().toString());
        entJobinfo.setEntCompany(entCompany);
        companyId = Base64Utils.encode(companyId);
        entCompany.setCompanyId(companyId);
        entJobinfo.setCompanyId(companyId);
        entJobinfo.setJobId(businessKey);
        return entJobinfo;
    }

}