package com.cnfwsy.interfaces.controller.ent;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.ent.EntCompany;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import com.cnfwsy.interfaces.bean.ent.EntJobtype;
import com.cnfwsy.interfaces.bean.sys.SysDictionary;
import com.cnfwsy.interfaces.model.ent.IEntCompanySrv;
import com.cnfwsy.interfaces.model.ent.IEntJobinfoSrv;
import com.cnfwsy.interfaces.model.ent.IEntJobtypeSrv;
import com.cnfwsy.interfaces.model.sys.ISysDictionarySrv;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static com.cnfwsy.core.api.UserSessionUtils.getBussIdSession;
import static com.cnfwsy.core.api.UserSessionUtils.judgeIsEntAccount;

/**
 * 接口层
 * Created by zhangjh on 2016-7-20 15:21:09
 */
@RestController
public class EntJobinfoController extends BaseController<EntJobinfo> {

    @Resource(name = "entJobinfoSrvImpl")
    private IEntJobinfoSrv entJobinfoSrvImpl;
    @Resource(name = "entCompanySrvImpl")
    private IEntCompanySrv entCompanySrvImpl;
    @Resource(name = "entJobtypeSrvImpl")
    private IEntJobtypeSrv entJobtypeSrvImpl;
    @Resource(name = "sysDictionarySrvImpl")
    private ISysDictionarySrv sysDictionarySrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增职位")
    @RequestMapping(value = "/entJobinfo", method = RequestMethod.POST)
    public Response create(@Valid @RequestBody EntJobinfo entJobinfo) {

        String bussId = getBussIdSession();
        entJobinfo.setCompanyId(bussId);
        entJobinfoSrvImpl.add(entJobinfo);
        entJobinfo.setJobId(Base64Utils.encode(entJobinfo.getJobId()));
        Response response = buildResponse(entJobinfo);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/entJobinfo/{businessKey}", method = RequestMethod.GET)
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        EntJobinfo entJobinfo = entJobinfoSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(entJobinfo);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/entJobinfo/{businessKey}", method = RequestMethod.DELETE)
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        EntJobinfo entJobinfo = null;
        entJobinfoSrvImpl.del(businessKey);
        Response response = buildResponse(entJobinfo);
        return response;

    }

    /**
     * @param entJobinfo
     * @return
     */
    @SystemControllerLog(description = "更新职位")
    @RequestMapping(value = "/entJobinfo/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EntJobinfo entJobinfo) {
        //权限校验：是否是该公司所属的hr
//        entCompanyServiceImpl.isHrSelf();
        String jobId = Base64Utils.decode(entJobinfo.getJobId());
        entJobinfo.setJobId(jobId);
        entJobinfoSrvImpl.edit(entJobinfo);
        Response response = buildResponse(entJobinfo);
        return response;

    }

    /**
     * @param infos List<EntJobinfo>
     * @return
     */
    @SystemControllerLog(description = "批量更新职位")
    @RequestMapping(value = "/entJobinfo", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EntJobinfo> infos) {

        entJobinfoSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询职位列表-企业管理")
    @RequestMapping(value = "/entJobinfos", method = RequestMethod.POST)
    public Response search(HttpServletRequest request, @RequestBody EntJobinfo entJobinfo) {
        judgeIsEntAccount();
        if (StringUtils.isNotBlank(entJobinfo.getCompanyId())) {
            String companyId = Base64Utils.decode(entJobinfo.getCompanyId());
            entJobinfo.setCompanyId(companyId);
        }
        if (StringUtils.isNotBlank(entJobinfo.getJobId())) {
            String jobId = Base64Utils.decode(entJobinfo.getJobId());
            entJobinfo.setJobId(jobId);
        }
        Response response = buildSearchJsonMap(entJobinfo, request, entJobinfoSrvImpl);
        return response;

    }




    /**
     * @return 职位详细
     */
    @SystemControllerLog(description = "职位详细")
    @RequestMapping(value = "/job/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public ModelAndView jobDetail(@PathVariable("businessKey") String businessKey) {

        EntJobinfo entJobinfo = entJobinfoSrvImpl.queryInfoById(businessKey);

        String isEntAccount = "0";
        try {
            isEntAccount = judgeIsEntAccount() ? "1" : "0";
        } catch (Exception e) {

        }
        ModelAndView modelAndView = new ModelAndView("/hr/position/detail");
        modelAndView.addObject("entJobinfo", entJobinfo);
        modelAndView.addObject("apply", isEntAccount);
        return modelAndView;
    }


    /**
     * @return 职位预览
     */
    @SystemControllerLog(description = "职位预览")
    @RequestMapping(value = "/entJobPreview/{businessKey}", method = RequestMethod.GET)
    public ModelAndView jobPreview(@PathVariable("businessKey") String businessKey) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        ModelAndView modelAndView = new ModelAndView("/hr/position/preview");
        String jobId = Base64Utils.decode(businessKey);
        EntJobinfo entJobinfo = entJobinfoSrvImpl.queryInfoByNatrualKey(jobId);
        EntCompany entCompany = entCompanySrvImpl.queryInfoByNatrualKey(entJobinfo.getCompanyId().toString());
        entCompany.setCompanyId(Base64Utils.encode(entCompany.getCompanyId()));
        entJobinfo.setEntCompany(entCompany);
        entJobinfo.setJobId(businessKey);
        modelAndView.addObject("entJobinfo", entJobinfo);
        modelAndView.addObject("apply", "0");
        return modelAndView;
    }


    /**
     * @return 显示发布职位页面
     */
    @SystemControllerLog(description = "显示发布职位页面")
    @RequestMapping(value = "/issue", method = RequestMethod.GET)
    public ModelAndView jobIssue() {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        boolean isComInfoCompleted = entCompanySrvImpl.isComInfoCompleted();
        ModelAndView modelAndView;
        if (isComInfoCompleted) {
            modelAndView = new ModelAndView("/hr/position/issue");
        } else {
            modelAndView = new ModelAndView("redirect:/company_edit");
        }
        EntJobtype entJobtype = new EntJobtype();
        entJobtype.setPageSize(200);
        entJobtype.setStart(0);
        entJobtype.setDelFlag("0");
        List<EntJobtype> entJobtypes = entJobtypeSrvImpl.searchInfos(entJobtype);
        modelAndView.addObject("entJobtypes", entJobtypes);
        SysDictionary dictionary = new SysDictionary();
        dictionary.setPageSize(200);
        dictionary.setStart(0);
        List<SysDictionary> dicts = sysDictionarySrvImpl.searchInfos(dictionary);
        modelAndView.addObject("dicts", dicts);
        String bussId = getBussIdSession();
        EntCompany entCompany = entCompanySrvImpl.queryInfoByNatrualKey(bussId);
        entCompany.setCompanyId(Base64Utils.encode(bussId));
        modelAndView.addObject("entCompany", entCompany);
        modelAndView.addObject("company_id", bussId);
        return modelAndView;
    }


    /**
     * @return 编辑发布职位
     */
    @SystemControllerLog(description = "编辑发布职位")
    @RequestMapping(value = "/edit/{businessKey}", method = RequestMethod.GET)
    public ModelAndView jobEdit(@PathVariable("businessKey") String businessKey) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        ModelAndView modelAndView = new ModelAndView("/hr/position/issue");
        String jobId = Base64Utils.decode(businessKey);
        EntJobinfo entJobinfo = entJobinfoSrvImpl.queryInfoByNatrualKey(jobId);
        entJobinfo.setJobId(businessKey);
        modelAndView.addObject("entJobinfo", entJobinfo);
        EntJobtype entJobtype = new EntJobtype();
        entJobtype.setPageSize(200);
        entJobtype.setStart(0);
        entJobtype.setDelFlag("0");
        List<EntJobtype> entJobtypes = entJobtypeSrvImpl.searchInfos(entJobtype);
        modelAndView.addObject("entJobtypes", entJobtypes);
        SysDictionary dictionary = new SysDictionary();
        dictionary.setPageSize(200);
        dictionary.setStart(0);
        List<SysDictionary> dicts = sysDictionarySrvImpl.searchInfos(dictionary);
        modelAndView.addObject("dicts", dicts);
        EntCompany entCompany = entCompanySrvImpl.queryInfoByNatrualKey(entJobinfo.getCompanyId().toString());
        entCompany.setCompanyId(Base64Utils.encode(businessKey));
        modelAndView.addObject("entCompany", entCompany);
        modelAndView.addObject("company_id", entCompany.getCompanyId());

        return modelAndView;
    }


    /**
     * @return 职位跳转
     */
    @SystemControllerLog(description = "职位跳转")
    @RequestMapping(value = "/mypositions/{online}", method = RequestMethod.GET)
    public ModelAndView positionStatus(@PathVariable("online") String online) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        ModelAndView modelAndView = new ModelAndView("/hr/position/myposition");
        String bussId = Base64Utils.encode(getBussIdSession());
        modelAndView.addObject("company_id", bussId);
        modelAndView.addObject("online", online);
        return modelAndView;
    }

    /**
     * @return 简历跳转
     */
    @SystemControllerLog(description = "简历跳转")
    @RequestMapping(value = "/myresumes/{status}", method = RequestMethod.GET)
    public ModelAndView resumeStatus(@PathVariable("status") String status) {
        //权限校验：是否是该公司所属的hr
        entCompanySrvImpl.isHrSelf();
        ModelAndView modelAndView = new ModelAndView("/hr/position/myresumes");
        String bussId = Base64Utils.encode(getBussIdSession());
        modelAndView.addObject("company_id", bussId);
        modelAndView.addObject("status", status);
        return modelAndView;
    }

}
