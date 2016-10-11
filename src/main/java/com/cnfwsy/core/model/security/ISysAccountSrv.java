package com.cnfwsy.core.model.security;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.core.bean.SysAccount;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
public interface ISysAccountSrv extends ICommonSrv<SysAccount> {

    SysAccount login(SysAccount user);

    void reset(SysAccount user);

    void updateUsr(SysAccount sysAccount);

    void updatePWD(SysAccount sysAccount);
}