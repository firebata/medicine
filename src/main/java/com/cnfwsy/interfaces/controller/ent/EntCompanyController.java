package com.cnfwsy.interfaces.controller.ent;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.ent.EntCompany;
import com.cnfwsy.interfaces.model.ent.IEntCompanySrv;
import com.cnfwsy.interfaces.model.ent.IEntJobinfoSrv;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.cnfwsy.core.api.UserSessionUtils.getBussIdSession;

/**
 * 企业信息管理接口层
 * Created by zhangjh on 2016-7-20 15:21:09
 */
@RestController
public class EntCompanyController extends BaseController<EntCompany> {

    @Resource(name = "entCompanySrvImpl")
    private IEntCompanySrv entCompanySrvImpl;

    @Resource(name = "entJobinfoSrvImpl")
    private IEntJobinfoSrv entJobinfoSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增企业详细")
    @RequestMapping(value = "/entCompany", method = RequestMethod.POST)
    public Response create(@Valid @RequestBody EntCompany entCompany) {
        entCompanySrvImpl.add(entCompany);
        Response response = buildResponse(entCompany);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询企业详细信息")
    @RequestMapping(value = "/entCompany/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EntCompany entCompany = entCompanySrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(entCompany);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除企业信息")
    @RequestMapping(value = "/entCompany/{businessKey}", method = RequestMethod.DELETE)
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EntCompany entCompany = null;
        entCompanySrvImpl.del(businessKey);
        Response response = buildResponse(entCompany);
        return response;

    }

    /**
     * @param entCompany
     * @return
     */
    @SystemControllerLog(description = "更新企业信息")
    @RequestMapping(value = "/entCompany/{businessKey}", method = RequestMethod.PUT)
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EntCompany entCompany) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf(businessKey);
        entCompanySrvImpl.edit(entCompany);
        Response response = buildResponse(entCompany);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/entCompanys", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EntCompany entCompany) {
        Response response = buildSearchJsonMap(entCompany, request, entCompanySrvImpl);
        return response;

    }


    /**
     * @return 公司详细
     */
    @SystemControllerLog(description = "公司详细")
    @RequestMapping(value = "/ent/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public ModelAndView preview(@PathVariable("businessKey") String businessKey) {

        ModelAndView modelAndView = new ModelAndView("/hr/company/detail");
        String companyId = Base64Utils.decode(businessKey);
        EntCompany entCompany = entCompanySrvImpl.queryInfoByNatrualKey(companyId);
        entCompany.setCompanyId(businessKey);
        modelAndView.addObject("entCompany", entCompany);
        return modelAndView;

    }

    /**
     * @return 显示企业修改页面
     */
    @SystemControllerLog(description = "显示企业修改页面")
    @RequestMapping(value = "/company_edit", method = RequestMethod.GET)
    public ModelAndView position_edit() {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        String bussId = getBussIdSession();

        EntCompany entCompany;
        entCompany = entCompanySrvImpl.queryInfoByNatrualKey(bussId);

        ModelAndView modelAndView;

        modelAndView = new ModelAndView("/hr/company/edit");
        modelAndView.addObject("entCompany", entCompany);
        return modelAndView;
    }


    /**
     * @param entCompany
     * @return
     */
    @SystemControllerLog(description = "上传企业营业执照")
    @RequestMapping(value = "/to_auth", method = RequestMethod.PUT)
    public Response toAuth(@RequestBody EntCompany entCompany) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        entCompanySrvImpl.toAuth(entCompany);
        Response response = buildResponse(entCompany);
        return response;
    }


    /**
     * @return 显示企业修改页面
     */
    @SystemControllerLog(description = "显示企业认证页面")
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView auth() {

        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();

        String bussId = getBussIdSession();

        ModelAndView modelAndView;

        EntCompany entCompany;

        entCompany = entCompanySrvImpl.queryInfoByNatrualKey(bussId);

        modelAndView = new ModelAndView("/hr/company/auth");
        modelAndView.addObject("entCompany", entCompany);

        return modelAndView;
    }


    /**
     * @return 显示企业修改页面
     */
    @SystemControllerLog(description = "显示上传企业营业执照成功的页面")
    @RequestMapping(value = "/auth_success", method = RequestMethod.GET)
    public ModelAndView auth_success() {
        ModelAndView modelAndView = new ModelAndView("/hr/company/authSuccess");
        return modelAndView;
    }

}
