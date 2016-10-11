package com.cnfwsy.core.controller;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.api.UserSessionUtils;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.bean.SysAccount;
import com.cnfwsy.core.model.security.ISysAccountSrv;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

import static com.cnfwsy.core.api.UserSessionUtils.getUserFromSession;

/**
 * 接口层
 * Created by zhangjh on 2016-6-12 13:37:37
 */
@RestController
public class SysAccountController extends BaseController<SysAccount> {

    @Resource(name = "sysAccountSrvImpl")
    private ISysAccountSrv sysAccountSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/sysAccount", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody SysAccount sysAccount) {
        sysAccountSrvImpl.add(sysAccount);
        Response response = buildResponse(sysAccount);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/sysAccount/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysAccount sysAccount = sysAccountSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(sysAccount);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/sysAccount/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysAccount sysAccount = null;
        sysAccountSrvImpl.del(businessKey);
        Response response = buildResponse(sysAccount);
        return response;
    }

    /**
     * @param sysAccount
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/sysAccount/{businessKey}", method = RequestMethod.PUT)
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody SysAccount sysAccount) {
        sysAccountSrvImpl.edit(sysAccount);
        Response response = buildResponse(sysAccount);
        return response;
    }

    /**
     * @param sysAccount
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/updateUsr", method = RequestMethod.PUT)
    public Response updateUsr(@RequestBody SysAccount sysAccount) {
        String usrId = UserSessionUtils.getUserFromSession().getAccountId();
        sysAccount.setAccountId(usrId);
        sysAccountSrvImpl.updateUsr(sysAccount);
        SysAccount accSession = UserSessionUtils.getUserFromSession();
        accSession.setTelNo(sysAccount.getTelNo());
        accSession.setEmail(sysAccount.getEmail());
        Response response = buildResponse(sysAccount);
        return response;
    }

    /**
     * @param sysAccount
     * @return
     */
    @SystemControllerLog(description = "更新密码")
    @RequestMapping(value = "/upwd", method = RequestMethod.PUT)
    public Response upwd(@RequestBody SysAccount sysAccount) {

        sysAccountSrvImpl.updatePWD(sysAccount);

        Response response = buildResponse(sysAccount);
//        ModelAndView modelAndView = new ModelAndView("redirect:/loginout/" + usrId);
        return response;
    }


    /**
     * @param infos List<SysAccount>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/sysAccount", method = RequestMethod.PUT)
    public Response updateBatch(@RequestBody List<SysAccount> infos) {
        sysAccountSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/sysAccounts", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody SysAccount sysAccount) {
        Response response = buildSearchJsonMap(sysAccount, request, sysAccountSrvImpl);
        return response;
    }


    /**
     * @return
     */
    @SystemControllerLog(description = "账号管理页面")
    @RequestMapping(value = "/acmg", method = RequestMethod.GET)
    public ModelAndView acmg() {
        SysAccount account = getUserFromSession();
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/sys/acmg");
        modelAndView.addObject("usr", account);
        return modelAndView;
    }

    /**
     * @return
     */
    @SystemControllerLog(description = "密码修改页面")
    @RequestMapping(value = "/pwd", method = RequestMethod.GET)
    public ModelAndView pwd() {
//        SysAccount account = getUserFromSession();
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/sys/pwd");
//        modelAndView.addObject("usr", account);
        return modelAndView;
    }

}
