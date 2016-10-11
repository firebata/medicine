package com.cnfwsy.interfaces.mapper.emp;

import com.cnfwsy.core.mapper.CommonMapper;
import com.cnfwsy.interfaces.bean.emp.EmpEmployee;
import org.springframework.stereotype.Repository;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-27 10:05:24
 */
@Repository("empEmployeeMapper")
public interface EmpEmployeeMapper extends CommonMapper<EmpEmployee> {
    EmpEmployee queryInfoByAccountId(String natrualKey);

}