package com.cnfwsy.interfaces.model.sys;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.interfaces.bean.sys.SysCity;

import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
public interface ISysCitySrv extends ICommonSrv<SysCity> {

    SysCity querySysCityByCityName(String cityName);

    Map<String, String> options(String provinceId);
}