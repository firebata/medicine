package com.cnfwsy.interfaces.mapper.sys;

import com.cnfwsy.core.mapper.CommonMapper;
import com.cnfwsy.interfaces.bean.sys.SysCity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:37:37
 */
@Repository("sysCityMapper")
public interface SysCityMapper extends CommonMapper<SysCity> {

    SysCity querySysCityByCityName(String cityName);

    List<Map<String, String>> options2(String provinceId);
}