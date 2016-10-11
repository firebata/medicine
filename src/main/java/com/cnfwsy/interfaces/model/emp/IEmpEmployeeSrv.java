package com.cnfwsy.interfaces.model.emp;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.interfaces.bean.emp.EmpEmployee;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-27 10:05:24
 */
public interface IEmpEmployeeSrv extends ICommonSrv<EmpEmployee> {

    EmpEmployee queryInfoByAccountId(String accountId);
}