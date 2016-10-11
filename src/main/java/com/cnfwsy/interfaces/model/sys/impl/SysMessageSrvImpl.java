package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.sys.SysMessage;
import com.cnfwsy.interfaces.mapper.sys.SysMessageMapper;
import com.cnfwsy.interfaces.model.sys.ISysMessageSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("sysMessageSrvImpl")
public class SysMessageSrvImpl extends CommonSrvImpl<SysMessage> implements ISysMessageSrv, InitializingBean {
    @Resource(name = "sysMessageMapper")
    private SysMessageMapper sysMessageMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = sysMessageMapper;
    }

    @Override
    public List<SysMessage> searchInfos(BaseForm info) {
        List<SysMessage> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(SysMessage info) {
        super.add(info);
    }

    @Override
    public void edit(SysMessage info) {
        super.edit(info);
    }

    @Override
    public SysMessage queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}