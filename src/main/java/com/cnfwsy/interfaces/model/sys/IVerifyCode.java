package com.cnfwsy.interfaces.model.sys;

import com.cnfwsy.interfaces.bean.sys.SysSms;

import java.io.IOException;
import java.util.Map;

/**
 * 说明:
 * Created by zhangjh on 2016-08-08.
 */
public interface IVerifyCode {
    SysSms sendSms(SysSms info, Map<String, String> smc_verification) throws IOException;
}
