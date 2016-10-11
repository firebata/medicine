package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.api.SpringContextHolder;
import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.cache.DictionaryInfoCachedMap;
import com.cnfwsy.core.constant.ReturnCodeConstant;
import com.cnfwsy.core.exception.BusinessException;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.sys.SysSms;
import com.cnfwsy.interfaces.constant.BusinessConstant;
import com.cnfwsy.interfaces.mapper.sys.SysSmsMapper;
import com.cnfwsy.interfaces.model.sys.ISysSmsSrv;
import com.cnfwsy.interfaces.model.sys.IVerifyCode;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 类说明:
 * Created by zhangjh on 2016-8-8 14:23:31
 */
@Service("sysSmsSrvImpl")
public class SysSmsSrvImpl extends CommonSrvImpl<SysSms> implements ISysSmsSrv, InitializingBean {
    @Resource(name = "sysSmsMapper")
    private SysSmsMapper sysSmsMapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = sysSmsMapper;
    }

    @Override
    public List<SysSms> searchInfos(BaseForm info) {
        List<SysSms> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(SysSms info) {
        Map<String, String> smc_verification = DictionaryInfoCachedMap.SINGLETONE.getValueMapByTypeKey(BusinessConstant.SMC_VERIFICATION);
        IVerifyCode vCodeSrv = SpringContextHolder.getBean(smc_verification.get(BusinessConstant.CURRENT_PLATFORM));
        try {
            info = vCodeSrv.sendSms(info, smc_verification);
            super.add(info);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(ReturnCodeConstant.GET_VCODE_EXCEPTION);
        }

    }

    @Override
    public void edit(SysSms info) {
        super.edit(info);
    }

    /**
     * 手机号码
     *
     * @param mobile 手机号码
     * @return
     */
    @Override
    public SysSms queryInfoByNatrualKey(String mobile) {

        return super.queryInfoByNatrualKey(mobile);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

    @Override
    public SysSms isEnable(String mobile, String validateCode) {
        Date now = new Date();
        String platform = BusinessConstant.CURRENT_PLATFORM;
        Map<String, String> smc_verification = DictionaryInfoCachedMap.SINGLETONE.getValueMapByTypeKey(BusinessConstant.SMC_VERIFICATION);
        String currentPlatform = smc_verification.get(platform);
        int vtime = Integer.parseInt(smc_verification.get(BusinessConstant.EFFECTIVE_TIME));
        //是否有验证码在数据库
        SysSms sms = sysSmsMapper.queryInfoByMobile(mobile, validateCode, currentPlatform);
        boolean isEnable = false;
        if (null != sms) {
            Date createTime = sms.getCreateTime();
            long diff = now.getTime() - createTime.getTime();//这样得到的差值是微秒级别
            long min = diff / (60 * 1000);
            if (min < vtime) {
                isEnable = true;
            } else {
                throw new BusinessException(ReturnCodeConstant.VCODE_EXPIRED);
            }
        }
        if (!isEnable) {
            throw new BusinessException(ReturnCodeConstant.VCODE_ISERROR);
        }
        return sms;
    }

    @Override
    public void updateStatus(SysSms sms) {
        sms.setStatus(BusinessConstant.SMC_UP);
        sysSmsMapper.updateStatus(sms);
    }


}