package com.cnfwsy.core.model.security.impl;

import com.cnfwsy.core.api.UserSessionUtils;
import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.bean.SysAccount;
import com.cnfwsy.core.constant.ReturnCodeConstant;
import com.cnfwsy.core.exception.BusinessException;
import com.cnfwsy.core.mapper.SysAccountMapper;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.core.model.security.ISysAccountSrv;
import com.cnfwsy.core.utils.MD5Encoder;
import com.cnfwsy.interfaces.bean.sys.SysSms;
import com.cnfwsy.interfaces.model.sys.ISysSmsSrv;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.cnfwsy.core.constant.ReturnCodeConstant.*;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-12 13:47:10
 */
@Service("sysAccountSrvImpl")
public class SysAccountSrvImpl extends CommonSrvImpl<SysAccount> implements ISysAccountSrv, InitializingBean {
    @Resource(name = "sysAccountMapper")
    private SysAccountMapper sysAccountMapper;
    @Autowired
    private ISysSmsSrv sysSmsSrvImpl;

    @Autowired
    private INoGenerator accountNoGenerator;

    @Override
    public void afterPropertiesSet() {
        commonMapper = sysAccountMapper;
    }

    @Override
    public List<SysAccount> searchInfos(BaseForm info) {
        List<SysAccount> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(SysAccount info) {
        //短信验证码
        SysSms sms = sysSmsSrvImpl.isEnable(info.getTelNo(), info.getValidateCode());

        //用户是否存在
        SysAccount account = sysAccountMapper.queryAccount(info);
        if (account != null) {
            throw new BusinessException(NOT_ALLOW_REGISTER);
        } else {
            String accountId = accountNoGenerator.offer();
            info.setAccountId(accountId);
            String pwd = info.getPassword();
            String pwdEncript = new MD5Encoder().encode(pwd);
            info.setPassword(pwdEncript);
            super.add(info);
            sysSmsSrvImpl.updateStatus(sms);
        }

    }

    @Override
    public void edit(SysAccount info) {
        super.edit(info);
    }

    @Override
    public SysAccount queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

    public SysAccount login(SysAccount user) {
        SysAccount account = sysAccountMapper.queryAccount(user);
        if (null == account) {
            throw new BusinessException(TELNO_IS_INVALID);
        } else {
            String pwd = user.getPassword();
            String pwdEncript = new MD5Encoder().encode(pwd);
            String pwdDB = account.getPassword();

            //密码是否匹配
            if (!pwdDB.equals(pwdEncript)) {
                throw new BusinessException(PWD_IS_ERROR);
            }
            //用户是否锁定

            //用户是否已登录

            //刷新用户信息:session,权限等等

        }
        return account;

    }

    @Override
    public void reset(SysAccount user) {
        //短信验证码
        SysSms sms = sysSmsSrvImpl.isEnable(user.getTelNo(), user.getValidateCode());
        SysAccount account = sysAccountMapper.queryAccount(user);
        if (null == account) {
            throw new BusinessException(TELNO_IS_INVALID);
        } else {
            String pwd = user.getPassword();
            String pwdEncript = new MD5Encoder().encode(pwd);
//            String pwdDB = account.getPassword();
            account.setPassword(pwdEncript);
            sysAccountMapper.updatePWD(account);
            sysSmsSrvImpl.updateStatus(sms);

            account.setPassword(null);
            account.setPasswordnew(null);
        }

    }

    @Override
    public void updateUsr(SysAccount sysAccount) {
        sysAccountMapper.updateUsr(sysAccount);
    }

    @Override
    public void updatePWD(SysAccount sysAccount) {
        SysAccount accSession = UserSessionUtils.getUserFromSession();
        String usrId = accSession.getAccountId();
        sysAccount.setTelNo(accSession.getTelNo());
        sysAccount.setAccountId(usrId);
        SysAccount accountDB = login(sysAccount);
        if (accountDB == null) {
            throw new BusinessException(ReturnCodeConstant.PWD_IS_ERROR);
        }
        String pwd = sysAccount.getPasswordnew();
        String pwdEncript = new MD5Encoder().encode(pwd);
        sysAccount.setPassword(pwdEncript);
        sysAccountMapper.updatePWD(sysAccount);
        sysAccount.setPassword(null);
        sysAccount.setPasswordnew(null);

    }

}