package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.sys.SysLog;
import com.cnfwsy.interfaces.mapper.sys.SysLogMapper;
import com.cnfwsy.interfaces.model.sys.ISysLogSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("sysLogSrvImpl")
public class SysLogSrvImpl extends CommonSrvImpl<SysLog> implements ISysLogSrv, InitializingBean {
    @Resource(name = "sysLogMapper")
    private SysLogMapper sysLogMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = sysLogMapper;
    }

    @Override
    public List<SysLog> searchInfos(BaseForm info) {
        List<SysLog> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(SysLog info) {
        super.add(info);
    }

    @Override
    public void edit(SysLog info) {
        super.edit(info);
    }

    @Override
    public SysLog queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}