package com.cnfwsy.core.controller;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.api.SecurityAspect;
import com.cnfwsy.core.api.UserSessionUtils;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.bean.SysAccount;
import com.cnfwsy.core.constant.ReturnCodeConstant;
import com.cnfwsy.core.exception.BusinessException;
import com.cnfwsy.core.model.security.ISysAccountSrv;
import com.cnfwsy.core.model.security.TokenManager;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Scope("prototype")
@RestController
public class LoginController extends BaseController<SysAccount> {
    @Resource(name = "companyNoGenerator")
    private INoGenerator companyNoGenerator;
    @Resource(name = "sysAccountSrvImpl")
    private ISysAccountSrv sysAccountSrvImpl;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private SecurityAspect securityAspect;


    /**
     * 1，用户名，如果session存在该用户，执行2，否则执行3
     * 2，检验用户是否锁定，如果没有锁定，返回6，锁定返回5；
     * 3，用用户名查询用户信息，如果有该用户，执行4，否则执行5
     * 4，校验密码，如果密码正确，执行2，如果密码错误，执行5
     * 5，返回登录页面
     * 6，返回成功
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @SystemControllerLog(description = "用户登录")
    @IgnoreSecurity
    public Response login(@RequestBody SysAccount user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {


        SysAccount account = sysAccountSrvImpl.login(user);
        if (null == account) {
            throw new BusinessException(ReturnCodeConstant.ACCOUNT_NOEXIT_EXCEPTION);
        }
        UserSessionUtils.saveUserToSession(session, account);
        //先删除
        String token = request.getHeader(securityAspect.getTokenName());
        tokenManager.removeToken(token);
        //创建
        token = tokenManager.createToken(account.getAccountId().toString());
        response.setHeader(securityAspect.getTokenName(), token);


        account.setPassword(null);
        user.setPassword(null);
        Response result = buildResponse(account);
        return result;
    }


    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @SystemControllerLog(description = "用户注册")
    @IgnoreSecurity
    public Response register(@RequestBody SysAccount user, HttpServletRequest request) throws Exception {
        user.setBussId(companyNoGenerator.offer());
        sysAccountSrvImpl.add(user);
        user.setPassword(null);
        Response response = buildResponse(user);
        return response;
    }


    @RequestMapping(value = "/reset", method = RequestMethod.PUT)
    @SystemControllerLog(description = "找回用户密码")
    @IgnoreSecurity
    public Response reset(@RequestBody SysAccount user) throws Exception {
        sysAccountSrvImpl.reset(user);
        user.setPassword(null);
        Response response = buildResponse(user);
        return response;

    }


    @RequestMapping(value = "/loginout/{usrid}", method = RequestMethod.DELETE)
    @SystemControllerLog(description = "用户登出")
    @IgnoreSecurity
    public Response loginout(HttpSession session, HttpServletRequest request) throws Exception {
        UserSessionUtils.removeUserFromSession(session);
        String token = request.getHeader(securityAspect.getTokenName());
        tokenManager.removeToken(token);
        SysAccount c = null;
        Response response = buildResponse(c);
        return response;
    }


}
