package com.cnfwsy.core.model.log.impl;

import com.cnfwsy.core.bean.LogInfo;
import com.cnfwsy.core.mapper.LogInfoMapper;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.core.model.log.LogSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 说明:
 * Created by zhangjh on 2016/1/11.
 */
@Service("logSrv")
public class LogSrvImpl extends CommonSrvImpl<LogInfo> implements LogSrv, InitializingBean {
    @Resource(name = "logInfoMapper")
    private LogInfoMapper logInfoMapper;

//    @Override
//    public void add(LogInfo log) {
//
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        commonMapper = logInfoMapper;
    }
}
