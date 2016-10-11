package com.cnfwsy.core.mapper;

import com.cnfwsy.core.bean.SysAccount;
import org.springframework.stereotype.Repository;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:37:37
 */
@Repository("sysAccountMapper")
public interface SysAccountMapper extends CommonMapper<SysAccount> {
    SysAccount queryAccount(SysAccount info);

    void updatePWD(SysAccount account);

    void updateUsr(SysAccount sysAccount);
}