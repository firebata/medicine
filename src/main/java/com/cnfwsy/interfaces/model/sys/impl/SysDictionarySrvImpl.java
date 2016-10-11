package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.sys.SysDictionary;
import com.cnfwsy.interfaces.mapper.sys.SysDictionaryMapper;
import com.cnfwsy.interfaces.model.sys.ISysDictionarySrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("sysDictionarySrvImpl")
public class SysDictionarySrvImpl extends CommonSrvImpl<SysDictionary> implements ISysDictionarySrv, InitializingBean {
    @Resource(name = "sysDictionaryMapper")
    private SysDictionaryMapper sysDictionaryMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = sysDictionaryMapper;
    }

    @Override
    public List<SysDictionary> searchInfos(BaseForm info) {
        List<SysDictionary> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(SysDictionary info) {
        super.add(info);
    }

    @Override
    public void edit(SysDictionary info) {
        super.edit(info);
    }

    @Override
    public SysDictionary queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}