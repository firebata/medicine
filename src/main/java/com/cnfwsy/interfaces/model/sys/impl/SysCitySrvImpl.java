package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.sys.SysCity;
import com.cnfwsy.interfaces.mapper.sys.SysCityMapper;
import com.cnfwsy.interfaces.model.sys.ISysCitySrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("sysCitySrvImpl")
public class SysCitySrvImpl extends CommonSrvImpl<SysCity> implements ISysCitySrv, InitializingBean {

    @Resource(name = "sysCityMapper")
    private SysCityMapper sysCityMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = sysCityMapper;
    }

    @Override
    public List<SysCity> searchInfos(BaseForm info) {
        List<SysCity> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(SysCity info) {
        super.add(info);
    }

    @Override
    public void edit(SysCity info) {
        super.edit(info);
    }

    @Override
    public SysCity queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

    @Override
    public SysCity querySysCityByCityName(String cityName) {
        return sysCityMapper.querySysCityByCityName(cityName);
    }

    public Map<String, String> options(String provinceId) {
        List<Map<String, String>> list = sysCityMapper.options2(provinceId);
        Map<String, String> map = new HashMap<String, String>();
        if (null != list && list.size() > 0) {
            for (Map<String, String> one : list) {
                String key = String.valueOf(one.get("city_id"));
                String value = String.valueOf(one.get("city_name"));
                map.put(key, value);
            }
        }
        return map;
    }

}