package com.cnfwsy.interfaces.model.sys;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.interfaces.bean.sys.SysSms;

/**
 * 类说明:
 * Created by zhangjh on 2016-8-8 14:23:31
 */
public interface ISysSmsSrv extends ICommonSrv<SysSms> {

    SysSms isEnable(String mobile, String validateCode);

    void updateStatus(SysSms sms);
}