package com.cnfwsy.interfaces.model.ent.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.ent.EntResume;
import com.cnfwsy.interfaces.mapper.ent.EntResumeMapper;
import com.cnfwsy.interfaces.model.ent.IEntResumeSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-28 0:36:59
 */
@Service("entResumeSrvImpl")
public class EntResumeSrvImpl extends CommonSrvImpl<EntResume> implements IEntResumeSrv, InitializingBean {
    @Resource(name = "entResumeMapper")
    private EntResumeMapper entResumeMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = entResumeMapper;
    }

    @Override
    public List<EntResume> searchInfos(BaseForm info) {
        List<EntResume> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EntResume info) {
        super.add(info);
    }

    @Override
    public void edit(EntResume info) {
        super.edit(info);
    }

    @Override
    public EntResume queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}