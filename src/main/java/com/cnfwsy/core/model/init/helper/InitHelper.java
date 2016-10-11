package com.cnfwsy.core.model.init.helper;

import com.cnfwsy.core.api.SpringContextHolder;
import com.cnfwsy.core.cache.DictionaryInfoCachedMap;
import com.cnfwsy.core.cache.SystemBaseInfoCachedMap;
import com.cnfwsy.core.constant.CommonConstant;
import com.cnfwsy.interfaces.model.sys.ISysCitySrv;
import com.cnfwsy.interfaces.model.sys.ISysProvinceSrv;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Map;

/**
 * 系统启动，加载初始化信息
 *
 * @author: zhangjh
 * @version:2015年5月6日 下午4:30:54
 */
public enum InitHelper {

    SINGLETONE;

    public void init() throws IOException, DocumentException {
        // 初始化数据字典信息
        DictionaryHelper.SINGLETONE.initDictionary();

        // 缓存业务数据:待开发
        cacheProviceCityInfos();


    }

    private void cacheProviceCityInfos() {

        ISysProvinceSrv sysProvinceSrvImpl = SpringContextHolder.getBean("sysProvinceSrvImpl");

        ISysCitySrv sysCitySrvImpl = SpringContextHolder.getBean("sysCitySrvImpl");
        Map<String, String> cityMap = sysCitySrvImpl.options("city_id", "city_name");
        Map<String, String> provinceMap = sysProvinceSrvImpl.options("province_id", "province_name");
        SystemBaseInfoCachedMap.SINGLETONE.setCityMap(cityMap);
        SystemBaseInfoCachedMap.SINGLETONE.setProvinceMap(provinceMap);

    }

    /**
     * 版本号：页面资源文件用
     *
     * @return
     */
    public String getVersion() {
        return DictionaryInfoCachedMap.SINGLETONE.getDictionaryValue("version", "version");
    }


    /**
     * 当前环境：页面资源文件用
     *
     * @return
     */
    public String getEnvironment() {
        return DictionaryInfoCachedMap.SINGLETONE.getDictionaryValue(CommonConstant.SYSTEM_ENVIRONMENT, CommonConstant.SYSTEM_ENVIRONMENT_CURRENT);
    }


}
