package com.cnfwsy.core.api;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.bean.SysAccount;
import com.cnfwsy.core.exception.AuthorizationException;
import com.cnfwsy.core.model.security.TokenManager;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 说明:校验登录接口
 * Created by zhangjh on 2016-05-27.
 */
public class SecurityAspect {
    private static final String DEFAULT_TOKEN_NAME = "X-Token";
    Logger logger = LoggerFactory.getLogger(SecurityAspect.class);
    private TokenManager tokenManager;
    private String tokenName;

    /**
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {

        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        // 若目标方法忽略了安全性检查，则直接调用目标方法
        if (!method.isAnnotationPresent(IgnoreSecurity.class)) {
            judgeLogin();
        }

        // 调用目标方法
        return pjp.proceed();
    }

    public void judgeLogin() {
        // 从 request header 中获取当前 token
        String token = WebContext.getRequest().getHeader(getTokenName());
        SysAccount userSession = UserSessionUtils.getUserFromSession();
        // 检查 token 有效性 和 session有效性
        if (!getTokenManager().checkToken(token) && null == userSession) {
            String message = String.format("token [%s] is invalid", token);
            logger.error(message);
            throw new AuthorizationException();//ReturnCodeConstant.TOKEN_IS_INVALID);
        }
    }


    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    public void setTokenName(String tokenName) {
        if (StringUtils.isEmpty(tokenName)) {
            tokenName = DEFAULT_TOKEN_NAME;
        }
        this.tokenName = tokenName;
    }

    public TokenManager getTokenManager() {
        return tokenManager;
    }

    public String getTokenName() {
        return tokenName;
    }
}

