package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.sys.SysProvince;
import com.cnfwsy.interfaces.mapper.sys.SysProvinceMapper;
import com.cnfwsy.interfaces.model.sys.ISysProvinceSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("sysProvinceSrvImpl")
public class SysProvinceSrvImpl extends CommonSrvImpl<SysProvince> implements ISysProvinceSrv, InitializingBean {
    @Resource(name = "sysProvinceMapper")
    private SysProvinceMapper sysProvinceMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = sysProvinceMapper;
    }

    @Override
    public List<SysProvince> searchInfos(BaseForm info) {
        List<SysProvince> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(SysProvince info) {
        super.add(info);
    }

    @Override
    public void edit(SysProvince info) {
        super.edit(info);
    }

    @Override
    public SysProvince queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}