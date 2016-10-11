package com.cnfwsy.interfaces.mapper.sys;

import com.cnfwsy.core.mapper.CommonMapper;
import com.cnfwsy.interfaces.bean.sys.SysSms;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 类说明:
 * Created by zhangjh on 2016-8-8 14:23:31
 */
@Repository("sysSmsMapper")
public interface SysSmsMapper extends CommonMapper<SysSms> {

    SysSms queryInfoByMobile(@Param(value = "mobile") String mobile, @Param(value = "validateCode") String validateCode, @Param(value = "platform") String currentPlatform);

    void updateStatus(SysSms sms);
}