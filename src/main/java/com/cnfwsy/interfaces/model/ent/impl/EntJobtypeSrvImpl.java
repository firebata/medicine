package com.cnfwsy.interfaces.model.ent.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.ent.EntJobtype;
import com.cnfwsy.interfaces.mapper.ent.EntJobtypeMapper;
import com.cnfwsy.interfaces.model.ent.IEntJobtypeSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-20 15:21:10
 */
@Service("entJobtypeSrvImpl")
public class EntJobtypeSrvImpl extends CommonSrvImpl<EntJobtype> implements IEntJobtypeSrv, InitializingBean {
    @Resource(name = "entJobtypeMapper")
    private EntJobtypeMapper entJobtypeMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = entJobtypeMapper;
    }

    @Override
    public List<EntJobtype> searchInfos(BaseForm info) {
        List<EntJobtype> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EntJobtype info) {
        super.add(info);
    }

    @Override
    public void edit(EntJobtype info) {
        super.edit(info);
    }

    @Override
    public EntJobtype queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}